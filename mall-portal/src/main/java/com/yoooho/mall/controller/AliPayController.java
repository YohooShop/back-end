package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.annotation.AnonymousAccess;
import com.yoooho.mall.service.OmsPortalOrderService;
import com.yoooho.mall.service.AliPayOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

@RestController
@CrossOrigin
@Api(tags = "AlipayController",description = "支付宝支付接口管理")
@RequestMapping("/alipay")
public class AliPayController {

    @Autowired
    private OmsPortalOrderService portalOrderService;

    @Autowired
    private AliPayOrderService aliPayService;
    @ApiOperation("支付宝支付创建订单")
    @RequestMapping(value = "/payOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object pay(@RequestParam("orderId") Long orderId){
        return portalOrderService.pay(orderId,1);
    }
    @ApiOperation("支付宝支付H5创建订单")
    @RequestMapping(value = "/payH5Order",method = RequestMethod.POST)
    @ResponseBody
    public Object payH5Order(@RequestParam("orderId") Long orderId) {
        Object ob = portalOrderService.payWeb(orderId,1);
        if (ob == null){
            return CommonResult.failed();
        }else {
            return CommonResult.success(ob);
        }
    }

    //支付包支付回调
    /**
     * 应用网关，用于接收支付宝异步通知
     * @throws UnsupportedEncodingException
     * @throws ParseException
     */
    @RequestMapping(value="getAsyncAliPayNotice.htm",method={RequestMethod.POST, RequestMethod.GET})
    @AnonymousAccess
    String getAsyncAliPayNotice(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取支付宝POST过来反馈信息
       return aliPayService.handelAliPayNotice(request,response);
    }
}
