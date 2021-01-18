package com.yoooho.mall.service;

import com.yoooho.mall.model.OmsOrder;

public interface WXPayService {
    public  boolean refundOrder(OmsOrder order, Long refundId) throws Exception;
    public boolean refundBack(String out_refund_no);
}
