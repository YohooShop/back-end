package com.yoooho.mall.utils;

import com.alibaba.fastjson.JSONObject;
import com.yoooho.mall.model.WechatMsg;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;

import java.util.Date;

public class WXMsgTool {
    public static class WxMsgInOut{
        static final byte IN=0;
        static final byte OUT=1;
    }

    public static WechatMsg getWxMsg(WxMpXmlMessage wxMessage) {
        WechatMsg msg = new WechatMsg();
        msg.setOpenid(wxMessage.getFromUser());
        msg.setInOut(WxMsgInOut.IN);
        msg.setMsgType(wxMessage.getMsgType());
        JSONObject detailJosn = new JSONObject();

        Long createTime = wxMessage.getCreateTime();
        msg.setCreateTime(createTime==null?new Date():new Date(createTime*1000));
        if(WxConsts.XmlMsgType.TEXT.equals(msg.getMsgType())){
            detailJosn.put("content",wxMessage.getContent());
        }else if(WxConsts.XmlMsgType.IMAGE.equals(msg.getMsgType())){
            detailJosn.put("picUrl",wxMessage.getPicUrl());
            detailJosn.put("mediaId",wxMessage.getMediaId());
        }else if(WxConsts.XmlMsgType.VOICE.equals(msg.getMsgType())){
            detailJosn.put("format",wxMessage.getFormat());
            detailJosn.put("mediaId",wxMessage.getMediaId());
        }else if(WxConsts.XmlMsgType.VIDEO.equals(msg.getMsgType()) ||
                WxConsts.XmlMsgType.SHORTVIDEO.equals(msg.getMsgType())){
            detailJosn.put("thumbMediaId",wxMessage.getThumbMediaId());
            detailJosn.put("mediaId",wxMessage.getMediaId());
        }else if(WxConsts.XmlMsgType.LOCATION.equals(msg.getMsgType())){
            detailJosn.put("locationX",wxMessage.getLocationX());
            detailJosn.put("locationY",wxMessage.getLocationY());
            detailJosn.put("scale",wxMessage.getScale());
            detailJosn.put("label",wxMessage.getLabel());
        }else if(WxConsts.XmlMsgType.LINK.equals(msg.getMsgType())){
            detailJosn.put("title",wxMessage.getTitle());
            detailJosn.put("description",wxMessage.getDescription());
            detailJosn.put("url",wxMessage.getUrl());
        }else if(WxConsts.XmlMsgType.EVENT.equals(msg.getMsgType())){
            detailJosn.put("event",wxMessage.getEvent());
            detailJosn.put("eventKey",wxMessage.getEventKey());
        }
        msg.setDetail(JSONObject.toJSONString(detailJosn));

        return msg;
    }

    public static WechatMsg buildOutMsg(String msgType,String openid,JSONObject detail){
        WechatMsg wxMsg = new WechatMsg();
        wxMsg.setMsgType(msgType);
        wxMsg.setOpenid(openid);
        wxMsg.setDetail(JSONObject.toJSONString(detail));
        wxMsg.setCreateTime(new Date());
        wxMsg.setInOut(WxMsgInOut.OUT);
        return wxMsg;
    }
}
