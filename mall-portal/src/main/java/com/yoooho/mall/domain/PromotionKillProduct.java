package com.yoooho.mall.domain;

import com.yoooho.mall.common.ProductState;
import com.yoooho.mall.model.PmsProductSeckill;
import com.yoooho.mall.model.SmsFlashPromotionSession;

public class PromotionKillProduct extends PmsProductSeckill {
    //是否收藏
    private  boolean collection;

    //商品状态
    private ProductState productState;

    //商品秒杀状态（0秒杀时间未开始，1秒杀进行中，2秒杀时间已结束，3秒杀光了）
    private int killStatus;


    //购物车数目
    private int shopCartNumber;

    //秒杀信息

    private SmsFlashPromotionSession flashInfo;

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

    public int getShopCartNumber() {
        return shopCartNumber;
    }

    public void setShopCartNumber(int shopCartNumber) {
        this.shopCartNumber = shopCartNumber;
    }

    public SmsFlashPromotionSession getFlashInfo() {
        return flashInfo;
    }

    public void setFlashInfo(SmsFlashPromotionSession flashInfo) {
        this.flashInfo = flashInfo;
    }

    public int getKillStatus() {
        return killStatus;
    }

    public void setKillStatus(int killStatus) {
        this.killStatus = killStatus;
    }
}
