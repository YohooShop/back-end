package com.yoooho.mall.dao;

import com.yoooho.mall.domain.FlashPromotionProduct;
import com.yoooho.mall.model.CmsSubject;
import com.yoooho.mall.model.PmsBrand;
import com.yoooho.mall.model.PmsProduct;
import com.yoooho.mall.model.PmsProductCombination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 首页内容管理自定义Dao
 * Created by yoooho on 2019/1/28.
 */
public interface HomeDao {

    /**
     * 获取推荐品牌
     */
    List<PmsBrand> getRecommendBrandList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取秒杀商品
     */
    List<FlashPromotionProduct> getFlashProductList(@Param("flashPromotionId") Long flashPromotionId, @Param("sessionId") Long sessionId);

    /**
     * 获取新品推荐
     */
    List<PmsProduct> getNewProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取新品推荐
     */
    List<PmsProduct> getHomeNewProductList(@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * 获取人气推荐
     */
    List<PmsProduct> getHomeHotProductList(@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * 获取人气推荐
     */
    List<PmsProduct> getHotProductList(@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * 获取推荐专题
     */
    List<CmsSubject> getRecommendSubjectList(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 获取团购推荐
     */

    List<PmsProductCombination> getCombinationProductList(@Param("offset") Integer offset, @Param("limit") Integer limit);

}
