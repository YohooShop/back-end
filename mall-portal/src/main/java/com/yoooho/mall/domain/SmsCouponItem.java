package com.yoooho.mall.domain;

import com.yoooho.mall.model.SmsCoupon;

public class SmsCouponItem extends SmsCoupon {
    //优惠券是否可以被领取(0,代表可领取，1代表不可领取)
    private int takeEnabel;

    public int getTakeEnabel() {
        return takeEnabel;
    }

    public void setTakeEnabel(int takeEnabel) {
        this.takeEnabel = takeEnabel;
    }
}
