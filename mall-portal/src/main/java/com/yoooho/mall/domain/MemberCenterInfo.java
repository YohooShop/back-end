package com.yoooho.mall.domain;

import com.yoooho.mall.model.UmsMember;

public class MemberCenterInfo extends UmsMember {



    //优惠券
    private int couponNum;

    //是否是会员
    private boolean isMember;

    //代付款数目
    private int waitPaymentCount;

    //代收货数目
    private int waitReceivingCount;

    //购物车数目
    private int shopCartNumber;

    //购物车数目

    public  boolean isbindWx;

    public boolean isIsbindWx() {
        return isbindWx;
    }

    public void setIsbindWx(boolean isbindWx) {
        this.isbindWx = isbindWx;
    }

    public int getShopCartNumber() {
        return shopCartNumber;
    }

    public void setShopCartNumber(int shopCartNumber) {
        this.shopCartNumber = shopCartNumber;
    }

    public int getCouponNum() {
        return couponNum;
    }

    public void setCouponNum(int couponNum) {
        this.couponNum = couponNum;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public int getWaitPaymentCount() {
        return waitPaymentCount;
    }

    public void setWaitPaymentCount(int waitPaymentCount) {
        this.waitPaymentCount = waitPaymentCount;
    }

    public int getWaitReceivingCount() {
        return waitReceivingCount;
    }

    public void setWaitReceivingCount(int waitReceivingCount) {
        this.waitReceivingCount = waitReceivingCount;
    }
}
