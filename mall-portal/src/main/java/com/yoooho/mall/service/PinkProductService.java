package com.yoooho.mall.service;

import com.yoooho.mall.domain.PromotionPinkProduct;
import com.yoooho.mall.model.PmsProductCombination;

import java.util.List;

public interface PinkProductService {
    public PromotionPinkProduct getPinkProductDetail(Long id) throws Exception;

    public List<PmsProductCombination> listPinkGoods();

    public Object getPinkProductInfo(Long pinkId);

}
