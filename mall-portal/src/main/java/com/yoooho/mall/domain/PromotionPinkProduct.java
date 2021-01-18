package com.yoooho.mall.domain;

import com.yoooho.mall.common.ProductState;
import com.yoooho.mall.model.PmsProductCombination;

import java.util.List;

public class PromotionPinkProduct extends PmsProductCombination {

    //拼团信息
    List <OmsPinkDetail> pinkInfos;

    //商品状态
    private ProductState productState;

    //商品pink状态（0团购未开始，1团购进行中，2团购已结束，3团购光了）
    private int pinkStatus;

    public ProductState getProductState() {
        return productState;
    }

    public void setProductState(ProductState productState) {
        this.productState = productState;
    }

    public int getPinkStatus() {
        return pinkStatus;
    }

    public void setPinkStatus(int pinkStatus) {
        this.pinkStatus = pinkStatus;
    }

    public List<OmsPinkDetail> getPinkInfos() {
        return pinkInfos;
    }

    public void setPinkInfos(List<OmsPinkDetail> pinkInfos) {
        this.pinkInfos = pinkInfos;
    }
}
