package com.yoooho.mall.dao;


import com.yoooho.mall.domain.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * 商品分类自定义Dao
 * Created by yoooho on 2019/5/25.
 */
public interface PmsProductCategoryDao {
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
    List selectBannerCategory();
}
