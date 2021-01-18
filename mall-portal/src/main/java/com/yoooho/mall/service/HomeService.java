package com.yoooho.mall.service;

import com.yoooho.mall.domain.HomeConfigResult;
import com.yoooho.mall.domain.HomeNewContentResult;
import com.yoooho.mall.model.*;
import com.yoooho.mall.domain.HomeContentResult;
import com.yoooho.mall.domain.PmsProductCategoryWithChildrenItem;
import com.yoooho.mall.model.*;

import java.util.Date;
import java.util.List;

/**
 * 首页内容管理Service
 * Created by yoooho on 2019/1/28.
 */
public interface HomeService {

    /**
     * 获取首页内容
     */

    HomeConfigResult config();
    HomeContentResult content();

    HomeNewContentResult newContent();

    LandPages getLandHomePages();
    /**
     * 首页商品推荐
     */
    List<PmsProduct> recommendProductList(Integer pageSize, Integer pageNum);

    List<PmsProductCategoryWithChildrenItem>  getProductCate();

    List<PmsProduct> getProductList( Long cateId, Integer pageSize, Integer pageNum, Integer type);

    /**
     * 获取商品分类
     * @param parentId 0:获取一级分类；其他：获取指定二级分类
     */
    List<PmsProductCategory> getProductCateList(Long parentId);

    /**
     * 根据专题分类分页获取专题
     * @param cateId 专题分类id
     */
    List<CmsSubject> getSubjectList(Long cateId, Integer pageSize, Integer pageNum);

    List<CmsSubject> getSubjectAllList( Integer pageSize, Integer pageNum);
    List getHotProductList(Integer pageSize, Integer pageNum);
    List getNewProductList(Integer pageSize, Integer pageNum);
    List <PmsProductSeckill>  getProductSeckill(Long timeId, Date date);
    List<PmsProductCombination> getPinkProductList(Integer pageSize, Integer pageNum);

}
