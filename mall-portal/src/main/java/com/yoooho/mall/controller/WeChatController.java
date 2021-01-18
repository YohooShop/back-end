package com.yoooho.mall.controller;

import com.alibaba.fastjson.JSONObject;
import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.utils.WXAuthUtil;
import com.yoooho.mall.model.UmsMember;
import com.yoooho.mall.model.WxAppConfig;
import com.yoooho.mall.model.WxOfficialAccountConfig;
import com.yoooho.mall.service.SystemConfigService;
import com.yoooho.mall.service.UmsMemberService;
import com.yoooho.mall.service.WXService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@CrossOrigin
public class WeChatController {

    @Autowired
    SystemConfigService systemConfigService;

    @Autowired
    UmsMemberService memberService;
    @Autowired
    WXService wxService;
    @ApiOperation(value = "微信授权绑定")
    @RequestMapping(value = "/bindWX", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult bindWX(@RequestParam String code) {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        //发送请求 get提交 拿code凭证去获取openid和access_token

        JSONObject jsonObject = (JSONObject) wxService.getAuthCode2Token(config.getAppid(),config.getAppsecret(),code);



        String openid = jsonObject.getString("openid");
        String access_token = jsonObject.getString("access_token");
        if (openid  == null) {
            return CommonResult.failed();
        }
        //获取用户拿到openid 和access_token去获取用户信息，在页面中进行业务处理，获取存储在数据库中:
        //第四步(获取用户接口)
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token
                + "&openid="+openid
                + "&lang=zh_CN";
        JSONObject userInfo = null;
        try {
            userInfo = WXAuthUtil.doGetJson(infoUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("userInfo------:"+userInfo.toString());
        userInfo.getString("nickname");
        userInfo.getString("sex");
        userInfo.getString("country");
        userInfo.getString("province");
        userInfo.getString("city");
        userInfo.getString("headimgurl");
        userInfo.getString("language");
        userInfo.getString("privilege");
        userInfo.getString("openid");
        userInfo.getString("unionid");

        String  unionid = userInfo.getString("unionid");
        UmsMember member= memberService.getCurrentMember();
        boolean success = memberService.bindWX(openid,member.getId(), unionid);
        if (success) {
            return CommonResult.success(null);
        }else {
            return CommonResult.failed();
        }

    }
    @ApiOperation(value = "微信授权绑定取消")
    @RequestMapping(value = "/cancelBindWX", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult cancelBindWX() {
        memberService.cancelBindWX();
        return CommonResult.success("");
    }

    @ApiOperation(value = "获取小程序全局唯一后台接口调用凭据")
    @RequestMapping(value = "/APP/getAccessToken", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getAccessToken() {

       WxAppConfig wxAppConfig = systemConfigService.queryWXAPPConfig();
        String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&&appid="+wxAppConfig.getAppId()
                + "&secret="+wxAppConfig.getSecret();
        JSONObject object = null;
        try {
            object =   WXAuthUtil.doGetJson(tokenUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return CommonResult.success(object);
    }

    @ApiOperation(value = "获取小程序二维码")
    @RequestMapping(value = "/APP/getUnlimited", method = RequestMethod.POST)
    @ResponseBody

    public CommonResult getUnlimited(@RequestParam String pages,@RequestParam String scene,
                                     @RequestParam Integer width,@RequestParam String auto_color) {


        WxAppConfig wxAppConfig = systemConfigService.queryWXAPPConfig();
        String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&&appid="+wxAppConfig.getAppId()
                + "&secret="+wxAppConfig.getSecret();
        JSONObject object = null;
        try {
            object =   WXAuthUtil.doGetJson(tokenUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (object == null) {
            return CommonResult.failed();
        }
        //获取二维码
        String unlimitedUrl =  "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+ object.getString("access_token");
        JSONObject unlimitebject = null;
        try {
            unlimitebject =   WXAuthUtil.doPostJson(unlimitedUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (unlimitebject == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(object);
    }

}
