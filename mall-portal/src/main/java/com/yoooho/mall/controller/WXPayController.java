package com.yoooho.mall.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.annotation.AnonymousAccess;
import com.yoooho.mall.model.UmsMember;
import com.yoooho.mall.model.WxAppConfig;
import com.yoooho.mall.service.*;
import com.yoooho.mall.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
@CrossOrigin
@RequestMapping("/wechatpay")
@Api(tags = "WXpayController",description = "微信支付接口管理")
public class WXPayController {
    @Autowired
    WXPayService wxPayService;
    @Autowired
    private OmsPortalOrderService portalOrderService;

    @Autowired
    WXService wxService;
    @Autowired
    SystemConfigService systemConfigService;

    @Autowired
    UmsMemberService memberService;
    @ApiOperation("app微信支付创建订单")
    @RequestMapping(value = "/payOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object pay(@RequestParam("orderId") Long orderId){
        return portalOrderService.pay(orderId,2);
    }

    @ApiOperation("h5微信支付创建订单")
    @RequestMapping(value = "/payOrderH5",method = RequestMethod.POST)
    @ResponseBody
    public Object payOrderH5(@RequestParam("orderId") Long orderId){
       Object ob = portalOrderService.payWeb(orderId,2);
        if(ob == null){
            return CommonResult.failed();
        }else {
            return CommonResult.success(ob);
        }
    }

    @ApiOperation("JSAPI支付创建订单")
    @RequestMapping(value = "/payOrderJS",method = RequestMethod.POST)
    @ResponseBody
    public Object payOrderJS(@RequestParam("orderId") Long orderId){
        UmsMember member = memberService.getCurrentMember();
        String openId = memberService.getMemberOpenId(member.getId());

        if (openId == null) {
            return CommonResult.failed("没有授权微信，请先授权微信");
        }
        Object ob = portalOrderService.payOrderJS(orderId,openId);
        if(ob == null){
            return CommonResult.failed();
        }else {
            return CommonResult.success(ob);
        }
    }


    @ApiOperation("小程序微信支付创建订单")
    @RequestMapping(value = "/payOrderSP",method = RequestMethod.POST)
    @ResponseBody
    public Object payOrderSP(@RequestParam("orderId") Long orderId, @RequestParam("code") String code){

//        UmsMember member = memberService.getCurrentMember();
//        String openId = memberService.getMemberOpenId(member.getId());
//
//        if (openId == null) {
//            return CommonResult.failed("没有授权微信，请先授权微信");
//        }
        WxAppConfig config = systemConfigService.queryWXAPPConfig();
        JSONObject jsonObject = (JSONObject) wxService.getAuthCode2Session(config.getAppId(),config.getSecret(),code);

        if (jsonObject == null) {
            return CommonResult.failed();
        }

        String openid = jsonObject.getString("openid");

        if (openid  == null) {
            return CommonResult.failed();
        }


        Object ob = portalOrderService.payOrderSP(orderId,openid);
        if(ob == null){
            return CommonResult.failed();
        }else {
            return CommonResult.success(ob);
        }
    }

    //微信支付回调
    /**
     * 应用网关，用于接收微信异步通知
     */

    @RequestMapping(value="getAsyncWXAppPayNotice.htm",method={RequestMethod.POST, RequestMethod.GET})
    @AnonymousAccess
    String getAsyncAppWXPayNotice(HttpServletRequest request, HttpServletResponse response) {
       return hanldeWXPayNotice(request,response,1);
    }

    @RequestMapping(value="getAsyncWXH5PayNotice.htm",method={RequestMethod.POST, RequestMethod.GET})
    @AnonymousAccess
    String getAsyncH5WXPayNotice(HttpServletRequest request, HttpServletResponse response) {
       return hanldeWXPayNotice(request,response,2);
    }

    @RequestMapping(value="getAsyncWXSPPayNotice.htm",method={RequestMethod.POST, RequestMethod.GET})
    @AnonymousAccess
    String getAsyncSPWXPayNotice(HttpServletRequest request, HttpServletResponse response) {
       return hanldeWXPayNotice(request,response,3);
    }

    @RequestMapping(value="getAsyncWXJSPayNotice.htm",method={RequestMethod.POST, RequestMethod.GET})
    @AnonymousAccess
    String getAsyncSPJSPayNotice(HttpServletRequest request, HttpServletResponse response) {
        return hanldeWXPayNotice(request,response,4);
    }

    public String hanldeWXPayNotice(HttpServletRequest request, HttpServletResponse response ,int type) {
        String resXml = "";
        try {
            InputStream inputStream = request.getInputStream();
            //将InputStream转换成xmlString
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            resXml = sb.toString();
            String result = wxPayService.payBack(resXml,type);
            return result;
        } catch (Exception e) {
            return WxPayNotifyResponse.fail("失败");
        }
    }

}
