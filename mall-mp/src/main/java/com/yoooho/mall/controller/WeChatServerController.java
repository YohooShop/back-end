package com.yoooho.mall.controller;


import com.yoooho.mall.common.annotation.AnonymousAccess;
import com.yoooho.mall.config.WxMpConfiguration;
import com.yoooho.mall.model.WxOfficialAccountConfig;
import com.yoooho.mall.service.SystemConfigService;
import com.yoooho.mall.utils.SignUtil;
import io.swagger.annotations.Api;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@CrossOrigin
@RequestMapping("/api/wechat")
@Api(tags = "WeChatServerController",description = "微信接口管理")
public class WeChatServerController {

    @Autowired
    private SystemConfigService systemConfigService;


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/serve")
    @AnonymousAccess
    public void get(HttpServletRequest request, HttpServletResponse response) {
        // 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = null;
        try {
            out = response.getWriter();
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                out.print(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            out = null;
        }
    }
    @PostMapping(value = "/serve", produces = "application/xml; charset=UTF-8")
    public String post(@RequestBody String requestBody,
                     @RequestParam("signature") String signature,
                     @RequestParam("timestamp") String timestamp,
                     @RequestParam("nonce") String nonce,
                     @RequestParam("openid") String openid,
                     @RequestParam(name = "encrypt_type", required = false) String encType,
                     @RequestParam(name = "msg_signature", required = false) String msgSignature) {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        if (!wxService.checkSignature(timestamp, nonce, signature)) {
            throw new IllegalArgumentException("非法请求，可能属于伪造的请求！");
        }
        String out = null;
        if (encType == null) {
            // 明文传输的消息
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(requestBody);
            WxMpXmlOutMessage outMessage = this.route(inMessage);
            if (outMessage == null) {
                return "";
            }

            out = outMessage.toXml();
        } else if ("aes".equalsIgnoreCase(encType)) {
            // aes加密的消息
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(requestBody, wxService.getWxMpConfigStorage(),
                    timestamp, nonce, msgSignature);
            logger.debug("\n消息解密后内容为：\n{} ", inMessage.toString());
            WxMpXmlOutMessage outMessage = this.route(inMessage);
            if (outMessage == null) {
                return "";
            }
            out = outMessage.toEncryptedXml(wxService.getWxMpConfigStorage());
        }

        logger.debug("\n组装回复信息：{}", out);
        return out;
    }

    private WxMpXmlOutMessage route(WxMpXmlMessage message) {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpMessageRouter messageRouter =   WxMpConfiguration.getWxMpMessageRouter(config);
        try {
            return messageRouter.route(message);
        } catch (Exception e) {
            logger.error("路由消息时出现异常！", e);
        }
        return null;
    }


}
