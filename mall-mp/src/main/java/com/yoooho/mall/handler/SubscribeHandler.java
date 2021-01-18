package com.yoooho.mall.handler;

import cn.hutool.core.util.ObjectUtil;
import com.yoooho.mall.domian.WechatReply;
import com.yoooho.mall.service.MsgReplyService;
import com.yoooho.mall.service.WechatReplyRuleService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class SubscribeHandler extends AbstractHandler {

    @Autowired
    private WechatReplyRuleService wechatReplyService;

    @Autowired
    MsgReplyService msgReplyService;
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) throws WxErrorException {

        this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser() + "，事件：" + wxMessage.getEventKey());

        String str = "你好，欢迎关注";

        WechatReply wechatReply = wechatReplyService.isExist("subscribe");

        if(!ObjectUtil.isNull(wechatReply)){
            str = wechatReply.getReplyContent();
            try {
                WxMpXmlOutMessage msg= WxMpXmlOutMessage.TEXT()
                        .content(str)
                        .fromUser(wxMessage.getToUser())
                        .toUser(wxMessage.getFromUser())
                        .build();
                return msg;
            } catch (Exception e) {
                this.logger.error(e.getMessage(), e);
            }
        }else{
            msgReplyService.tryAutoReply(true, wxMessage.getFromUser(), wxMessage.getEvent());
        }
        return null;
    }



}
