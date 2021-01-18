package com.yoooho.mall.service.impl;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.mapper.OmsCartItemMapper;
import com.yoooho.mall.mapper.PmsProductMapper;
import com.yoooho.mall.model.OmsCartItem;
import com.yoooho.mall.model.OmsCartItemExample;
import com.yoooho.mall.model.PmsProduct;
import com.yoooho.mall.model.UmsMember;
import com.yoooho.mall.dao.PortalProductDao;
import com.yoooho.mall.domain.CartProduct;
import com.yoooho.mall.domain.CartPromotionItem;
import com.yoooho.mall.service.OmsCartItemService;
import com.yoooho.mall.service.OmsPromotionService;
import com.yoooho.mall.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * 购物车管理Service实现类
 * Created by yoooho on 2019/8/2.
 */
@Service
public class OmsCartItemServiceImpl implements OmsCartItemService {
    @Autowired
    private OmsCartItemMapper cartItemMapper;
    @Autowired
    PmsProductMapper productMapper;
    @Autowired
    private PortalProductDao productDao;
    @Autowired
    private OmsPromotionService promotionService;
    @Autowired
    private UmsMemberService memberService;

    @Override
    public Object add(OmsCartItem cartItem , int type) {

        UmsMember currentMember =memberService.getCurrentMember();
        cartItem.setMemberId(currentMember.getId());
//        cartItem.setMemberNickname(currentMember.getNickname());
        cartItem.setDeleteStatus(0);
        OmsCartItem existCartItem = getCartItem(cartItem);

        if (type == 0){
            if (existCartItem == null) {
                cartItem.setCreateDate(new Date());
                cartItemMapper.insertSelective(cartItem);
                existCartItem = cartItem;
            } else {
                cartItem.setModifyDate(new Date());
                existCartItem.setQuantity(existCartItem.getQuantity() + cartItem.getQuantity());
                cartItemMapper.updateByPrimaryKey(existCartItem);
            }
        }else {
            cartItem.setCreateDate(new Date());
            cartItemMapper.insertSelective(cartItem);
            existCartItem = cartItem;
        }

        return existCartItem;
    }

    /**
     * 根据会员id,商品id和规格获取购物车中商品
     */
    private OmsCartItem getCartItem(OmsCartItem cartItem) {
        OmsCartItemExample example = new OmsCartItemExample();
        OmsCartItemExample.Criteria criteria = example.createCriteria().andMemberIdEqualTo(cartItem.getMemberId())
                .andProductIdEqualTo(cartItem.getProductId()).andDeleteStatusEqualTo(0).andProductSkuIdEqualTo(cartItem.getProductSkuId());
        if (!StringUtils.isEmpty(cartItem.getSp1())) {
            criteria.andSp1EqualTo(cartItem.getSp1());
        }
        if (!StringUtils.isEmpty(cartItem.getSp2())) {
            criteria.andSp2EqualTo(cartItem.getSp2());
        }
        if (!StringUtils.isEmpty(cartItem.getSp3())) {
            criteria.andSp3EqualTo(cartItem.getSp3());
        }
        List<OmsCartItem> cartItemList = cartItemMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(cartItemList)) {
            return cartItemList.get(0);
        }
        return null;
    }

    @Override
    public List<OmsCartItem> list(Long memberId , List<Long> ids) {
        OmsCartItemExample example = new OmsCartItemExample();
        if (ids.size()>0){
            example.createCriteria().andDeleteStatusEqualTo(0).andMemberIdEqualTo(memberId).andIdIn(ids);
        }else {
            example.createCriteria().andDeleteStatusEqualTo(0).andMemberIdEqualTo(memberId);
        }
       List<OmsCartItem> cartItems = cartItemMapper.selectByExample(example);
       return cartItems;
    }


    @Override
    public List<CartPromotionItem> listPromotion(Long memberId, List<Long> ids) {
        List<OmsCartItem> cartItemList = list(memberId,ids);
        List<CartPromotionItem> cartPromotionItemList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(cartItemList)){
            cartPromotionItemList = promotionService.calcCartPromotion(cartItemList);
        }
        for (int i = 0; i < cartPromotionItemList.size(); i++) {
          PmsProduct product = productMapper.selectByPrimaryKey(cartPromotionItemList.get(i).getProductId());
          cartPromotionItemList.get(i).setPublishStatus(product.getPublishStatus());
        }
        return cartPromotionItemList;
    }

    @Override
    public int updateQuantity(Long id, Long memberId, Integer quantity) {
        OmsCartItem cartItem = new OmsCartItem();
        cartItem.setQuantity(quantity);
        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria().andDeleteStatusEqualTo(0)
                .andIdEqualTo(id).andMemberIdEqualTo(memberId);
        return cartItemMapper.updateByExampleSelective(cartItem, example);
    }

    @Override
    public int delete(Long memberId, List<Long> ids) {
        OmsCartItem record = new OmsCartItem();
        record.setDeleteStatus(1);
        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria().andIdIn(ids).andMemberIdEqualTo(memberId);
        return cartItemMapper.updateByExampleSelective(record, example);
    }

    @Override
    public CartProduct getCartProduct(Long productId) {
        return productDao.getCartProduct(productId);
    }

    @Override
    public int updateAttr(OmsCartItem cartItem) {
        //删除原购物车信息
        OmsCartItem updateCart = new OmsCartItem();
        updateCart.setId(cartItem.getId());
        updateCart.setModifyDate(new Date());
        updateCart.setDeleteStatus(1);
        cartItemMapper.updateByPrimaryKeySelective(updateCart);
        cartItem.setId(null);
        add(cartItem,0);
        return 1;
    }

    @Override
    public int clear(Long memberId) {
        OmsCartItem record = new OmsCartItem();
        record.setDeleteStatus(1);
        OmsCartItemExample example = new OmsCartItemExample();
        example.createCriteria().andMemberIdEqualTo(memberId);
        return cartItemMapper.updateByExampleSelective(record,example);
    }

    //计算购物车选择商品的总价格
    @Override
    public CommonResult calculateProducts(List<Long> ids, Long memberId) {
        Map map = new HashMap();
        BigDecimal countPrice = new BigDecimal(0.00);
        BigDecimal  couponPrice = new BigDecimal(0.00);

        if (ids.size() != 0){
            OmsCartItemExample example = new OmsCartItemExample();
            example.createCriteria().andDeleteStatusEqualTo(0).andMemberIdEqualTo(memberId).andIdIn(ids);
            List<OmsCartItem> cartItemList = cartItemMapper.selectByExample(example);
            List<CartPromotionItem> cartPromotionItemList = new ArrayList<>();
            if(!CollectionUtils.isEmpty(cartItemList)){
                cartPromotionItemList = promotionService.calcCartPromotion(cartItemList);
            }


            for (int i = 0; i < cartPromotionItemList.size(); i++) {
                CartPromotionItem cartPromotionItem = cartPromotionItemList.get(i);
                cartPromotionItem.getIntegration();

                BigDecimal quantit = new BigDecimal(cartPromotionItem.getQuantity());
                couponPrice =couponPrice.add(cartPromotionItem.getReduceAmount().multiply(quantit));
                countPrice = countPrice.add((cartPromotionItem.getPrice().subtract(cartPromotionItem.getReduceAmount())).multiply(quantit));
            }

        }
        map.put("countPrice", countPrice);
        map.put("couponPrice", couponPrice);


        return  CommonResult.success(map);
    }
}
