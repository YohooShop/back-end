package com.yoooho.mall.service;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.domain.CartPromotionItem;
import com.yoooho.mall.domain.SmsCouponHistoryDetail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户优惠券管理Service
 * Created by yoooho on 2019/8/29.
 */
public interface UmsMemberCouponService {
    /**
     * 会员添加优惠券
     */
    @Transactional
    CommonResult add(Long couponId);

    /**
     * 获取优惠券列表
     * @param useStatus 优惠券的使用状态
     */
    List<SmsCouponHistoryDetail> list(Integer useStatus, Integer pages, Integer size);

    /**
     * 根据购物车信息获取可用优惠券
     */
    List<SmsCouponHistoryDetail> listCart(List<CartPromotionItem> cartItemList, Integer type);


    CommonResult couponList();
}
