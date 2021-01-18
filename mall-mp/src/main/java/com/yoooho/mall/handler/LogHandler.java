package com.yoooho.mall.handler;

import com.alibaba.fastjson.JSON;
import com.yoooho.mall.service.WechatMsgSevice;
import com.yoooho.mall.utils.WXMsgTool;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LogHandler extends AbstractHandler {
    @Autowired
    WechatMsgSevice wxMsgService;
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) {
        this.logger.info("\n接收到请求消息，内容：{}", JSON.toJSONString(wxMessage));
        wxMsgService.addWxMsg(WXMsgTool.getWxMsg(wxMessage));
        return null;
    }

}
