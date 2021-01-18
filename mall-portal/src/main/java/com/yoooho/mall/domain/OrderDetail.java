package com.yoooho.mall.domain;

import com.yoooho.mall.express.dao.ExpressInfo;
import com.yoooho.mall.model.OmsOrder;
import com.yoooho.mall.model.OmsOrderItem;
import com.yoooho.mall.model.PmsStore;

import java.util.List;

public class OrderDetail {

    private OmsOrder order;

    private ExpressInfo expressInfo;

    private PmsStore store;
    public OmsOrder getOrder() {
        return order;
    }

    public void setOrder(OmsOrder order) {
        this.order = order;
    }

    public ExpressInfo getExpressInfo() {
        return expressInfo;
    }

    public void setExpressInfo(ExpressInfo expressInfo) {
        this.expressInfo = expressInfo;
    }

    private List<OmsOrderItem> orderItems;

    public List<OmsOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OmsOrderItem> orderItems) {
        this.orderItems = orderItems;
    }


    public PmsStore getStore() {
        return store;
    }

    public void setStore(PmsStore store) {
        this.store = store;
    }
}
