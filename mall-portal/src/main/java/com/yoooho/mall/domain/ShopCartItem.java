package com.yoooho.mall.domain;

import com.yoooho.mall.model.OmsCartItem;

public class ShopCartItem {
    private OmsCartItem cartItem;

    private int publishStatus;

    public OmsCartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(OmsCartItem cartItem) {
        this.cartItem = cartItem;
    }

    public int isPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(int publishStatus) {
        this.publishStatus = publishStatus;
    }
}
