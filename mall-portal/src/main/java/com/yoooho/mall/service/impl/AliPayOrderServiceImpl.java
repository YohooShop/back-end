package com.yoooho.mall.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.google.gson.Gson;
import com.yoooho.mall.domian.AlipayConfig;
import com.yoooho.mall.model.OmsOrder;
//import AliPayConfig;


import com.yoooho.mall.service.OmsPortalOrderService;
import com.yoooho.mall.service.AliPayOrderService;
import com.yoooho.mall.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class AliPayOrderServiceImpl implements AliPayOrderService {
    @Autowired
    OmsPortalOrderService portalOrderService;

    @Autowired
    AlipayService alipayService;
    @Override
    public Object generaterAliPayOrder(OmsOrder order) {
        AlipayConfig alipayConfig = alipayService.find();
        AlipayClient alipayClient = alipayService.getAlipayClient();
        AlipayTradeAppPayRequest ali_request = new AlipayTradeAppPayRequest();
        AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        //回掉参数
        Map<String, Object> passback_params_map = new HashMap();
        Gson gson = new Gson();
        String passback_params = gson.toJson(passback_params_map);
        model.setBody("yoooho臻选");
        model.setSubject("yoooho臻选" +"【"+order.getPromotionInfo()+"】");
        model.setOutTradeNo(order.getOrderSn());//商户网站唯一订单号
        model.setTimeoutExpress("30m");
        model.setTotalAmount(order.getPayAmount().toString());
//        model.setTotalAmount("0.01");
        model.setProductCode("QUICK_MSECURITY_PAY");
        model.setPassbackParams(passback_params);
        ali_request.setBizModel(model);
        ali_request.setNotifyUrl(alipayConfig.getNotifyUrl());
        String alipayOrder = "";
        try {
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse alipayTradeAppPayResponse = alipayClient.sdkExecute(ali_request);
            alipayOrder = alipayTradeAppPayResponse.getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return alipayOrder;
    }

    @Override
    public String generaterAliPayH5Order(OmsOrder order) {
        AlipayConfig alipayConfig = alipayService.find();
        AlipayClient alipayClient = alipayService.getAlipayClient();
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
        alipayRequest.setReturnUrl(alipayConfig.getReturnUrl());
        alipayRequest.setNotifyUrl(alipayConfig.getNotifyUrl());//在公共参数中设置回跳和通知地址
        Map<String, Object> parMap = new HashMap<String, Object>();
        parMap.put("out_trade_no",order.getOrderSn());
        parMap.put("subject","yoooho臻选" +"【"+order.getPromotionInfo()+"】");
        parMap.put("total_amount",order.getPayAmount().toString());
//        parMap.put("total_amount","0.01");
        parMap.put("product_code","QUICK_WAP_WAY");
        parMap.put("body","yoooho臻选");
        alipayRequest.setBizContent(JSON.toJSONString(parMap));
        String form = null; //调用SDK生成表单
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return form;
    }

    public String  handelAliPayNotice(HttpServletRequest request, HttpServletResponse respons) throws Exception{
        Map<String, String> params = new HashMap<String, String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            params.put(name, valueStr);
            System.out.println(name + "------" + valueStr);
        }
        AlipayConfig alipayConfig = alipayService.find();
        //切记alipaypublickey是支付宝的公钥，请去open.alipay.com对应应用下查看。
        boolean flag = AlipaySignature.rsaCheckV1(params, alipayConfig.getPublicKey(), alipayConfig.getInput_charset(),alipayConfig.getSignType());
        if (flag) {
            System.out.println("支付成功");
            String outTradeNo = params.get("out_trade_no");//商户网站唯一订单号
            String trade_no = params.get("trade_no");//该交易在支付宝系统中的交易流水号
            System.out.println(params);
            //更新订单状态
            boolean res =  portalOrderService.updateOrderByPaySuccess(trade_no, outTradeNo, 1, 0);
            if (res){
                return "success";
            }
        } else {
            System.out.println("支付失败");
        }
        return "";
    }



}
