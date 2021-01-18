package com.yoooho.mall.service;

import com.yoooho.mall.model.OmsCartItem;
import com.yoooho.mall.domain.CartPromotionItem;

import java.util.List;

/**
 * Created by yoooho on 2019/8/27.
 * 促销管理Service
 */
public interface OmsPromotionService {
    /**
     * 计算购物车中的促销活动信息
     * @param cartItemList 购物车
     */
    List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList);
}
