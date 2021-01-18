package com.yoooho.mall.service;

import com.yoooho.mall.model.OmsOrder;

public interface AliPayOrderSerivce {

    public  String refundOrder(OmsOrder order , Long refundId);
}
