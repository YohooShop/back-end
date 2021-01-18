package com.yoooho.mall.service.Impl;

import com.yoooho.mall.domian.WechatTemplate;
import com.yoooho.mall.service.WechatTemplateService;
import com.yoooho.mall.service.WxMpTemplateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName 微信公众号模板通知
 **/
@Service

public class TemplateService {
    private final String PAY_SUCCESS_KEY = "OPENTM207791277"; //pay
    private final String DELIVERY_SUCCESS_KEY = "OPENTM200565259"; //Delivery
    private final String REFUND_SUCCESS_KEY = "OPENTM410119152"; //Refund
    private final String RECHARGE_SUCCESS_KEY = "OPENTM405847076"; //Recharge
    private final String ORDER_SUCCESS_KEY = "OPENTM202297555"; //Recharge
    private final String GROUP_BUYING_OPEN_SUCCESS_KEY = "OPENTM202297556";

    @Autowired
    private WechatTemplateService templateService;
    @Autowired
    private WxMpTemplateMessageService templateMessageService;

    /**
     * 支付成功通知
     * @param time
     * @param price
     * @param openid
     */
    public void rechargeSuccessNotice(String time,String price,String openid){
       String siteUrl = "";
        WechatTemplate WechatTemplate = templateService.findByTempkey(RECHARGE_SUCCESS_KEY);
        Map<String,String> map = new HashMap<>();
        map.put("first","您的账户金币发生变动，详情如下：");
        map.put("keyword1","充值");
        map.put("keyword2",time);
        map.put("keyword3",price);
        map.put("remark","Yoooho电商系统为你服务！");
        templateMessageService.sendWxMpTemplateMessage( openid
                ,WechatTemplate.getTempid(),
                siteUrl+"/user/account",map);
    }

    /**
     * 支付成功通知
     * @param orderId
     * @param price
     * @param openid
     */
    public void paySuccessNotice(String orderId, String orderSn,String price,String openid){

        WechatTemplate wechatTemplate = templateService.findByTempkey(PAY_SUCCESS_KEY);

        String siteUrl = wechatTemplate.getOpenUrl()+"?orderId="+orderId;

        Map<String,String> map = new HashMap<>();
        map.put("first","您的订单已支付成功，我们会尽快为您发货。");
        map.put("keyword1",orderSn);//订单号
        map.put("keyword2",price);
        map.put("remark","Yoooho电商系统为你服务！");
        templateMessageService.sendWxMpTemplateMessage( openid
                ,wechatTemplate.getTempid(),
                siteUrl,map);
    }

    /**
     * 下单成功通知到店员
     * @param orderId
     * @param amountRemark
     * @param openid
     */
    public void orderSuccessNotice(String orderId, String orderSn,String openid, String productName,String numberRemark,String amountRemark,String payment){
        WechatTemplate wechatTemplate = templateService.findByTempkey(ORDER_SUCCESS_KEY);

        String siteUrl = wechatTemplate.getOpenUrl()+"?id="+orderId;

        Map<String,String> map = new HashMap<>();
        map.put("first","亲，您有一个新订单，请您备货，订单详情如下");
        map.put("keyword1",orderSn);//订单号
        map.put("keyword2",productName);
        map.put("keyword3",numberRemark);
        map.put("keyword2",amountRemark);
        map.put("keyword2",payment);
        map.put("remark","Yoooho电商系统为你服务！");
        templateMessageService.sendWxMpTemplateMessage( openid
                ,wechatTemplate.getTempid(),
                siteUrl,map);

    }



    /**
     * 退款成功通知
     * * @param orderId
     * @param orderSn
     * @param price
     * @param openid
     * @param time
     */
    public void refundSuccessNotice(String orderId, String orderSn,String price,String openid,String time){

        WechatTemplate wechatTemplate = templateService.findByTempkey(REFUND_SUCCESS_KEY);
        String siteUrl = wechatTemplate.getOpenUrl()+"?orderSn="+orderId;
        Map<String,String> map = new HashMap<>();
        map.put("first","您在Yoooho的订单退款申请被通过，钱款将很快还至您的支付账户。");
        map.put("keyword1",orderSn);//订单号
        map.put("keyword2",price);
        map.put("keyword3", time);
        map.put("remark","Yoooho电商系统为你服务！");
        templateMessageService.sendWxMpTemplateMessage( openid
                ,wechatTemplate.getTempid(),
                siteUrl,map);
    }

    /**
     * 发货成功通知
     * @param orderId
     * @param deliveryName
     * @param deliveryId
     * @param openid
     */
    public void deliverySuccessNotice(String orderId, String orderSn,String deliveryName,String deliveryId,String openid){

        WechatTemplate wechatTemplate = templateService.findByTempkey(DELIVERY_SUCCESS_KEY);

        String siteUrl = wechatTemplate.getOpenUrl()+"?orderId="+orderId;

        Map<String,String> map = new HashMap<>();
        map.put("first","亲，宝贝已经启程了，好想快点来到你身边。");
        map.put("keyword1",orderSn);//订单号
        map.put("keyword2",deliveryName);
        map.put("keyword3",deliveryId);
        map.put("remark","Yoooho电商系统为你服务！");
        templateMessageService.sendWxMpTemplateMessage( openid
                ,wechatTemplate.getTempid(),
                siteUrl,map);
    }

    /**
     * 开团成功提醒
     * @param orderId
     * @param deliveryName
     * @param deliveryId
     * @param openid
     */

    /**
     * {{first.DATA}}
     * 商品名称：{{keyword1.DATA}}
     * 商品价格：{{keyword2.DATA}}
     * 组团人数：{{keyword3.DATA}}
     * 拼团类型：{{keyword4.DATA}}
     * 组团时间：{{keyword5.DATA}}
     * {{remark.DATA}}
     * */
    public void groupBuyingOpenSuccessNotice(String openid ,String name, String pinkId, String price , String people, String type, String time){
        WechatTemplate wechatTemplate = templateService.findByTempkey(GROUP_BUYING_OPEN_SUCCESS_KEY);
        String siteUrl = wechatTemplate.getOpenUrl()+"?pinkId="+pinkId;
        Map<String,String> map = new HashMap<>();
        map.put("first","亲，您已成功发起一个拼团");
        map.put("keyword1",name);
        map.put("keyword2",price);
        map.put("keyword3",people);
        map.put("keyword4",type);
        map.put("keyword5",time);
        map.put("remark","Yoooho电商系统为你服务！");
        templateMessageService.sendWxMpTemplateMessage( openid
                ,wechatTemplate.getTempid(),
                siteUrl,map);
    }


}
