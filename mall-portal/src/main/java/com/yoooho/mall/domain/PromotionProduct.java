package com.yoooho.mall.domain;

import com.yoooho.mall.common.ProductState;
import com.yoooho.mall.model.PmsProduct;
import com.yoooho.mall.model.PmsProductFullReduction;
import com.yoooho.mall.model.PmsProductLadder;
import com.yoooho.mall.model.PmsSkuStock;

import java.util.List;

/**
 * Created by yoooho on 2019/8/27.
 * 商品的促销信息，包括sku、打折优惠、满减优惠
 */
public class PromotionProduct extends PmsProduct {

    //是否收藏
    private  boolean collection;

    //商品状态
    private ProductState productState;


    //购物车数目
    private int shopCartNumber;

    //商品库存信息
    private List<PmsSkuStock> skuStockList;
    //商品打折信息
    private List<PmsProductLadder> productLadderList;
    //商品满减信息
    private List<PmsProductFullReduction> productFullReductionList;

    public List<PmsSkuStock> getSkuStockList() {
        return skuStockList;
    }

    public void setSkuStockList(List<PmsSkuStock> skuStockList) {
        this.skuStockList = skuStockList;
    }

    public List<PmsProductLadder> getProductLadderList() {
        return productLadderList;
    }

    public void setProductLadderList(List<PmsProductLadder> productLadderList) {
        this.productLadderList = productLadderList;
    }

    public List<PmsProductFullReduction> getProductFullReductionList() {
        return productFullReductionList;
    }

    public void setProductFullReductionList(List<PmsProductFullReduction> productFullReductionList) {
        this.productFullReductionList = productFullReductionList;
    }
    public int getShopCartNumber() {
        return shopCartNumber;
    }

    public void setShopCartNumber(int shopCartNumber) {
        this.shopCartNumber = shopCartNumber;
    }

    public boolean isCollection() {
        return collection;
    }

    public void setCollection(boolean collection) {
        this.collection = collection;
    }


    public ProductState getProductState() {
        return productState;
    }

    public void setProductState(ProductState productState) {
        this.productState = productState;
    }


}
