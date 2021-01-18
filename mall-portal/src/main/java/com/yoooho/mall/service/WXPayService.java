package com.yoooho.mall.service;

import com.yoooho.mall.model.OmsOrder;

public interface WXPayService {
    //生成app微信订单
    Object generaterWxPayOrder(OmsOrder order) throws Exception ;
    Object generaterWxayH5Order(OmsOrder order) throws Exception ;
    Object generaterWxSPOrder(OmsOrder order ,String openId) throws Exception ;
    public Object generaterWxayJSOrder(OmsOrder order, String openId) throws Exception;
    String payBack(String resXml, int type);

}
