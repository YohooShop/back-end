package com.yoooho.mall.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.google.gson.Gson;
//import AliPayConfig;
import com.yoooho.mall.mapper.OmsOrderRefundMapper;
import com.yoooho.mall.model.OmsOrder;
import com.yoooho.mall.model.OmsOrderRefund;
import com.yoooho.mall.service.AliPayOrderSerivce;

import com.yoooho.mall.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AliPayOrderSerivceImpl implements AliPayOrderSerivce {

    @Autowired
    AlipayService alipayService;

    @Autowired
    OmsOrderRefundMapper orderRefundMapper;

    public  String refundOrder(OmsOrder order, Long refundId){
        System.out.println("开始调用支付宝加密******************************************************");
        String outRequestNo = String.valueOf(new Date().getTime()) + String.valueOf(refundId);;
        AlipayClient alipayClient = alipayService.getAlipayClient();
        AlipayTradeRefundModel refundModel = new AlipayTradeRefundModel();
        refundModel.setTradeNo(order.getOuttradeno());
        refundModel.setOutTradeNo(order.getOrderSn());
        refundModel.setOutRequestNo(outRequestNo);
        refundModel.setRefundAmount(order.getPayAmount().toString());
        refundModel.setRefundReason("商品退款");
        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizModel(refundModel);
        try{
            AlipayTradeRefundResponse response = alipayClient.execute(request);
            System.out.println(response.getMsg()+"\n");
            System.out.println(response.getBody());
            Gson gson = new Gson();
           Map map = gson.fromJson(response.getBody(), HashMap.class);
           Map resMap = (Map) map.get("alipay_trade_refund_response");
           if (resMap.get("code").equals("10000")){

               //插入商户退款单号
               OmsOrderRefund omsOrderRefund = new OmsOrderRefund();
               omsOrderRefund.setId(refundId);
               omsOrderRefund.setOutRefundNo(outRequestNo);
               orderRefundMapper.updateByPrimaryKeySelective(omsOrderRefund);

               return "SUCCESS";
           }else {
               return " FAIL";
           }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("支付宝退款错误！"+e.getMessage());
            return " FAIL";
        }
    }



}
