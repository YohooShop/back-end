package com.yoooho.mall.domain;

import com.yoooho.mall.model.OmsOrderItem;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderCollection {
    private List<OmsOrderItem> orderItems;
    private int state;
    private BigDecimal payAmount;
    private Date orderTime;
    private int productCount;
    private Long id;
    private int shoppingType;

    public int getShoppingType() {
        return shoppingType;
    }

    public void setShoppingType(int shoppingType) {
        this.shoppingType = shoppingType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public List<OmsOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OmsOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }
}
