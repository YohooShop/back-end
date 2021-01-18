package com.yoooho.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.redis.PinkKey;
import com.yoooho.mall.dao.PinkDao;
import com.yoooho.mall.domain.OmsPinkBuyerDetail;
import com.yoooho.mall.domain.PromotionPinkProduct;
import com.yoooho.mall.mapper.OmsOrderMapper;
import com.yoooho.mall.mapper.OmsPinkBuyerMapper;
import com.yoooho.mall.mapper.OmsPinkMapper;
import com.yoooho.mall.mapper.PmsProductCombinationMapper;
import com.yoooho.mall.model.*;
import com.yoooho.mall.service.*;
import com.yoooho.mall.service.*;
import com.yoooho.mall.util.MD5Util;
import com.yoooho.mall.util.UUIDUtil;
import com.yoooho.mall.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PinkServiceImpl implements PinkService {
    @Autowired
    RedisService redisService;
    @Autowired
    UmsMemberService memberService;
    @Autowired
    OmsPortalOrderService portalOrderService;
    @Autowired
    OmsOrderMapper orderMapper;
    @Autowired
    PinkProductService pinkProductService;

    @Autowired
    PmsProductCombinationMapper productCombinationMapper;
    @Autowired
    OmsPinkMapper pinkMapper;
    @Autowired
    OmsPinkBuyerMapper pinkBuyerMapper;

    @Autowired

    OmsOrderRefundService omsOrderRefundService;

    @Autowired
    PinkDao pinkDao;
    @Override
    public String createPinkPath(Long goodsId) {
        if (goodsId <=0){
            return  null;
        }
        String str = MD5Util.md5(UUIDUtil.uuid()+"123456");
        redisService.set(PinkKey.getPinkPath,""+memberService.getCurrentMember().getId()+"_"+goodsId,str);
        return str;
    }

    @Override
    public boolean checkPath(long goodsId, String path) {
        if(path == null) {
            return false;
        }
        Long  userId = memberService.getCurrentMember().getId();
        String pathOld = redisService.get(PinkKey.getPinkPath, ""+userId + "_"+ goodsId,  String.class);
        return path.equals(pathOld);
    }

    //判断能不能团购  1.有没该商品的团购为支付订单.2该商品是存在，3.商品是不是被删除了 4该商品是否上架了， 5该商品是否没有库存了, 6是否在团购时间里

    public int canPinkGoods(Long userId, Long goodsId) throws Exception {
        //有没该商品的团购为支付订单
        OmsOrderExample orderExample = new OmsOrderExample();
        orderExample.createCriteria().andPinkIdEqualTo(goodsId).andMemberIdEqualTo(userId).andPayTypeEqualTo(0);
        List<OmsOrder> omsOrders = orderMapper.selectByExample(orderExample);
        if (omsOrders.size()>0){
            return 1;
        }
        //该商品是存在
        PromotionPinkProduct promotionPinkProduct  = pinkProductService.getPinkProductDetail(goodsId);
        if (promotionPinkProduct== null) {
            return 2;
        }
        //该商品是不删除了
        if (promotionPinkProduct.getDeleteStatus()){
            return 3;
        }
        if (!promotionPinkProduct.getIsShow()) {
            return 4;
        }
        //该商品是否没有库存了

        if (promotionPinkProduct.getPinkStatus() == 3){
            return 5;
        }
        if (promotionPinkProduct.getPinkStatus() == 0|| promotionPinkProduct.getPinkStatus() == 2){
            return 6;
        }
        return 0;
    }
    @Override
    public boolean canPink(Long pinkId){
        OmsPinkBuyerExample example = new OmsPinkBuyerExample();
        example.createCriteria().andPinkIdEqualTo(pinkId).andPinkStatusEqualTo(true);
        List list = pinkBuyerMapper.selectByExample(example);
        OmsPink pink = pinkMapper.selectByPrimaryKey(pinkId);
        if (pink.getPeople()==list.size()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void cancelPink(Long id) {
        //取消拼团

        OmsPink pink = pinkMapper.selectByPrimaryKey(id);
        if (pink.getStatus() == 1){
            pink.setStatus(3);
            pinkMapper.updateByPrimaryKey(pink);
            OmsPinkBuyerExample example = new OmsPinkBuyerExample();
            example.createCriteria().andPinkIdEqualTo(id)
                    .andPinkStatusEqualTo(true).andPayStatusEqualTo(1);
            List<OmsPinkBuyer> buyers = pinkBuyerMapper.selectByExample(example);
            OmsPinkBuyer pinkBuyer = new OmsPinkBuyer();
            pinkBuyer.setPinkStatus(false);
            pinkBuyer.setIsRefund(false);
            pinkBuyerMapper.updateByExampleSelective(pinkBuyer,example);

            //订单状态设置
            for (OmsPinkBuyer  buyer:
                 buyers) {
               OmsOrder order = new OmsOrder();
               order.setStatus(4);
               order.setId(buyer.getOrderId());
               orderMapper.updateByPrimaryKeySelective(order);
               //添加退款
                omsOrderRefundService.applyRefund(order.getId(),"拼团时间超时，拼团失败",buyer.getBuyerId());
            }

            //应该添加到库存操作队列

            //释放库存
            PmsProductCombination productCombination = productCombinationMapper.selectByPrimaryKey(pink.getCid());
            productCombination.setStock(productCombination.getStock() + buyers.size());
            productCombinationMapper.updateByPrimaryKeyWithBLOBs(productCombination);
        }

    }

    @Override
    public CommonResult cancelTimeOutPink() {
        List<OmsPinkBuyerDetail> pinkBuyerDetails = pinkDao.getTimeOutPinks();
        for (int i = 0; i < pinkBuyerDetails.size(); i++) {
            OmsPinkBuyerDetail pinkBuyerDetail = pinkBuyerDetails.get(i);
            cancelPink(pinkBuyerDetail.getId());
        }
        return CommonResult.success("");
    }

    @Override
    public Object getPinkResult(Long userId, long goodsId) {
        OmsOrder omsOrder = portalOrderService.getPinkOrderByUserIdGoodsId(userId, goodsId);
        if(omsOrder != null) {//秒杀成功
            return omsOrder.getId();
        }else {
            boolean isOver = getPinkOver(goodsId);
            if(isOver) {
                return -1;
            }else {
                return 0;
            }
        }
    }

    @Override
    public Object minePink(Integer type, Integer page, Integer size) {
        //0'全部' //1进行中' //2'成功' //3失败'

        PageHelper.startPage(page,size);
        UmsMember member = memberService.getCurrentMember();
        List<OmsPinkBuyerDetail> omsPinkBuyerDetails = null;
        if (type == 0) {
          omsPinkBuyerDetails = pinkDao.selectPink(member.getId(),null);
        }else {
           omsPinkBuyerDetails = pinkDao.selectPink(member.getId(), type);
        }
        PageInfo<OmsPinkBuyerDetail> pageInfo = new PageInfo<>(omsPinkBuyerDetails);
        return pageInfo;
    }

    private boolean getPinkOver(long goodsId) {
        return redisService.exists(PinkKey.isGoodsOver, ""+goodsId);
    }

    @Override
    public boolean canNewPink(Long goodId){
        PmsProductCombination productCombination = productCombinationMapper.selectByPrimaryKey(goodId);
        //真实库存-需要开满团的 是否大于开满一个的团的数量
        int stock = productCombination.getStock()-productCombination.getLockStock();
        List status = new ArrayList();
        status.add(0);
        status.add(1);
        OmsPinkExample pinkExample = new OmsPinkExample();
        pinkExample.createCriteria().andStatusIn(status);
        List<OmsPink> pinks = pinkMapper.selectByExample(pinkExample);

        int count = 0;
        for (int i = 0; i <pinks.size() ; i++) {
            OmsPink pink = pinks.get(0);
            if (pink.getStatus() == 0) {
                count = count+productCombination.getPeople();
            }
            if (pink.getStatus() == 1) {
                OmsPinkBuyerExample example = new OmsPinkBuyerExample();
                example.createCriteria().andPinkIdEqualTo(pink.getId()).andPinkStatusEqualTo(true);
                List list = pinkBuyerMapper.selectByExample(example);
                count = count + (pink.getPeople() - list.size());
            }
        }
        if (stock-count < productCombination.getPeople()) {
            return false;
        }else {
            return true;
        }
    }


}
