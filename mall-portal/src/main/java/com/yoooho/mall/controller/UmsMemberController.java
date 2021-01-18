package com.yoooho.mall.controller;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.common.annotation.AnonymousAccess;
import com.yoooho.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 会员登录注册管理Controller
 * Created by yoooho on 2019/8/3.
 */
@Controller
@CrossOrigin
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
@RequestMapping("/sso")
public class UmsMemberController {


    @Autowired
    private UmsMemberService memberService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation("注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @AnonymousAccess
    @ResponseBody
    public CommonResult register(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String telephone,
                                 @RequestParam String authCode) {
        return memberService.register(username, password, telephone, authCode);
    }

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @AnonymousAccess
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("验证码登录")
    @RequestMapping(value = "/smsCodeLogin", method = RequestMethod.POST)
    @AnonymousAccess
    @ResponseBody
    public CommonResult smsCodeLogin(@RequestParam String telephone,@RequestParam String authCode) {
        String token =  memberService.smsCodeLogin(telephone,authCode);
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }


    @ApiOperation("修改密码")
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone,
                                 @RequestParam String password,
                                 @RequestParam String authCode) {
        return memberService.updatePassword(telephone,password,authCode);
    }


    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/token/refresh", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken =memberService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed();
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getMemberCenterInfo() {

        return  memberService.getMemberCenterInfo();
    }

    @ApiOperation(value = "更新用户信息")
    @RequestMapping(value = "/info/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateMemberCenterInfo(@RequestParam int type, @RequestParam String value) {
        return memberService.updateMemberCenterInfo(type,value);
    }


    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success(null);
    }


    @ApiOperation(value = "置换微信")
    @RequestMapping(value = "/getToken", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult weChatLogin(@RequestParam String code) {
        String token =  memberService.weChatLogin(code);
        if (token == null) {
            return CommonResult.validateFailed("openid 为空");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(null);
    }






}
