package com.yoooho.mall.dto;

import com.yoooho.mall.model.OmsOrderItem;
import com.yoooho.mall.model.OmsOrderRefund;

import java.util.List;

public class OmsRefundResult extends OmsOrderRefund {
   private List<OmsOrderItem>  products;

    public List<OmsOrderItem> getProducts() {
        return products;
    }

    public void setProducts(List<OmsOrderItem> products) {
        this.products = products;
    }
}
