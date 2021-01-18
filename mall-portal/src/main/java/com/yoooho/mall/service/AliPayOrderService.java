package com.yoooho.mall.service;

import com.yoooho.mall.model.OmsOrder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface AliPayOrderService {

    //生成app支付宝订单
     Object generaterAliPayOrder(OmsOrder order);

     //生成h5支付宝订单
    String generaterAliPayH5Order(OmsOrder order);

    //异步通知结果
    public String  handelAliPayNotice(HttpServletRequest request, HttpServletResponse respons) throws Exception;


}
