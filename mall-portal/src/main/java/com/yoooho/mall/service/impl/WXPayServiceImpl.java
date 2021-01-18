package com.yoooho.mall.service.impl;

import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.yoooho.mall.config.WxPayConfiguration;
import com.yoooho.mall.model.OmsOrder;

import com.yoooho.mall.service.OmsPortalOrderService;
import com.yoooho.mall.service.SystemConfigService;
import com.yoooho.mall.service.WXPayService;

import com.yoooho.mall.service.WeChatPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class WXPayServiceImpl implements WXPayService {

    @Autowired
    OmsPortalOrderService portalOrderService;

    @Autowired
    SystemConfigService systemConfigService;
    @Autowired
    WeChatPayService weChatPayService;


    @Override
    public Object generaterWxPayOrder(OmsOrder order) throws Exception {


        return weChatPayService.appPay(order.getOrderSn(),"订单支付", Integer.valueOf(String.valueOf(order.getPayAmount().floatValue() * 100)),"Yoooho臻选好物");
    }

    @Override
    public Object generaterWxayH5Order(OmsOrder order) throws Exception {
        return weChatPayService.wxH5Pay(order.getOrderSn(),"订单支付", (int) (order.getPayAmount().floatValue() * 100),"Yoooho臻选好物");
    }

    @Override
    public Object generaterWxayJSOrder(OmsOrder order, String openId) throws Exception {
        return weChatPayService.wxPay(order.getOrderSn(),openId,"订单支付",(int) (order.getPayAmount().floatValue() * 100),"Yoooho臻选好物");
    }

    @Override
    public Object generaterWxSPOrder(OmsOrder order ,String openId) throws Exception {
        return weChatPayService.routinePay(order.getOrderSn(),"订单支付" ,openId, (int) (order.getPayAmount().floatValue() * 100),"Yoooho臻选好物");
    }


    @Override
    public String payBack(String resXml, int type) {
        try {
            WxPayService wxPayService = new WxPayConfiguration().getPayService(systemConfigService);
            final WxPayOrderNotifyResult notifyResult = wxPayService.parseOrderNotifyResult(resXml);
            String return_code = notifyResult.getReturnCode();//状态
            if (return_code.equals("SUCCESS")){
                String out_trade_no = notifyResult.getOutTradeNo() ;//商户订单号
                String transaction_id = notifyResult.getTransactionId(); //微信支付订单号
                if (out_trade_no != null) {
                    // 注意特殊情况：订单已经退款，但收到了支付结果成功的通知，不应把商户的订单状态从退款改成支付成功
                    // 注意特殊情况：微信服务端同样的通知可能会多次发送给商户系统，所以数据持久化之前需要检查是否已经处理过了，处理了直接返回成功标志
                    //业务数据持久化
                    log.info("微信手机支付回调成功订单号:{}", out_trade_no);
                    //更新订单状态
                    int soruceType = 0;
                    if (type == 0){
                        soruceType = 1;
                    }
                    if (type == 1){
                        soruceType = 2;
                    }
                    if (type == 2){
                        soruceType = 3;
                    }
                    portalOrderService.updateOrderByPaySuccess(transaction_id, out_trade_no, 2, soruceType);
                    return WxPayNotifyResponse.success("成功");

                } else {
                    log.info("微信手机支付回调失败订单号:{}", out_trade_no);
                    return WxPayNotifyResponse.fail("失败");
                }
            }else {
                // 签名错误，如果数据里没有sign字段，也认为是签名错误
                //失败的数据要不要存储？
                log.error("手机支付回调通知签名错误");
                return WxPayNotifyResponse.fail("失败");
            }
        } catch (WxPayException e) {
            e.printStackTrace();
            log.error("手机支付回调通知失败", e);
            return WxPayNotifyResponse.fail("失败");
        }

    }
}
