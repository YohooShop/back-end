package com.yoooho.mall.dao;

import com.yoooho.mall.domain.CartProduct;
import com.yoooho.mall.domain.PromotionKillProduct;
import com.yoooho.mall.domain.PromotionPinkProduct;
import com.yoooho.mall.domain.PromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 前台系统自定义商品Dao
 * Created by yoooho on 2019/8/2.
 */
public interface PortalProductDao {
    CartProduct getCartProduct(@Param("id") Long id);
    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);

    PromotionProduct getProduct(@Param("id") Long id);

    PromotionKillProduct selectKillProduct(@Param("id") Long id);
    PromotionPinkProduct selectPinkProduct(@Param("id") Long id);
}
