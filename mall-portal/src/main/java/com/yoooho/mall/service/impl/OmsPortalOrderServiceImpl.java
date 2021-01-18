package com.yoooho.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.utils.DateUtils;
import com.yoooho.mall.common.utils.ImageUtils;
import com.yoooho.mall.component.CancelPinkSender;
import com.yoooho.mall.domain.*;
import com.yoooho.mall.domain.*;
import com.yoooho.mall.domian.AliyunossConfig;
import com.yoooho.mall.express.dao.ExpressInfo;
import com.yoooho.mall.express.service.OrderExpressService;
import com.yoooho.mall.mapper.*;

import com.yoooho.mall.component.CancelOrderSender;
import com.yoooho.mall.dao.PortalOrderDao;
import com.yoooho.mall.dao.PortalOrderItemDao;
import com.yoooho.mall.dao.SmsCouponHistoryDao;
import com.yoooho.mall.model.*;
import com.yoooho.mall.service.*;
import com.yoooho.mall.service.*;
import com.yoooho.mall.service.Impl.TemplateService;
import com.yoooho.mall.mapper.*;
import com.yoooho.mall.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 前台订单管理Service
 * Created by yoooho on 2019/8/30.
 */
@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    @Autowired
    private UmsMemberWxofficeMapper memberWxofficeMapper;

    @Autowired
    private TemplateService templateService;

    @Autowired
    OmsOrderFaceMapper orderFaceMapper;
    @Autowired
    AliyunOSSService aliyunOSSService;
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private OmsCartItemService cartItemService;
    @Autowired
    private AliPayOrderService aliPayService;
    @Autowired
    private WXPayService wxPayService;

    @Autowired
    private UmsMemberReceiveAddressService memberReceiveAddressService;
    @Autowired
    private UmsMemberCouponService memberCouponService;
    @Autowired
    private UmsIntegrationConsumeSettingMapper integrationConsumeSettingMapper;
    @Autowired
    private PmsSkuStockMapper skuStockMapper;
    @Autowired
    private SmsCouponHistoryDao couponHistoryDao;
    @Autowired
    private OmsOrderMapper orderMapper;
    @Autowired
    private PortalOrderItemDao orderItemDao;
    @Autowired
    private SmsCouponHistoryMapper couponHistoryMapper;
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.orderId}")
    private String REDIS_KEY_PREFIX_ORDER_ID;
    @Autowired
    private PortalOrderDao portalOrderDao;
    @Autowired
    private OmsOrderSettingMapper orderSettingMapper;
    @Autowired
    private OmsOrderItemMapper orderItemMapper;
    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Autowired
    private CancelPinkSender cancelPinkSender;

    @Autowired
    private OmsOrderItemMapper omsOrderItemMapper;

    @Autowired
    private SmsCouponMapper couponMapper;

    @Autowired
    private UmsAdminSettingMapper umsAdminSettingMapper;

    @Autowired
    private  PmsProductSeckillMapper productSeckillMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private
    PmsProductCombinationMapper productCombinationMapper;

    @Autowired
    private
    OmsPinkBuyerMapper pinkBuyerMapper;

    @Autowired
    private
    OmsPinkMapper pinkMapper;

    @Autowired
    SeckillProductServer seckillProductServer;

    @Autowired
    PinkService pinkService;

    @Autowired
    OmsOrderRefundService orderRefundService;

    @Autowired
    OrderExpressService orderExpressService;

    @Autowired
    PmsStoreMapper pmsStoreMapper;

    @Autowired
    PmsStoreStaffMapper pmsStoreStaffMapper;

    public  List<CartPromotionItem> cartPromotionItemListOrderId(Long orderId) {
        List<CartPromotionItem> cartPromotionItemList = new ArrayList<>();
        List<OmsOrderItem> orderItemList = new ArrayList();
        OmsOrderItemExample example = new OmsOrderItemExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        orderItemList = omsOrderItemMapper.selectByExample(example);
        for (OmsOrderItem orderItem : orderItemList) {
            CartPromotionItem cartPromotionItem = new CartPromotionItem();
            cartPromotionItem.setPrice(orderItem.getProductPrice());
            cartPromotionItem.setQuantity(orderItem.getProductQuantity());
            cartPromotionItem.setProductId(orderItem.getProductId());
            cartPromotionItem.setPromotionMessage(orderItem.getPromotionName());
            cartPromotionItem.setReduceAmount(orderItem.getPromotionAmount());
            cartPromotionItem.setProductName(orderItem.getProductName());
            cartPromotionItem.setProductPic(orderItem.getProductPic());
            cartPromotionItemList.add(cartPromotionItem);
        }
        return cartPromotionItemList;
    }

    @Override
    public Object getFaceOrder(Long orderId) {

        OrderDetail orderDetail = new OrderDetail();
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        orderDetail.setOrder(order);
        //商品
        OmsOrderItemExample example = new OmsOrderItemExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        List<OmsOrderItem> orderItems = orderItemMapper.selectByExample(example);
        orderDetail.setOrderItems(orderItems);

       OmsOrderFaceExample orderFaceExample = new OmsOrderFaceExample();
       orderFaceExample.createCriteria().andOrderIdEqualTo(orderId);
       List <OmsOrderFace> omsOrderFaces = orderFaceMapper.selectByExample(orderFaceExample);
       OmsOrderFace orderFace = omsOrderFaces.get(0);
       Map map = new HashMap();
       map.put("orderDetail",orderDetail);
       map.put("orderFace",orderFace);
       return map;
    }

    @Override
    public Object generateFaceOrder(Long orderId) {
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            return CommonResult.failed("无此订单");
        }
        if (order.getShoppingType() != 2) {
            return CommonResult.failed("此订单不支持");
        }

        AliyunossConfig aliyunossConfig = (AliyunossConfig) aliyunOSSService.find();
        if (aliyunossConfig == null) {
            return CommonResult.failed();
        }

        order.setFacePay(true);
        order.setStatus(2);
        orderMapper.updateByPrimaryKey(order);

        //生成二维码


        byte[] pngData = ImageUtils.creatQRCodeImage(order.getOrderSn());
        String name = "orderface_"+order.getOrderSn()+".PNG";
        aliyunOSSService.uploadByte(pngData,aliyunossConfig,aliyunossConfig.getPrefix()+"/"+ name);
        //图片链接
        String http = "http://", https = "https://";
       String url;
        if (aliyunossConfig.getHost()!= null && (aliyunossConfig.getHost().toLowerCase().startsWith(http) || aliyunossConfig.getHost().toLowerCase().startsWith(https))) {
            url= aliyunossConfig.getHost() + "/"+  aliyunossConfig.getPrefix()+"/"+ name;
        }else {
            url = https +aliyunossConfig.getEndpoint() + "/"+  aliyunossConfig.getPrefix()+"/"+ name;
        }
        OmsOrderFaceExample omsOrderFaceExample = new OmsOrderFaceExample();
         omsOrderFaceExample.createCriteria().andOrderIdEqualTo(orderId);
        List<OmsOrderFace> omsOrderFaces = orderFaceMapper.selectByExample(omsOrderFaceExample);
        OmsOrderFace omsOrderFace = new OmsOrderFace();
        omsOrderFace.setCreateTime(new Date());
        omsOrderFace.setOrderSn(order.getOrderSn());
        omsOrderFace.setOrderId(orderId);
        omsOrderFace.setMemberId(order.getMemberId());
        omsOrderFace.setRqUrl(url);
        if (omsOrderFaces.size() == 0) {
            orderFaceMapper.insertSelective(omsOrderFace);
        }else {
            orderFaceMapper.updateByPrimaryKeySelective(omsOrderFace);
        }
        //写入数据库

        //通知
        orderSuccessNotice(order);
        return CommonResult.success(url);
    }

    @Override
    public ConfirmOrderResult generateConfirmOrder(List<Long> ids, Integer orderType, Long orderId) {
        ConfirmOrderResult result = new ConfirmOrderResult();
        UmsMember currentMember = memberService.getCurrentMember();
        //正常订单
        if (orderType == 0) {
           //获取购物车信息
            List<CartPromotionItem> cartPromotionItemList = new ArrayList<>();
            if (ids !=null && ids.size() > 0) {
                cartPromotionItemList = cartItemService.listPromotion(currentMember.getId(),ids);
            }else{
              cartPromotionItemList = cartPromotionItemListOrderId(orderId);
            }
            result.setCartPromotionItemList(cartPromotionItemList);
            //获取用户可用优惠券列表
            List<SmsCouponHistoryDetail> couponHistoryDetailList = memberCouponService.listCart(cartPromotionItemList, 1);
            result.setCouponHistoryDetailList(couponHistoryDetailList);
            //计算总金额、活动优惠、应付金额
            ConfirmOrderResult.CalcAmount calcAmount = calcCartAmount(cartPromotionItemList);
            result.setCalcAmount(calcAmount);
            //获取用户积分
            result.setMemberIntegration(currentMember.getIntegration());
            //获取积分使用规则
            UmsIntegrationConsumeSetting integrationConsumeSetting = integrationConsumeSettingMapper.selectByPrimaryKey(1L);
            result.setIntegrationConsumeSetting(integrationConsumeSetting);
        }
        //秒杀订单 开团订单
        if (orderType == 1|| orderType == 2) {
            OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
            List<CartPromotionItem> cartPromotionItemList = new ArrayList<>();
            cartPromotionItemList = cartPromotionItemListOrderId(orderId);
            result.setCartPromotionItemList(cartPromotionItemList);
            ConfirmOrderResult.CalcAmount calcAmount = new ConfirmOrderResult.CalcAmount();
            calcAmount.setFreightAmount(new BigDecimal(0));
            BigDecimal promotionAmount = new BigDecimal("0");
            calcAmount.setPayAmount(order.getPayAmount());
            calcAmount.setTotalAmount(cartPromotionItemList.get(0).getPrice());
            calcAmount.setPromotionAmount(promotionAmount);
            result.setCalcAmount(calcAmount);
        }
        //获取用户收货地址列表
        List<UmsMemberReceiveAddress> memberReceiveAddressList = memberReceiveAddressService.list();
        CartPromotionItem cartPromotionItem = new CartPromotionItem();
        cartPromotionItem.setQuantity(1);
        result.setMemberReceiveAddressList(memberReceiveAddressList);
        return result;
    }

    @Override
    public CommonResult generateOrder(List<Long> ids) {
        UmsMember currentMember = memberService.getCurrentMember();
        List<OmsOrderItem> orderItemList = new ArrayList<>();
        //生成订单
        UmsMemberReceiveAddress address = memberReceiveAddressService.getDefaultAddress(currentMember.getId());
        Long addressId = Long.valueOf(-1);
        if (address != null) {
           addressId = address.getId();
        }
        List<CartPromotionItem> cartPromotionItemList = cartItemService.listPromotion(currentMember.getId(),ids);
        //判断购物车中商品是否都有库存
        if (!hasStock(cartPromotionItemList)) {
            return CommonResult.failed("库存不足，无法下单");
        }

        //进行库存锁定
        lockStock(cartPromotionItemList);
        OmsOrder order = generateCommonOrderInfo(addressId,currentMember);
        for (CartPromotionItem cartPromotionItem : cartPromotionItemList) {
            //生成下单商品信息
            OmsOrderItem orderItem = new OmsOrderItem();
            orderItem.setProductId(cartPromotionItem.getProductId());
            orderItem.setProductName(cartPromotionItem.getProductName());
            orderItem.setProductPic(cartPromotionItem.getProductPic());
            orderItem.setProductAttr(cartPromotionItem.getProductAttr());
            orderItem.setProductBrand(cartPromotionItem.getProductBrand());
            orderItem.setProductSn(cartPromotionItem.getProductSn());
            orderItem.setProductPrice(cartPromotionItem.getPrice());
            orderItem.setProductQuantity(cartPromotionItem.getQuantity());
            orderItem.setProductSkuId(cartPromotionItem.getProductSkuId());
            orderItem.setProductSkuCode(cartPromotionItem.getProductSkuCode());
            orderItem.setProductCategoryId(cartPromotionItem.getProductCategoryId());
            orderItem.setPromotionAmount(cartPromotionItem.getReduceAmount());
            orderItem.setPromotionName(cartPromotionItem.getPromotionMessage());
            orderItem.setGiftIntegration(cartPromotionItem.getIntegration());
            orderItem.setGiftGrowth(cartPromotionItem.getGrowth());
            orderItem.setCouponAmount(new BigDecimal(0));
            orderItem.setIntegrationAmount(new BigDecimal(0));
            orderItemList.add(orderItem);
        }
        //计算order_item的实付金额
        handleRealAmount(orderItemList);
        order.setPromotionAmount(calcPromotionAmount(orderItemList));
        order.setCouponAmount(new BigDecimal(0));
        order.setTotalAmount(calcTotalAmount(orderItemList));
        order.setFreightAmount(new BigDecimal(0));
        //计算赠送积分
        order.setIntegration(calcGifIntegration(orderItemList));
        //计算赠送成长值
        order.setGrowth(calcGiftGrowth(orderItemList));
        //订单类型：0->正常订单；1->秒杀订单
        order.setOrderType(0);
        order.setPayType(0);
        //插入order表和order_item表
        orderMapper.insertSelective(order);
        for (OmsOrderItem orderItem : orderItemList) {
            orderItem.setOrderId(order.getId());
            orderItem.setOrderSn(order.getOrderSn());
        }
        orderItemDao.insertList(orderItemList);
        //删除购物车中的下单商品
        deleteCartItemList(cartPromotionItemList, currentMember);
        //订单超时设置
        sendDelayMessageCancelOrder(order);
        Map<String, Object> result = new HashMap<>();
        result.put("order", order);
        result.put("orderItemList", orderItemList);
        return CommonResult.success(result, "下单成功");
    }

    @Override
    public Object updateOrderInfo(OrderParam orderParam) {
        UmsMember currentMember = memberService.getCurrentMember();
        SmsCoupon coupon = null;
        List<OmsOrderItem> orderItemList = new ArrayList<>();
        OmsOrder order = orderMapper.selectByPrimaryKey(orderParam.getOrderId());
        if (order == null || order.getPayType() !=0 ) {
            return CommonResult.failed("订单不能更新");
        }
        OmsOrderItemExample example = new OmsOrderItemExample();
        example.createCriteria().andOrderIdEqualTo(orderParam.getOrderId());
        orderItemList = omsOrderItemMapper.selectByExample(example);
        //构造购物车信息
        List<CartPromotionItem> cartPromotionItemList = new ArrayList<>();
        for (OmsOrderItem orderItem : orderItemList) {
            CartPromotionItem cartPromotionItem = new CartPromotionItem();
            cartPromotionItem.setPrice(orderItem.getProductPrice());
            cartPromotionItem.setQuantity(orderItem.getProductQuantity());
            cartPromotionItem.setProductId(orderItem.getProductId());
            cartPromotionItem.setPromotionMessage(orderItem.getPromotionName());
            cartPromotionItem.setReduceAmount(orderItem.getPromotionAmount());
            cartPromotionItemList.add(cartPromotionItem);
        }
        //判断使用使用了优惠券
        if (orderParam.isUserCoupon() == false) {
            //不用优惠券
            for (OmsOrderItem orderItem : orderItemList) {
                orderItem.setCouponAmount(new BigDecimal(0));
            }
        }else {
            //使用优惠券
            SmsCouponHistoryDetail couponHistoryDetail = getUseCoupon(cartPromotionItemList, orderParam.getCouponId());
            if (couponHistoryDetail == null) {
                return CommonResult.failed("该优惠券不可用");
            }
            coupon = couponMapper.selectByPrimaryKey(orderParam.getCouponId());
            if (calcTotalAmount(orderItemList).intValue()<coupon.getMinPoint().intValue()){
                return CommonResult.failed("金额不够,该优惠券不可用");
            }
            //对下单商品的优惠券进行处理
            handleCouponAmount(orderItemList, couponHistoryDetail);
        }
        //判断是否使用积分
        if (orderParam.getUseIntegration() == null) {
            //不使用积分
            for (OmsOrderItem orderItem : orderItemList) {
                orderItem.setIntegrationAmount(new BigDecimal(0));
            }
        } else {
            //使用积分
            BigDecimal totalAmount = calcTotalAmount(orderItemList);
            BigDecimal integrationAmount = getUseIntegrationAmount(orderParam.getUseIntegration(), totalAmount, currentMember, orderParam.getCouponId() != null);
            if (integrationAmount.compareTo(new BigDecimal(0)) == 0) {
                return CommonResult.failed("积分不可用");
            } else {
                //可用情况下分摊到可用商品中
                for (OmsOrderItem orderItem : orderItemList) {
                    BigDecimal perAmount = orderItem.getProductPrice().divide(totalAmount, 3, RoundingMode.HALF_EVEN).multiply(integrationAmount);
                    orderItem.setIntegrationAmount(perAmount);
                }
            }
        }
         //根据商品合计、运费、活动优惠、优惠券、积分计算应付金额
        if (coupon != null) {
            order.setCouponAmount(coupon.getAmount());
        }
        if (orderParam.getCouponId() == null) {
            order.setCouponAmount(new BigDecimal(0));
        } else {
            order.setCouponId(orderParam.getCouponId());
            order.setCouponAmount(calcCouponAmount(orderItemList));
        }
        if (orderParam.getUseIntegration() == null) {
            order.setIntegration(0);
            order.setIntegrationAmount(new BigDecimal(0));
        } else {
            order.setIntegration(orderParam.getUseIntegration());
            order.setIntegrationAmount(calcIntegrationAmount(orderItemList));
        }
        //计算赠送积分
        order.setIntegration(calcGifIntegration(orderItemList));
        //计算赠送成长值
        order.setGrowth(calcGiftGrowth(orderItemList));
        order.setPromotionInfo(getOrderPromotionInfo(orderItemList));
        order.setTotalAmount(calcTotalAmount(orderItemList));
        order.setFreightAmount(new BigDecimal(0));
        order.setPromotionInfo(getOrderPromotionInfo(orderItemList));
        order.setNote(orderParam.getNote());
        order.setPromotionAmount(calcPromotionAmount(orderItemList));
        order.setShoppingType(orderParam.getShoppingType());
        order.setStoreId(orderParam.getStoreId());
        if (order.getOrderType() == 0) {
            order.setPayAmount(calcPayAmount(order));
        }
        order.setNote(orderParam.getNote());

        //收货地址设置
        if (order.getShoppingType() == 1) {
            UmsMember member = memberService.getCurrentMember();
            UmsMemberReceiveAddress address = memberReceiveAddressService.getItem(orderParam.getMemberReceiveAddressId(),member.getId());
            order.setReceiverName(address.getName());
            order.setReceiverPhone(address.getPhoneNumber());
            order.setReceiverPostCode(address.getPostCode());
            order.setReceiverProvince(address.getProvince());
            order.setReceiverCity(address.getCity());
            order.setReceiverRegion(address.getRegion());
            order.setReceiverDetailAddress(address.getDetailAddress());
        }
        //自提门店设置
        if (order.getShoppingType() == 2) {
            order.setStoreId(orderParam.getStoreId());
        }
        orderMapper.updateByPrimaryKeySelective(order);
        for (OmsOrderItem orderItem : orderItemList) {
            orderItemMapper.updateByPrimaryKeySelective(orderItem);
        }
        Map<String, Object> result = new HashMap<>();
        result.put("order", order);
        result.put("orderItemList", orderItemList);
        return CommonResult.success(result, "更新订单成功");
    }

    @Override
    public Object getOrderInfo(Long orderId) {
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        List<OmsOrderItem> orderItemList = new ArrayList<>();
        OmsOrderItemExample example = new OmsOrderItemExample();
        example.createCriteria().andOrderIdEqualTo(orderId);
        orderItemList = omsOrderItemMapper.selectByExample(example);
        Map<String, Object> result = new HashMap<>();
        if (order.getShoppingType() == 2) {
           PmsStore store = pmsStoreMapper.selectByPrimaryKey(order.getStoreId());
           result.put("storeInfo",store);
            OmsOrderFaceExample orderFaceExample = new OmsOrderFaceExample();
            orderFaceExample.createCriteria().andOrderIdEqualTo(orderId);
            List <OmsOrderFace> omsOrderFaces = orderFaceMapper.selectByExample(orderFaceExample);
            OmsOrderFace orderFace = omsOrderFaces.get(0);
            result.put("orderFace",orderFace);
        }
        result.put("order", order);
        result.put("orderItemList", orderItemList);
        return CommonResult.success(result);
    }

    @Override
    public CommonResult generateKillOrder(KillOrderParam orderParam) {
        Long id = orderParam.getId();
        PmsProductSeckill productSeckill = productSeckillMapper.selectByPrimaryKey(id);
        //判断是否有库存
        try {
            if (!seckillProductServer.killProductIsKilling(id,orderParam.getUserId())) {
                return CommonResult.failed("库存不足，无法下单");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //判断是否超过秒杀数量了
        List<OmsOrderDetail> orderDetails = portalOrderDao.getKillOrdersByMemberId(id, orderParam.getUserId());
        if (orderDetails !=null) {
            int cout = 0;

            for (int i = 0; i <orderDetails.size() ; i++) {
                if (!(orderDetails.get(i).getStatus() == 4 || orderDetails.get(i).getStatus() == 5)){
                    List items =  orderDetails.get(i).getOrderItemList();
                    cout = cout + items.size();
                }

            }
            if (productSeckill.getNum() <= cout){
                return CommonResult.failed("该件商品您已经到达秒杀数量，不能再进行秒杀");
            }
        }

        //进行锁库
        productSeckill.setLockStock(productSeckill.getLockStock() + 1);
        productSeckillMapper.updateByPrimaryKeyWithBLOBs(productSeckill);
        List<OmsOrderItem> orderItemList = new ArrayList<>();

        //生成订单
        UmsMemberReceiveAddress address = memberReceiveAddressService.getDefaultAddress(orderParam.getUserId());
        Long addressId = Long.valueOf(-1);
        if (address != null) {
            addressId = address.getId();
        }

        //生成下单商品信息
        OmsOrderItem orderItem = new OmsOrderItem();
        orderItem.setKillId(productSeckill.getId());
        orderItem.setProductId(productSeckill.getProductId());
        orderItem.setProductName(productSeckill.getName());
        orderItem.setProductPic(productSeckill.getPic());
        orderItem.setRealAmount(productSeckill.getPrice());
        orderItem.setProductPrice(productSeckill.getOriginalPrice());
        orderItem.setProductQuantity(1);
        orderItem.setGiftIntegration(productSeckill.getGiftPoint());
        orderItem.setKillId(productSeckill.getId());
        orderItem.setPromotionName("秒杀活动");
        orderItem.setPromotionAmount(productSeckill.getPrice());
        orderItem.setCouponAmount(new BigDecimal(0));
        orderItem.setIntegrationAmount(new BigDecimal(0));

       UmsMember member =  memberService.getById(orderParam.getUserId());
        //生成订单
        OmsOrder order = generateCommonOrderInfo(addressId,member);

        //支付方式：0->未支付；1->支付宝；2->微信
        order.setPayType(0);

        order.setTotalAmount(calcTotalAmount(orderItemList));
        order.setFreightAmount(new BigDecimal(0));
        order.setPromotionAmount(calcPromotionAmount(orderItemList));
        order.setPromotionInfo(getOrderPromotionInfo(orderItemList));
        order.setNote(orderParam.getNote());
        order.setKillId(productSeckill.getId());
        order.setPromotionInfo("秒杀活动");
        //订单类型：0->正常订单；1->秒杀订单
        order.setOrderType(1);
        order.setPromotionAmount(productSeckill.getPrice());
        order.setPayAmount(productSeckill.getPrice());
        //计算赠送积分
        order.setIntegration(productSeckill.getGiftPoint());
        //计算赠送成长值
        order.setGrowth(0);
        orderMapper.insertSelective(order);
        orderItem.setOrderId(order.getId());
        orderItem.setOrderSn(order.getOrderSn());
        omsOrderItemMapper.insertSelective(orderItem);
        orderItemList.add(orderItem);
        sendDelayMessageCancelOrder(order);
        Map<String, Object> result = new HashMap<>();
        result.put("order", order);
        result.put("orderItemList", orderItemList);
        return CommonResult.success(result, "下单成功");
    }

    @Override
    public CommonResult generatePinkOrder(PinkOrderParam orderParam) {

        UmsMember currentMember = memberService.getById(orderParam.getUserId());
        Long id = orderParam.getId();
        PmsProductCombination productCombination = productCombinationMapper.selectByPrimaryKey(id);

        //直接开团
        if (orderParam.getPinkType() == 0) {
            if (!pinkService.canNewPink(orderParam.getId())) {
                return CommonResult.failed("库存数量不支持开新的团");
            }
        }

        //拼团
        if (orderParam.getPinkType() == 1) {
            //判断开团人数是否满了
            if (!pinkService.canPink(orderParam.getPinkId())){
                return CommonResult.failed("这个团已满");
            }
        }

        //进行锁库
        productCombination.setLockStock(productCombination.getLockStock() + 1);
        productCombinationMapper.updateByPrimaryKeyWithBLOBs(productCombination);
        List<OmsOrderItem> orderItemList = new ArrayList<>();

        //生成下单商品信息
        OmsOrderItem orderItem = new OmsOrderItem();
        orderItem.setPinkId(productCombination.getId());
        orderItem.setProductId(productCombination.getProductId());
        orderItem.setProductName(productCombination.getName());
        orderItem.setProductPic(productCombination.getPic());
        orderItem.setRealAmount(productCombination.getPrice());
        orderItem.setProductPrice(productCombination.getOriginalPrice());
        orderItem.setProductQuantity(1);
        orderItem.setGiftIntegration(productCombination.getGiftPoint());
        orderItem.setPromotionName("开团活动");
        orderItem.setPromotionAmount(productCombination.getPrice());
        orderItem.setCouponAmount(new BigDecimal(0));
        orderItem.setIntegrationAmount(new BigDecimal(0));

        //生成订单
        UmsMemberReceiveAddress address = memberReceiveAddressService.getDefaultAddress(orderParam.getUserId());
        Long addressId = Long.valueOf(-1);
        if (address != null) {
            addressId = address.getId();
        }

        OmsOrder order = generateCommonOrderInfo(addressId, currentMember);
        //支付方式：0->未支付；1->支付宝；2->微信
        order.setPayType(0);

        order.setTotalAmount(calcTotalAmount(orderItemList));
        order.setFreightAmount(new BigDecimal(0));

        order.setPromotionInfo(getOrderPromotionInfo(orderItemList));
        order.setNote(orderParam.getNote());
        order.setCombinationId(productCombination.getId());
        order.setPromotionInfo("团购活动");
        //订单类型：0->正常订单；1->秒杀订单 ；2->团购订单
        order.setOrderType(2);
        order.setPromotionAmount(productCombination.getPrice());
        order.setPayAmount(productCombination.getPrice());
        //计算赠送积分
        order.setIntegration(productCombination.getGiftPoint());
        //计算赠送成长值
        order.setGrowth(0);
        orderMapper.insertSelective(order);
        orderItem.setOrderId(order.getId());
        orderItem.setOrderSn(order.getOrderSn());
        omsOrderItemMapper.insertSelective(orderItem);
        orderItemList.add(orderItem);

        Long pinkId = null;
        if (orderParam.getPinkType() == 0) {

            OmsPink pink = new OmsPink();

            pink.setCid(productCombination.getId());
            pink.setPeople(productCombination.getPeople());
            pink.setPid(productCombination.getProductId());
            pink.setkId(currentMember.getId());
            pink.setStatus(0);
            pink.setPrice(productCombination.getOriginalPrice());
            pink.setOrderId(order.getId());
            pinkMapper.insertSelective(pink);
            pinkId = pink.getId();

        }
        if (orderParam.getPinkType() == 1) {
            pinkId = orderParam.getPinkId();
        }
        //新增开团人数

        OmsPinkBuyer pinkBuyer = new OmsPinkBuyer();
        pinkBuyer.setBuyerId(currentMember.getId());
        pinkBuyer.setBuyerName(currentMember.getNickname());
        pinkBuyer.setBuyerIcon(currentMember.getIcon());
        pinkBuyer.setIsRefund(false);
        pinkBuyer.setIsTpl(false);
        pinkBuyer.setPinkPrice(productCombination.getPrice());
        pinkBuyer.setPinkAmt(order.getPayAmount());
        pinkBuyer.setPinkId(productCombination.getId());
        pinkBuyer.setPinkStatus(true);
        pinkBuyer.setPinkNum(1);

        pinkBuyer.setOrderId(order.getId());
        pinkBuyer.setPinkId(pinkId);
        pinkBuyer.setPayStatus(0);
        pinkBuyerMapper.insertSelective(pinkBuyer);
        order.setPinkId(pinkId);
        orderMapper.updateByPrimaryKeySelective(order);

        sendDelayMessageCancelOrder(order);

        Map<String, Object> result = new HashMap<>();
        result.put("order", order);
        result.put("orderItemList", orderItemList);
        return CommonResult.success(result, "下单成功");

    }


    public OmsOrder generateCommonOrderInfo(Long addressId,UmsMember member){

        //收货人信息：姓名、电话、邮编、地址
        UmsMemberReceiveAddress address = memberReceiveAddressService.getItem(addressId,member.getId());
        OmsOrder order = new OmsOrder();
        //转化为订单信息并插入数据库
        order.setMemberId(member.getId());
        order.setCreateTime(new Date());
        order.setMemberUsername(member.getUsername());

        //订单来源：0->PC订单；1->app订单
        order.setSourceType(1);
        //订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
        order.setStatus(0);

        if (address != null){
            order.setReceiverName(address.getName());
            order.setReceiverPhone(address.getPhoneNumber());
            order.setReceiverPostCode(address.getPostCode());
            order.setReceiverProvince(address.getProvince());
            order.setReceiverCity(address.getCity());
            order.setReceiverRegion(address.getRegion());
            order.setReceiverDetailAddress(address.getDetailAddress());
        }

        //0->未确认；1->已确认
        order.setConfirmStatus(0);
        order.setDeleteStatus(0);
        order.setMemberDeleteStatus(0);
        order.setDiscountAmount(new BigDecimal(0));
        //生成订单号
        order.setOrderSn(generateOrderSn(order));
        order.setStatus(0);

        return order;
    }
    @Override
    public CommonResult paySuccess(String outTradeNo, String tradeNo) {
//        updateOrderByPaySuccess(outTradeNo,tradeNo,1);
        return CommonResult.success("","支付成功");
    }

    @Override
    public CommonResult cancelTimeOutOrder() {
        OmsOrderSetting orderSetting = orderSettingMapper.selectByPrimaryKey(1L);

        if (orderSetting == null) {
            return null;
        }
        //查询超时、未支付的订单及订单详情

        //普通订单
        List<OmsOrderDetail> timeOutOrders = portalOrderDao.getTimeOutOrders(orderSetting.getNormalOrderOvertime(),0);

        //秒杀订单
        timeOutOrders.addAll(portalOrderDao.getTimeOutOrders(orderSetting.getFlashOrderOvertime(),1));

//        PmsProductCombination productCombination = productCombinationMapper.selectByPrimaryKey(o)
        //拼团订单
        timeOutOrders.addAll(portalOrderDao.getTimeOutOrders(orderSetting.getPinkOrderOvertime(),2));


        if (CollectionUtils.isEmpty(timeOutOrders)) {
            return CommonResult.failed("暂无超时订单");
        }
        //修改订单状态为交易取消
        List<Long> ids = new ArrayList<>();
        for (OmsOrderDetail timeOutOrder : timeOutOrders) {
            ids.add(timeOutOrder.getId());
        }
        portalOrderDao.updateOrderStatus(ids, 4);
        for (OmsOrderDetail timeOutOrder : timeOutOrders) {

            //正常订单
            if (timeOutOrder.getOrderType() == 0) {
                //解除订单商品库存锁定
                portalOrderDao.releaseSkuStockLock(timeOutOrder.getOrderItemList());
            }

            if (timeOutOrder.getOrderType() == 1) {
                PmsProductSeckill productSeckill = productSeckillMapper.selectByPrimaryKey(timeOutOrder.getKillId());
                productSeckill.setLockStock(productSeckill.getLockStock() - 1);
                productSeckillMapper.updateByPrimaryKeyWithBLOBs(productSeckill);
            }

            if (timeOutOrder.getOrderType() == 2) {
                PmsProductCombination productCombination = productCombinationMapper.selectByPrimaryKey(timeOutOrder.getCombinationId());
                productCombination.setLockStock(productCombination.getLockStock() - 1);
                productCombinationMapper.updateByPrimaryKeyWithBLOBs(productCombination);
                OmsPinkBuyerExample pinkBuyerExample = new OmsPinkBuyerExample();
                pinkBuyerExample.createCriteria().andOrderIdEqualTo(timeOutOrder.getId()).andBuyerIdEqualTo(timeOutOrder.getMemberId());
                OmsPinkBuyer pinkBuyer = new OmsPinkBuyer();
                pinkBuyer.setPinkStatus(false);
                pinkBuyerMapper.updateByExampleSelective(pinkBuyer,pinkBuyerExample);

                OmsPinkExample omsPinkExample = new OmsPinkExample();
                omsPinkExample.createCriteria().andOrderIdEqualTo(timeOutOrder.getId());
                OmsPink pink = new OmsPink();
                pink.setStatus(3);
                pinkMapper.updateByExampleSelective(pink,omsPinkExample);
            }
            //修改优惠券使用状态
            if (timeOutOrder.getCouponId() !=null) {
                updateCouponStatus(timeOutOrder.getCouponId(), timeOutOrder.getMemberId(), 0);
            }
            //返还使用积分
            if (timeOutOrder.getUseIntegration() != null) {
                UmsMember member = memberService.getById(timeOutOrder.getMemberId());
                memberService.updateIntegration(timeOutOrder.getMemberId(), member.getIntegration() + timeOutOrder.getUseIntegration());
            }
        }
        return CommonResult.success(timeOutOrders);
    }

    @Override
    public void cancelOrder(Long orderId) {
        //查询为付款的取消订单
        OmsOrderExample example = new OmsOrderExample();
        example.createCriteria().andIdEqualTo(orderId).andStatusEqualTo(0).andDeleteStatusEqualTo(0);
        List<OmsOrder> cancelOrderList = orderMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(cancelOrderList)) {
            return;
        }
        OmsOrder cancelOrder = cancelOrderList.get(0);
        if (cancelOrder != null) {
            //修改订单状态为取消
            cancelOrder.setStatus(4);
            orderMapper.updateByPrimaryKeySelective(cancelOrder);
            OmsOrderItemExample orderItemExample = new OmsOrderItemExample();
            orderItemExample.createCriteria().andOrderIdEqualTo(orderId);
            List<OmsOrderItem> orderItemList = orderItemMapper.selectByExample(orderItemExample);
            //解除订单商品库存锁定
            if (!CollectionUtils.isEmpty(orderItemList)) {
                if (cancelOrder.getOrderType() == 0) {
                    portalOrderDao.releaseSkuStockLock(orderItemList);
                }
                if (cancelOrder.getOrderType() == 1) {
                    PmsProductSeckill productSeckill = productSeckillMapper.selectByPrimaryKey(orderItemList.get(0).getKillId());
                    productSeckill.setLockStock(productSeckill.getLockStock() - 1);
                    productSeckillMapper.updateByPrimaryKeySelective(productSeckill);
                }
                if (cancelOrder.getOrderType() == 2) {
                    PmsProductCombination productCombination = productCombinationMapper.selectByPrimaryKey(cancelOrder.getCombinationId());
                    productCombination.setLockStock(productCombination.getLockStock() - 1);
                    productCombinationMapper.updateByPrimaryKeyWithBLOBs(productCombination);
                    //是不是团长取消， 团长取消全部取消
                    OmsPinkExample omsPinkExample = new OmsPinkExample();
                    omsPinkExample.createCriteria().andOrderIdEqualTo(cancelOrder.getId());
                    List<OmsPink> pinks = pinkMapper.selectByExample(omsPinkExample);
                    if (pinks.size()==0){
                        OmsPinkBuyerExample pinkBuyerExample = new OmsPinkBuyerExample();
                        pinkBuyerExample.createCriteria().andOrderIdEqualTo(cancelOrder.getId()).andBuyerIdEqualTo(cancelOrder.getMemberId());
                        OmsPinkBuyer pinkBuyer = new OmsPinkBuyer();
                        pinkBuyer.setPinkStatus(false);
                        pinkBuyerMapper.updateByExampleSelective(pinkBuyer,pinkBuyerExample);
                    }else{
                        OmsPink pink = pinks.get(0);
                        pink.setStatus(3);
                        pinkMapper.updateByPrimaryKeySelective(pink);
                        OmsPinkBuyerExample pinkBuyerExample = new OmsPinkBuyerExample();
                        pinkBuyerExample.createCriteria().andOrderIdEqualTo(cancelOrder.getId())
                                .andBuyerIdEqualTo(cancelOrder.getMemberId())
                        .andPinkIdEqualTo(pink.getId());
                        OmsPinkBuyer pinkBuyer = new OmsPinkBuyer();
                        pinkBuyer.setPinkStatus(false);
                        pinkBuyerMapper.updateByExampleSelective(pinkBuyer,pinkBuyerExample);
                    }
                }
            }
            //修改优惠券使用状态
            if (cancelOrder.getCouponId() !=null) {
                updateCouponStatus(cancelOrder.getCouponId(), cancelOrder.getMemberId(), 0);
            }
            //返还使用积分
            if (cancelOrder.getUseIntegration() != null) {
                UmsMember member = memberService.getById(cancelOrder.getMemberId());
                memberService.updateIntegration(cancelOrder.getMemberId(), member.getIntegration() + cancelOrder.getUseIntegration());
            }
        }
    }

    @Override
    public void sendDelayMessageCancelOrder(Long orderId) {
        OmsOrderSetting orderSetting = orderSettingMapper.selectByPrimaryKey(1L);
        long delayTimes = 10* 60 * 1000;
        cancelOrderSender.sendMessage(orderId, delayTimes);
    }

    public void sendDelayMessageCancelPink(OmsPink pink, Integer delayTimes) {
        //发送延迟消息
        cancelPinkSender.sendMessage(pink.getId(), delayTimes* 60 * 1000);
    }
    @Override
    public void sendDelayMessageCancelOrder(OmsOrder order) {
        //获取订单超时时间
        OmsOrderSetting orderSetting = orderSettingMapper.selectByPrimaryKey(1L);
        long delayTimes = 10* 60 * 1000;
        if (order.getOrderType() == 0){
            delayTimes = orderSetting.getNormalOrderOvertime() * 60 * 1000;
        }

        if (order.getOrderType() == 1) {
            delayTimes = orderSetting.getFinishOvertime() * 60 * 1000;
        }

        if (order.getOrderType() == 2) {
            //订单支付超时
            if (orderSetting.getPinkOrderOvertime() != null) {
                delayTimes = orderSetting.getPinkOrderOvertime() * 60 * 1000;
            }
        }
        //发送延迟消息
        cancelOrderSender.sendMessage(order.getId(), delayTimes);
    }

    @Override
    public CommonResult getOrderDetail(Long id) {
        OrderDetail orderDetail = new OrderDetail();
        OmsOrder order = orderMapper.selectByPrimaryKey(id);
        orderDetail.setOrder(order);
        //商品
        OmsOrderItemExample example = new OmsOrderItemExample();
        example.createCriteria().andOrderIdEqualTo(id);
        List<OmsOrderItem> orderItems = orderItemMapper.selectByExample(example);
        orderDetail.setOrderItems(orderItems);
        //物流状态
        if (order.getShoppingType() ==1) {
            ExpressInfo expressInfo = orderExpressService.getExpressInfo(order.getOrderSn());
            orderDetail.setExpressInfo(expressInfo);
        }

        //门店自提信息
        if (order.getShoppingType() ==2) {
           PmsStore store = pmsStoreMapper.selectByPrimaryKey(order.getStoreId());
           orderDetail.setStore(store);
        }
        return CommonResult.success(orderDetail);
    }

    @Override
    public CommonResult getOrderDetailBySn(String orderSn) {
        OrderDetail orderDetail = new OrderDetail();
        OmsOrderExample orderExample = new OmsOrderExample();
        orderExample.createCriteria().andOrderSnEqualTo(orderSn);
        List <OmsOrder> orders = orderMapper.selectByExample(orderExample);
        if (orders.size() == 0) {
            return CommonResult.failed("订单不存在");
        }
        orderDetail.setOrder(orders.get(0));
        //商品
        OmsOrderItemExample example = new OmsOrderItemExample();
        example.createCriteria().andOrderIdEqualTo(orders.get(0).getId());
        List<OmsOrderItem> orderItems = orderItemMapper.selectByExample(example);
        orderDetail.setOrderItems(orderItems);
        return CommonResult.success(orderDetail);
    }

    @Override
    public CommonResult delOrder(Long id) {
        OmsOrder order = orderMapper.selectByPrimaryKey(id);
        order.setMemberDeleteStatus(1);
        orderMapper.updateByPrimaryKeySelective(order);
        return CommonResult.success("");
    }



    @Override
    public CommonResult pay(Long orderId, int payType) {
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if (payType == 1){
           String orderStr = (String) aliPayService.generaterAliPayOrder(order);
           if (orderStr.equals("")){
               return CommonResult.failed("生成支付宝订单失败");
           }else {
            return CommonResult.success(orderStr);
           }
        }else {
            Map orderMap = null;
            try {
                orderMap = (Map) wxPayService.generaterWxPayOrder(order);
                if (orderMap == null){
                    return CommonResult.failed("生成微信订单失败");
                }else {
                    return CommonResult.success(orderMap );
                }
            } catch (Exception e) {
                e.printStackTrace();
                return CommonResult.failed("生成微信订单失败");
            }
        }
    }

    @Override
    public Object payWeb(Long orderId, int payType) {
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null || order.getStatus() != 0) {
            return null;
        }
        if (payType == 1){
            String from = aliPayService.generaterAliPayH5Order(order);
            return from;
        }else {
            Object from = null;
            try {
                from = wxPayService.generaterWxayH5Order(order);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return from;
        }

    }

    @Override
    public Object payOrderSP(Long orderId, String openId) {
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        try {
          return   wxPayService.generaterWxSPOrder(order, openId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object payOrderJS(Long orderId, String openId) {
        OmsOrder order = orderMapper.selectByPrimaryKey(orderId);
        try {
          return   wxPayService.generaterWxayJSOrder(order,openId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 生成18位订单编号:8位日期+2位平台号码+2位支付方式+6位以上自增id
     */
    private String generateOrderSn(OmsOrder order) {
        StringBuilder sb = new StringBuilder();
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String key = REDIS_KEY_PREFIX_ORDER_ID + date;
        Long increment = redisService.increment(key, 1);
        sb.append(date);
//        sb.append(String.format("%02d", order.getSourceType()));
//        sb.append(String.format("%02d", order.getPayType()));
        String incrementStr = increment.toString();
        if (incrementStr.length() <= 6) {
            sb.append(String.format("%06d", increment));
        } else {
            sb.append(incrementStr);
        }
        return sb.toString();
    }

    /**
     * 删除下单商品的购物车信息
     */
    private void deleteCartItemList(List<CartPromotionItem> cartPromotionItemList, UmsMember currentMember) {
        List<Long> ids = new ArrayList<>();
        for (CartPromotionItem cartPromotionItem : cartPromotionItemList) {
            ids.add(cartPromotionItem.getId());
        }
        cartItemService.delete(currentMember.getId(), ids);
    }

    /**
     * 计算该订单赠送的成长值
     */
    private Integer calcGiftGrowth(List<OmsOrderItem> orderItemList) {
        Integer sum = 0;
        for (OmsOrderItem orderItem : orderItemList) {
            sum = sum + orderItem.getGiftGrowth() * orderItem.getProductQuantity();
        }
        return sum;
    }

    /**
     * 计算该订单赠送的积分
     */
    private Integer calcGifIntegration(List<OmsOrderItem> orderItemList) {
        int sum = 0;
        for (OmsOrderItem orderItem : orderItemList) {
            sum += orderItem.getGiftIntegration() * orderItem.getProductQuantity();
        }
        return sum;
    }

    /**
     * 将优惠券信息更改为指定状态
     *
     * @param couponId  优惠券id
     * @param memberId  会员id
     * @param useStatus 0->未使用；1->已使用
     */
    private void updateCouponStatus(Long couponId, Long memberId, Integer useStatus) {
        if (couponId == null) return;
        //查询第一张优惠券
        SmsCouponHistoryExample example = new SmsCouponHistoryExample();
        example.createCriteria().andMemberIdEqualTo(memberId)
                .andCouponIdEqualTo(couponId).andUseStatusEqualTo(useStatus == 0 ? 1 : 0);
        List<SmsCouponHistory> couponHistoryList = couponHistoryMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(couponHistoryList)) {
            SmsCouponHistory couponHistory = couponHistoryList.get(0);
            couponHistory.setUseTime(new Date());
            couponHistory.setUseStatus(useStatus);
            couponHistoryMapper.updateByPrimaryKeySelective(couponHistory);
        }
    }

    private void handleRealAmount(List<OmsOrderItem> orderItemList) {
        for (OmsOrderItem orderItem : orderItemList) {
            //原价-促销优惠-优惠券抵扣-积分抵扣
            BigDecimal realAmount = orderItem.getProductPrice()
                    .subtract(orderItem.getPromotionAmount())
                    .subtract(orderItem.getCouponAmount())
                    .subtract(orderItem.getIntegrationAmount());
            orderItem.setRealAmount(realAmount);
        }
    }

    /**
     * 获取订单促销信息
     */
    private String getOrderPromotionInfo(List<OmsOrderItem> orderItemList) {
        StringBuilder sb = new StringBuilder();
        for (OmsOrderItem orderItem : orderItemList) {
            sb.append(orderItem.getPromotionName());
            sb.append(",");
        }
        String result = sb.toString();
        if (result.endsWith(",")) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    /**
     * 计算订单应付金额
     */
    private BigDecimal calcPayAmount(OmsOrder order) {
        //总金额+运费-促销优惠-优惠券优惠-积分抵扣
        BigDecimal payAmount = order.getTotalAmount()
                .add(order.getFreightAmount())
                .subtract(order.getPromotionAmount())
                .subtract(order.getCouponAmount())
                .subtract(order.getIntegrationAmount());
        return payAmount;
    }

    /**
     * 计算订单优惠券金额
     */
    private BigDecimal calcIntegrationAmount(List<OmsOrderItem> orderItemList) {
        BigDecimal integrationAmount = new BigDecimal(0);
        for (OmsOrderItem orderItem : orderItemList) {
            if (orderItem.getIntegrationAmount() != null) {
                integrationAmount = integrationAmount.add(orderItem.getIntegrationAmount().multiply(new BigDecimal(orderItem.getProductQuantity())));
            }
        }
        return integrationAmount;
    }

    /**
     * 计算订单优惠券金额
     */
    private BigDecimal calcCouponAmount(List<OmsOrderItem> orderItemList) {
        BigDecimal couponAmount = new BigDecimal(0);
        for (OmsOrderItem orderItem : orderItemList) {
            if (orderItem.getCouponAmount() != null) {
                couponAmount = couponAmount.add(orderItem.getCouponAmount().multiply(new BigDecimal(orderItem.getProductQuantity())));
            }
        }
        return couponAmount;
    }

    /**
     * 计算订单活动优惠
     */
    private BigDecimal calcPromotionAmount(List<OmsOrderItem> orderItemList) {
        BigDecimal promotionAmount = new BigDecimal(0);
        for (OmsOrderItem orderItem : orderItemList) {
            if (orderItem.getPromotionAmount() != null) {
                promotionAmount = promotionAmount.add(orderItem.getPromotionAmount().multiply(new BigDecimal(orderItem.getProductQuantity())));
            }
        }
        return promotionAmount;
    }

    /**
     * 获取可用积分抵扣金额
     *
     * @param useIntegration 使用的积分数量
     * @param totalAmount    订单总金额
     * @param currentMember  使用的用户
     * @param hasCoupon      是否已经使用优惠券
     */
    private BigDecimal getUseIntegrationAmount(Integer useIntegration, BigDecimal totalAmount, UmsMember currentMember, boolean hasCoupon) {
        BigDecimal zeroAmount = new BigDecimal(0);
        //判断用户是否有这么多积分
        if (useIntegration.compareTo(currentMember.getIntegration()) > 0) {
            return zeroAmount;
        }
        //根据积分使用规则判断是否可用
        //是否可与优惠券共用
        UmsIntegrationConsumeSetting integrationConsumeSetting = integrationConsumeSettingMapper.selectByPrimaryKey(1L);
        if (hasCoupon && integrationConsumeSetting.getCouponStatus().equals(0)) {
            //不可与优惠券共用
            return zeroAmount;
        }
        //是否达到最低使用积分门槛
        if (useIntegration.compareTo(integrationConsumeSetting.getUseUnit()) < 0) {
            return zeroAmount;
        }
        //是否超过订单抵用最高百分比
        BigDecimal integrationAmount = new BigDecimal(useIntegration).divide(new BigDecimal(integrationConsumeSetting.getUseUnit()), 2, RoundingMode.HALF_EVEN);
        BigDecimal maxPercent = new BigDecimal(integrationConsumeSetting.getMaxPercentPerOrder()).divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN);
        if (integrationAmount.compareTo(totalAmount.multiply(maxPercent)) > 0) {
            return zeroAmount;
        }
        return integrationAmount;
    }

    /**
     * 对优惠券优惠进行处理
     *
     * @param orderItemList       order_item列表
     * @param couponHistoryDetail 可用优惠券详情
     */
    private void handleCouponAmount(List<OmsOrderItem> orderItemList, SmsCouponHistoryDetail couponHistoryDetail) {
        SmsCoupon coupon = couponHistoryDetail.getCoupon();
        if (coupon.getUseType().equals(0)) {
            //全场通用
            calcPerCouponAmount(orderItemList, coupon);
        } else if (coupon.getUseType().equals(1)) {
            //指定分类
            List<OmsOrderItem> couponOrderItemList = getCouponOrderItemByRelation(couponHistoryDetail, orderItemList, 0);
            calcPerCouponAmount(couponOrderItemList, coupon);
        } else if (coupon.getUseType().equals(2)) {
            //指定商品
            List<OmsOrderItem> couponOrderItemList = getCouponOrderItemByRelation(couponHistoryDetail, orderItemList, 1);
            calcPerCouponAmount(couponOrderItemList, coupon);
        }
    }

    /**
     * 对每个下单商品进行优惠券金额分摊的计算
     *
     * @param orderItemList 可用优惠券的下单商品商品
     */
    private void calcPerCouponAmount(List<OmsOrderItem> orderItemList, SmsCoupon coupon) {
        BigDecimal totalAmount = calcTotalAmount(orderItemList);
        for (OmsOrderItem orderItem : orderItemList) {
            //(商品价格/可用商品总价)*优惠券面额
            BigDecimal couponAmount = orderItem.getProductPrice().divide(totalAmount, 3, RoundingMode.HALF_EVEN).multiply(coupon.getAmount());
            orderItem.setCouponAmount(couponAmount);
        }
    }

    /**
     * 获取与优惠券有关系的下单商品
     *
     * @param couponHistoryDetail 优惠券详情
     * @param orderItemList       下单商品
     * @param type                使用关系类型：0->相关分类；1->指定商品
     */
    private List<OmsOrderItem> getCouponOrderItemByRelation(SmsCouponHistoryDetail couponHistoryDetail, List<OmsOrderItem> orderItemList, int type) {
        List<OmsOrderItem> result = new ArrayList<>();
        if (type == 0) {
            List<Long> categoryIdList = new ArrayList<>();
            for (SmsCouponProductCategoryRelation productCategoryRelation : couponHistoryDetail.getCategoryRelationList()) {
                categoryIdList.add(productCategoryRelation.getProductCategoryId());
            }
            for (OmsOrderItem orderItem : orderItemList) {
                if (categoryIdList.contains(orderItem.getProductCategoryId())) {
                    result.add(orderItem);
                } else {
                    orderItem.setCouponAmount(new BigDecimal(0));
                }
            }
        } else if (type == 1) {
            List<Long> productIdList = new ArrayList<>();
            for (SmsCouponProductRelation productRelation : couponHistoryDetail.getProductRelationList()) {
                productIdList.add(productRelation.getProductId());
            }
            for (OmsOrderItem orderItem : orderItemList) {
                if (productIdList.contains(orderItem.getProductId())) {
                    result.add(orderItem);
                } else {
                    orderItem.setCouponAmount(new BigDecimal(0));
                }
            }
        }
        return result;
    }

    /**
     * 获取该用户可以使用的优惠券
     *
     * @param cartPromotionItemList 购物车优惠列表
     * @param couponId              使用优惠券id
     */
    private SmsCouponHistoryDetail getUseCoupon(List<CartPromotionItem> cartPromotionItemList, Long couponId) {
        List<SmsCouponHistoryDetail> couponHistoryDetailList = memberCouponService.listCart(cartPromotionItemList, 1);
        for (SmsCouponHistoryDetail couponHistoryDetail : couponHistoryDetailList) {
            if (couponHistoryDetail.getCoupon().getId().equals(couponId)) {
                return couponHistoryDetail;
            }
        }
        return null;
    }

    /**
     * 计算总金额
     */
    private BigDecimal calcTotalAmount(List<OmsOrderItem> orderItemList) {
        BigDecimal totalAmount = new BigDecimal("0");
        for (OmsOrderItem item : orderItemList) {
            totalAmount = totalAmount.add(item.getProductPrice().multiply(new BigDecimal(item.getProductQuantity())));
        }
        return totalAmount;
    }

    /**
     * 锁定下单商品的所有库存
     */
    private void lockStock(List<CartPromotionItem> cartPromotionItemList) {
        for (CartPromotionItem cartPromotionItem : cartPromotionItemList) {
            PmsSkuStock skuStock = skuStockMapper.selectByPrimaryKey(cartPromotionItem.getProductSkuId());
            skuStock.setLockStock(skuStock.getLockStock() + cartPromotionItem.getQuantity());
            skuStockMapper.updateByPrimaryKeySelective(skuStock);
        }
    }

    /**
     * 判断下单商品是否都有库存
     */
    private boolean hasStock(List<CartPromotionItem> cartPromotionItemList) {
        for (CartPromotionItem cartPromotionItem : cartPromotionItemList) {
            if (cartPromotionItem.getRealStock()==null||cartPromotionItem.getRealStock() <= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算购物车中商品的价格
     */
    private ConfirmOrderResult.CalcAmount calcCartAmount(List<CartPromotionItem> cartPromotionItemList) {
        ConfirmOrderResult.CalcAmount calcAmount = new ConfirmOrderResult.CalcAmount();
        calcAmount.setFreightAmount(new BigDecimal(0));
        BigDecimal totalAmount = new BigDecimal("0");
        BigDecimal promotionAmount = new BigDecimal("0");
        for (CartPromotionItem cartPromotionItem : cartPromotionItemList) {
            totalAmount = totalAmount.add(cartPromotionItem.getPrice().multiply(new BigDecimal(cartPromotionItem.getQuantity())));
            promotionAmount = promotionAmount.add(cartPromotionItem.getReduceAmount().multiply(new BigDecimal(cartPromotionItem.getQuantity())));
        }
        calcAmount.setTotalAmount(totalAmount);
        calcAmount.setPromotionAmount(promotionAmount);
        calcAmount.setPayAmount(totalAmount.subtract(promotionAmount));
        return calcAmount;
    }

    /**
     * 支付成功后更新订单状态
     * */

    public boolean  updateOrderByPaySuccess(String outTradeNo, String trade_no ,int payType ,int paySource){


        //整体添加订单处理mq
        OmsOrderExample omsOrderExample = new OmsOrderExample();
        OmsOrderExample.Criteria criteria = omsOrderExample.createCriteria();
        criteria.andOrderSnEqualTo(trade_no);
        List<OmsOrder> orders = orderMapper.selectByExample(omsOrderExample);
        if (orders.size() == 1){

            OmsOrder order = orders.get(0);
            UmsMemberWxofficeExample memberWxofficeExample = new UmsMemberWxofficeExample();
            memberWxofficeExample.createCriteria().andUserIdEqualTo(order.getMemberId());
            List<UmsMemberWxoffice> memberWxoffices = memberWxofficeMapper.selectByExample(memberWxofficeExample);
            UmsMemberWxoffice memberWxoffice = null;
            if (memberWxoffices.size() != 0) {
                memberWxoffice = memberWxoffices.get(0);

            }

            if (order.getStatus() == 0) {
                System.out.println("----order"+order);
                order.setOuttradeno(outTradeNo);
                if (order.getShoppingType() == 1) {
                    order.setStatus(1);
                }
                if (order.getShoppingType() == 2) {
                    order.setStatus(2);
                    generateFaceOrder(order.getId());
                }
                order.setPayType(payType);
                order.setPaySource(paySource);
                order.setPaymentTime(new Date());
                orderMapper.updateByPrimaryKeySelective(order);
                OmsOrderDetail orderDetail = portalOrderDao.getDetail(order.getId());
                //正常订单
                if (order.getOrderType() == 0) {
                    portalOrderDao.updateSkuStock(orderDetail.getOrderItemList());
                    portalOrderDao.updateSaleCount(orderDetail.getOrderItemList());
                }
                //秒杀订单
                if (order.getOrderType() == 1) {
                    OmsOrderItem item = orderDetail.getOrderItemList().get(0);
                    PmsProductSeckill productSeckill = productSeckillMapper.selectByPrimaryKey(item.getKillId());
                    productSeckill.setLockStock(productSeckill.getLockStock()-1);
                    productSeckill.setStock(productSeckill.getStock() + 1);
                    productSeckill.setSale(productSeckill.getSale()+1);
                    productSeckillMapper.updateByPrimaryKeySelective(productSeckill);
                }

                //团购订单
                if (order.getOrderType() == 2) {
                    //添加mq队列进行处理
                    //先判断是不是新团
                    OmsPink pink = pinkMapper.selectByPrimaryKey(order.getPinkId());
                    PmsProductCombination productCombination = productCombinationMapper.selectByPrimaryKey(order.getCombinationId());
                    boolean full = false;
                    if(pink.getStatus() == 0 ){
                        //是新团
                        pink.setStatus(1);
                        Date nowDate = new Date();
                        pink.setAddTime(nowDate.getTime());
                        Integer effectiveTime = 24;
                        if (productCombination.getEffectiveTime() != null) {
                            effectiveTime = productCombination.getEffectiveTime();

                        }
                        pink.setStopTime(DateUtils.dateAddHour(nowDate,effectiveTime).getTime());
                        pinkMapper.updateByPrimaryKeySelective(pink);
                        sendDelayMessageCancelPink(pink,effectiveTime);
                        if (memberWxoffice !=null) {
                            OmsOrderItemExample example = new OmsOrderItemExample();
                            example.createCriteria().andOrderIdEqualTo(order.getId());
                            List<OmsOrderItem> itmes  =orderItemMapper.selectByExample(example);
                            OmsOrderItem orderItem = itmes.get(0);
                            templateService.groupBuyingOpenSuccessNotice(memberWxoffice.getOpenId(),orderItem.getProductName(),order.getCombinationId().toString(),
                                                                   order.getPayAmount().toString()+"元",pink.getPeople().toString(),"开团订单",
                                                                    productCombination.getEffectiveTime().toString()+"小时");
                        }

                    }else if(pink.getStatus() == 1){
                        OmsPinkBuyerExample pinkBuyerExample = new OmsPinkBuyerExample();
                        pinkBuyerExample.createCriteria().andPinkIdEqualTo(pink.getId()).andPinkStatusEqualTo(true).andPayStatusEqualTo(1);
                        List<OmsPinkBuyer> pinkBuyers = pinkBuyerMapper.selectByExample(pinkBuyerExample);
                        if (pink.getPeople() == pinkBuyers.size()+1 ){
                            pink.setStatus(2);
                            pinkMapper.updateByPrimaryKeySelective(pink);
                        }

                    }else if(pink.getStatus() == 2) {
                        order.setStatus(4);
                        orderMapper.updateByPrimaryKeySelective(order);
                        //添加退款
                        orderRefundService.applyRefund(order.getId(),"拼团已满，拼团失败", order.getMemberId());
                        full = true;
                    }else {
                        OmsPinkBuyerExample example = new OmsPinkBuyerExample();
                        example.createCriteria().andOrderIdEqualTo(order.getId()).andBuyerIdEqualTo(order.getMemberId()).andPayStatusEqualTo(0);
                        OmsPinkBuyer pinkBuyer = new OmsPinkBuyer();
                        pinkBuyer.setPayStatus(1);
                        pinkBuyer.setIsRefund(false);
                        pinkBuyer.setPinkTime(new Date().getTime() / 1000);
                        pinkBuyerMapper.updateByExampleSelective(pinkBuyer, example);
                        order.setStatus(4);
                        orderMapper.updateByPrimaryKeySelective(order);
                        //添加退款
                        orderRefundService.applyRefund(order.getId(),"拼团时间过期，拼团失败", order.getMemberId());
                        full = true;
                    }

                        OmsPinkBuyerExample example = new OmsPinkBuyerExample();
                        example.createCriteria().andOrderIdEqualTo(order.getId()).andBuyerIdEqualTo(order.getMemberId()).andPayStatusEqualTo(0);
                        OmsPinkBuyer pinkBuyer = new OmsPinkBuyer();
                        pinkBuyer.setPayStatus(1);
                        pinkBuyer.setIsRefund(false);
                        if (full){
                            pinkBuyer.setPinkStatus(false);
                        }
                        pinkBuyer.setPinkTime(new Date().getTime()/1000);
                        pinkBuyerMapper.updateByExampleSelective(pinkBuyer,example);

                        productCombination.setLockStock(productCombination.getLockStock()-1);
                        if (!full) {
                            productCombination.setStock(productCombination.getStock() + 1);
                            productCombination.setSale(productCombination.getSale()+1);

                        }
                        productCombinationMapper.updateByPrimaryKeySelective(productCombination);
                    }
                }
            //发送邮件通知商户下单成功
            UmsAdminSettingExample example = new UmsAdminSettingExample();
            List<UmsAdminSetting> adminSettings = umsAdminSettingMapper.selectByExample(example);
            if (adminSettings.size() > 0 && adminSettings.get(0).getNotificationFormMail().length() > 0 &&
                    adminSettings.get(0).getNotificationToMail().length() > 0) {
                Map dataMap = new HashMap();
                dataMap.put("title", "订单邮件");
                dataMap.put("category", "用户下单");
                dataMap.put("order_sn",order.getOrderSn());
                dataMap.put("username",  memberService.getById(order.getMemberId()).getNickname());
                //TemplatesUtil.sendSimpleOrderEmail(dataMap,adminSettings.get(0).getNotificationFormMail(),adminSettings.get(0).getNotificationToMail());
            }
            //通知微信卖家

            if (memberWxoffice != null) {
                templateService.paySuccessNotice(String.valueOf(order.getId()),order.getOrderSn(),
                        order.getPayAmount().toString(),memberWxoffice.getOpenId());
            }
            orderSuccessNotice(order);
            return true;
        }else {
            return false;
        }
    }
    public void orderSuccessNotice(OmsOrder order){
        UmsMemberWxofficeExample memberWxofficeExample = new UmsMemberWxofficeExample();
        memberWxofficeExample.createCriteria().andUserIdEqualTo(order.getMemberId());

        //通知卖家备货
        PmsStoreStaffExample storeStaffExample = new PmsStoreStaffExample();
        List<PmsStoreStaff> storeStaffs = pmsStoreStaffMapper.selectByExample(storeStaffExample);
        for (int i=0;i<storeStaffs.size();i++) {
            memberWxofficeExample.createCriteria().andUserIdEqualTo(storeStaffs.get(i).getUid());
           List<UmsMemberWxoffice>  memberWxoffices = memberWxofficeMapper.selectByExample(memberWxofficeExample);
            if (memberWxoffices.size() != 0) {
                UmsMemberWxoffice memberWxoffice = memberWxoffices.get(0);
                OmsOrderItemExample omsOrderItemExample = new OmsOrderItemExample();
                omsOrderItemExample.createCriteria().andOrderSnEqualTo(order.getOrderSn());
                List<OmsOrderItem > orderItems = orderItemMapper.selectByExample(omsOrderItemExample);
                for (int j=0;j<orderItems.size();j++) {
                    OmsOrderItem orderItem = orderItems.get(j);
                    String payment = "";
                    if (order.getShoppingType() == 2 ){

                        if (order.getPayType() == 0){
                            payment = "未支付-预约定货";
                        }

                        if (order.getPayType() == 0){
                            payment = "已支付-支付宝-预约定货";
                        }

                        if (order.getPayType() == 0){
                            payment = "已支付-支付宝-预约定货";
                        }

                    }
                    //1->支付宝；2->微信"
                    if (order.getShoppingType() == 1){
                        if (order.getPayType() == 1) {
                            payment = "已支付-支付宝";
                        }
                        if (order.getPayType() == 2) {
                            payment = "已支付-微信";
                        }
                    }
                    templateService.orderSuccessNotice(String.valueOf(order.getId()),orderItem.getOrderSn(),memberWxoffice.getOpenId(),
                            orderItem.getProductName(),orderItem.getProductQuantity().toString(),
                            orderItem.getRealAmount().toString(),payment);
                }

            }
        }
    }
    @Override
    public CommonResult getOrders(int orderType, int pages, int size) {
        PageHelper.startPage(pages,size);
        UmsMember member = memberService.getCurrentMember();
        OmsOrderExample omsOrderExample = new OmsOrderExample();
        switch (orderType){
            case 0:
                //全部
                omsOrderExample.createCriteria().andMemberIdEqualTo(member.getId())
                        .andDeleteStatusEqualTo(0)
                        .andMemberDeleteStatusEqualTo(0);
                break;
            case 1:
                //代付款
                omsOrderExample.createCriteria().andMemberIdEqualTo(member.getId())
                        .andStatusEqualTo(0)
                        .andDeleteStatusEqualTo(0)
                        .andMemberDeleteStatusEqualTo(0);
                break;
            case 2:
                //待收货
                List statusList = new ArrayList();
                statusList.add(1);
                statusList.add(2);
                omsOrderExample.createCriteria().andMemberIdEqualTo(member.getId())
                        .andStatusIn(statusList)
                        .andDeleteStatusEqualTo(0)
                        .andMemberDeleteStatusEqualTo(0);
                break;
            case 3:
                //已完成
                omsOrderExample.createCriteria().andMemberIdEqualTo(member.getId())
                        .andStatusEqualTo(3)
                        .andDeleteStatusEqualTo(0)
                        .andMemberDeleteStatusEqualTo(0);
                break;
            case 4:
                omsOrderExample.createCriteria().andMemberIdEqualTo(member.getId())
                        .andStatusEqualTo(4)
                        .andDeleteStatusEqualTo(0)
                        .andMemberDeleteStatusEqualTo(0);
                break;
            default:
                break;
        }
        omsOrderExample.setOrderByClause("create_time desc");
        List<OmsOrder> omsOrders = orderMapper.selectByExample(omsOrderExample);
        List<OrderCollection> orderCollections = new ArrayList<>();
        for (int i=0 ;i<omsOrders.size(); i++){
            OmsOrder omsOrder = omsOrders.get(i);
            OmsOrderItemExample example = new OmsOrderItemExample();
            example.createCriteria().andOrderIdEqualTo(omsOrder.getId());
            List itmes  =orderItemMapper.selectByExample(example);
            int productCount = 0;
            for (int j = 0; j < itmes.size(); j++) {
                OmsOrderItem omsOrderItem = (OmsOrderItem) itmes.get(j);
                productCount += omsOrderItem.getProductQuantity();
            }
            OrderCollection orderCollection = new OrderCollection();
            orderCollection.setOrderItems(itmes);
            orderCollection.setId(omsOrder.getId());
            orderCollection.setOrderTime(omsOrder.getCreateTime());
            orderCollection.setPayAmount(omsOrder.getPayAmount());
            orderCollection.setState(omsOrder.getStatus());
            orderCollection.setProductCount(productCount);
            orderCollection.setShoppingType(omsOrder.getShoppingType());
            orderCollections.add(orderCollection);
        }
        return CommonResult.success(orderCollections);
    }

    @Override
    public OmsOrder getKillOrderByUserIdGoodsId(Long userId, Long goodsId) {
        OmsOrderExample omsOrderExample = new OmsOrderExample();
        omsOrderExample.createCriteria().andKillIdEqualTo(goodsId).andMemberIdEqualTo(userId).andStatusEqualTo(0);
        List<OmsOrder> omsOrders = orderMapper.selectByExample(omsOrderExample);
       if (omsOrders.size() == 0) {
           return null;
       }else {
         return  omsOrders.get(0);
       }
    }

    @Override
    public OmsOrder getPinkOrderByUserIdGoodsId(Long userId, Long goodsId) {
        OmsOrderExample omsOrderExample = new OmsOrderExample();
        omsOrderExample.createCriteria().andCombinationIdEqualTo(goodsId).andMemberIdEqualTo(userId).andStatusEqualTo(0);
        List<OmsOrder> omsOrders = orderMapper.selectByExample(omsOrderExample);
        if (omsOrders.size() == 0) {
            return null;
        }else {
            return  omsOrders.get(0);
        }
    }

    @Override
    public OmsOrder payOrderInfo(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public CommonResult confirmReceiptOrder(Long id) {
        OmsOrder omsOrder = orderMapper.selectByPrimaryKey(id);
        omsOrder.setStatus(3);
        omsOrder.setConfirmStatus(1);
        omsOrder.setModifyTime(new Date());
        int res =  orderMapper.updateByPrimaryKeySelective(omsOrder);
        if (res == 0){
            return CommonResult.failed();
        }else {
            return CommonResult.success("确认收货成功");
        }
    }
}
