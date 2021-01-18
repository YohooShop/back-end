package com.yoooho.mall.handler;


import com.yoooho.mall.service.MsgReplyService;
import com.yoooho.mall.service.WechatMsgSevice;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

@Component
public class MsgHandler extends AbstractHandler {

    @Autowired
    MsgReplyService msgReplyService;
    @Autowired
    WechatMsgSevice wechatMsgSevice;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {

        if (!wxMessage.getMsgType().equals(XmlMsgType.EVENT)) {
            //TODO 可以选择将消息保存到本地
        }

        String textContent = wxMessage.getContent();
        String fromUser = wxMessage.getFromUser();
        boolean autoReplyed =  msgReplyService.tryAutoReply(false, fromUser, textContent);

        //当用户输入关键词如“你好”，“客服”等，并且有客服在线时，把消息转发给在线客服
//        try {
//            if (StringUtils.startsWithAny(wxMessage.getContent(), "人工", "客服")
//                && weixinService.getKefuService().kfOnlineList()
//                .getKfOnlineList().size() > 0 ) {
//
//              wechatMsgSevice.addWxMsg(WXMsgTool.buildOutMsg(WxConsts.KefuMsgType.TRANSFER_CUSTOMER_SERVICE,fromUser,null));
//                return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE                                                                                                                                                                         ()
//                    .fromUser(wxMessage.getToUser())
//                    .toUser(wxMessage.getFromUser()).build();
//            }
//        } catch (WxErrorException e) {
//            e.printStackTrace();
//        }
        return null;

    }

}
