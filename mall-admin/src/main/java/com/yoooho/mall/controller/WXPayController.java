package com.yoooho.mall.controller;

import com.github.binarywang.wxpay.bean.notify.WxPayNotifyResponse;
import com.github.binarywang.wxpay.bean.notify.WxPayRefundNotifyResult;
import com.github.binarywang.wxpay.service.WxPayService;
import com.yoooho.mall.config.WxPayConfiguration;
import com.yoooho.mall.service.SystemConfigService;
import com.yoooho.mall.service.WXPayService;
import com.yoooho.mall.service.WeChatPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
@CrossOrigin
@RequestMapping("/wechatpay")
public class WXPayController {
    @Autowired
    WeChatPayService payService;

    @Autowired
    SystemConfigService systemConfigService;

    @Autowired
    WXPayService wPayService;

    /**
     * 应用网关，用于接收微信异步通知
     */
    @RequestMapping(value="/getAsyncWXRefundPayNotice.htm",method={RequestMethod.POST, RequestMethod.GET})
    void getAsyncAppWXPayNotice(HttpServletRequest request, HttpServletResponse response) {
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
            WxPayService wxPayService = new WxPayConfiguration().getPayService(systemConfigService);
            final WxPayRefundNotifyResult notifyResult = wxPayService.parseRefundNotifyResult(resXml);
            String return_code = notifyResult.getReturnCode();//状态
            if (return_code.equals("SUCCESS")){
                //更新
                wPayService.refundBack(notifyResult.getReqInfo().getOutRefundNo());
                WxPayNotifyResponse.success("成功");
            }else {
                WxPayNotifyResponse.fail("失败");
            }
        } catch (Exception e) {
            System.out.println("微信退款支付失败:" + e.getMessage());
            WxPayNotifyResponse.fail("失败");
        }
    }
}
