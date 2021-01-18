package com.yoooho.mall.controller;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.annotation.AnonymousAccess;
import com.yoooho.mall.service.impl.MyWxMpService;
import me.chanjar.weixin.common.error.WxErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
@RequestMapping(value = "/wechat/share")
public class WxShareController {

    @Autowired
    MyWxMpService wxMpService;
    /**
     * 获取jssdk签名
     * @return
     */
    @RequestMapping(value = "/getSignPackage", method = RequestMethod.POST)
    @AnonymousAccess
    public CommonResult getSignPackage(String url) throws WxErrorException {
        return CommonResult.success(wxMpService.createJsapiSignature(url));
    }
}
