package com.yoooho.mall.domain;

import com.yoooho.mall.model.OmsOrder;
import com.yoooho.mall.model.OmsOrderItem;

import java.util.List;

/**
 * 包含订单商品信息的订单详情
 * Created by yoooho on 2019/9/4.
 */
public class OmsOrderDetail extends OmsOrder {
    private List<OmsOrderItem> orderItemList;

    public List<OmsOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OmsOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
