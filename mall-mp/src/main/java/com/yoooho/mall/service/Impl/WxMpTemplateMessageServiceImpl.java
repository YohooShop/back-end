package com.yoooho.mall.service.Impl;

import com.yoooho.mall.config.WxMpConfiguration;
import com.yoooho.mall.service.SystemConfigService;
import com.yoooho.mall.service.WxMpTemplateMessageService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WxMpTemplateMessageServiceImpl implements WxMpTemplateMessageService {
    @Autowired
    SystemConfigService systemConfigService;
    @Override
    public String sendWxMpTemplateMessage(String openId, String templateId, String url, Map<String,String> map){
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openId)
                .templateId(templateId)
                .url(url)
                .build();
        map.forEach( (k,v)-> { templateMessage.addData(new WxMpTemplateData(k, v, "#000000"));} );
        String msgId = null;
        WxMpService wxService = WxMpConfiguration.getWxMpService(systemConfigService.queryWXOfficialAccountConfig());
        try {
            msgId =   wxService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return msgId;
    }
}
