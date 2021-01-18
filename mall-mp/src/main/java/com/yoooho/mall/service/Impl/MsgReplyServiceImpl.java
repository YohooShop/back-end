package com.yoooho.mall.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.yoooho.mall.common.validator.Assert;
import com.yoooho.mall.config.TaskExcutor;
import com.yoooho.mall.config.WxMpConfiguration;
import com.yoooho.mall.mapper.WechatReplyContentMapper;
import com.yoooho.mall.model.*;
import com.yoooho.mall.service.*;
import com.yoooho.mall.service.*;
import com.yoooho.mall.utils.WXMsgTool;
import com.yoooho.mall.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 微信公众号消息处理
 * 官方文档：https://developers.weixin.qq.com/doc/offiaccount/Message_Ma nagement/Service_Center_messages.html#7
 * 参考WxJava客服消息文档：https://github.com/Wechat-Group/WxJava/wiki/MP_主动发送消息（客服消息）
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MsgReplyServiceImpl implements MsgReplyService {

    @Autowired
    WechatMsgSevice wechatMsgSevice;
    @Autowired
    WechatReplyRuleService msgReplyRuleService;

    @Autowired
    SystemConfigService systemConfigService;

    @Autowired
    WechatReplyContentMapper replyContentMapper;

    @Autowired
    ArticleService articleService;
    @Value("${wx.mp.autoReplyInterval:1000}")
    Long autoReplyInterval;

    /**
     * 根据规则配置通过微信客服消息接口自动回复消息
     *
     * @param exactMatch 是否精确匹配
     * @param toUser     用户openid
     * @param keywords   匹配关键词
     * @return 是否已自动回复，无匹配规则则不自动回复
     */
    @Override
    public boolean tryAutoReply(boolean exactMatch, String toUser, String keywords) {
        try {
            List<WechatReply> rules = msgReplyRuleService.getMatchedRules(exactMatch, keywords);
            if (rules.isEmpty()) return false;
            long delay = 0;
            for (WechatReply rule : rules) {
                TaskExcutor.schedule(() -> {
                    this.reply(toUser,rule.getReplyType(),rule.getReplyContent());
                }, delay, TimeUnit.MILLISECONDS);
                delay += autoReplyInterval;
            }
            return true;
        } catch (Exception e) {
            log.error("自动回复出错：", e);
        }
        return false;
    }

    @Override
    public void replyText(String toUser, String content) throws WxErrorException {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        wxService.getKefuService().sendKefuMessage(WxMpKefuMessage.TEXT().toUser(toUser).content(content).build());

        JSONObject json = new JSONObject().fluentPut("content",content);
        wechatMsgSevice.addWxMsg(WXMsgTool.buildOutMsg(WxConsts.KefuMsgType.TEXT,toUser,json));
    }

    @Override
    public void replyImage(String toUser, String mediaId) throws WxErrorException {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        wxService.getKefuService().sendKefuMessage(WxMpKefuMessage.IMAGE().toUser(toUser).mediaId(mediaId).build());
        JSONObject json = new JSONObject().fluentPut("mediaId",mediaId);
        wechatMsgSevice.addWxMsg(WXMsgTool.buildOutMsg(WxConsts.KefuMsgType.IMAGE,toUser,json));
    }

    @Override
    public void replyVoice(String toUser, String mediaId) throws WxErrorException {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        wxService.getKefuService().sendKefuMessage(WxMpKefuMessage.VOICE().toUser(toUser).mediaId(mediaId).build());
        JSONObject json = new JSONObject().fluentPut("mediaId",mediaId);
        wechatMsgSevice.addWxMsg(WXMsgTool.buildOutMsg(WxConsts.KefuMsgType.VOICE,toUser,json));
    }

    @Override
    public void replyVideo(String toUser, String mediaId) throws WxErrorException {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        wxService.getKefuService().sendKefuMessage(WxMpKefuMessage.VIDEO().toUser(toUser).mediaId(mediaId).build());
        JSONObject json = new JSONObject().fluentPut("mediaId",mediaId);
        wechatMsgSevice.addWxMsg(WXMsgTool.buildOutMsg(WxConsts.KefuMsgType.VIDEO,toUser,json));
    }

    @Override
    public void replyMusic(String toUser, String musicInfoJson) throws WxErrorException {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        JSONObject json = JSON.parseObject(musicInfoJson);
        wxService.getKefuService().sendKefuMessage(
            WxMpKefuMessage.MUSIC().toUser(toUser)
                .musicUrl(json.getString("musicurl"))
                .hqMusicUrl(json.getString("hqmusicurl"))
                .title(json.getString("title"))
                .description(json.getString("description"))
                .thumbMediaId(json.getString("thumb_media_id"))
                .build());

        wechatMsgSevice.addWxMsg(WXMsgTool.buildOutMsg(WxConsts.KefuMsgType.IMAGE,toUser,json));
    }

    /**
     * 发送图文消息（点击跳转到外链） 图文消息条数限制在1条以内
     * @param toUser
     * @param articleIdStr
     * @throws WxErrorException
     */
    @Override
    public void replyNews(String toUser, String articleIdStr) throws WxErrorException {

        Assert.isBlank(articleIdStr,"文章ID不得为空");
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        Long replyId = Long.parseLong(articleIdStr);

        WechatReplyContentExample example = new WechatReplyContentExample();
        example.createCriteria().andWechatReplyIdEqualTo(replyId);
        List<WechatReplyContent> wechatReplyContents = replyContentMapper.selectByExampleWithBLOBs(example);
        if (wechatReplyContents.size() == 1){
            WechatReplyContent wechatReplyContent = wechatReplyContents.get(0);
            Map map = (Map) JSONObject.parse(wechatReplyContent.getContent());
            WxMpKefuMessage.WxArticle wxArticle = new WxMpKefuMessage.WxArticle((String) map.get("title"),(String)map.get("desc"),(String)map.get("link"),(String)map.get("image"));
            List<WxMpKefuMessage.WxArticle> newsList = new ArrayList<WxMpKefuMessage.WxArticle>(){{add(wxArticle);}};
            wxService.getKefuService().sendKefuMessage(WxMpKefuMessage.NEWS().toUser(toUser).articles(newsList).build());
            wechatMsgSevice.addWxMsg(WXMsgTool.buildOutMsg(WxConsts.KefuMsgType.NEWS,toUser,(JSONObject) JSONObject.parse(wechatReplyContent.getContent())));
        }

    }

    /**
     * 发送图文消息（点击跳转到图文消息页面） 图文消息条数限制在1条以内
     * @param toUser
     * @param mediaId
     * @throws WxErrorException
     */
    @Override
    public void replyMpNews(String toUser, String mediaId) throws WxErrorException {
        WechatArticle a = articleService.findById(Integer.parseInt(mediaId));

        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        wxService.getKefuService().sendKefuMessage(WxMpKefuMessage.MPNEWS().toUser(toUser).mediaId(a.getMediaId()).build());

        JSONObject json = new JSONObject().fluentPut("mediaId",mediaId);
        wechatMsgSevice.addWxMsg(WXMsgTool.buildOutMsg(WxConsts.KefuMsgType.MPNEWS,toUser,json));
    }

    @Override
    public void replyWxCard(String toUser, String cardId) throws WxErrorException {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        wxService.getKefuService().sendKefuMessage(WxMpKefuMessage.WXCARD().toUser(toUser).cardId(cardId).build());

        JSONObject json = new JSONObject().fluentPut("cardId",cardId);
        wechatMsgSevice.addWxMsg(WXMsgTool.buildOutMsg(WxConsts.KefuMsgType.WXCARD,toUser,json));
    }

    @Override
    public void replyMiniProgram(String toUser, String miniProgramInfoJson) throws WxErrorException {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        JSONObject json = JSON.parseObject(miniProgramInfoJson);
        wxService.getKefuService().sendKefuMessage(
            WxMpKefuMessage.MINIPROGRAMPAGE()
                .toUser(toUser)
                .title(json.getString("title"))
                .appId(json.getString("appid"))
                .pagePath(json.getString("pagepath"))
                .thumbMediaId(json.getString("thumb_media_id"))
                .build());

        wechatMsgSevice.addWxMsg(WXMsgTool.buildOutMsg(WxConsts.KefuMsgType.IMAGE,toUser,json));
    }

    @Override
    public void replyMsgMenu(String toUser, String msgMenusJson) throws WxErrorException {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        JSONObject json = JSON.parseObject(msgMenusJson);
        List<WxMpKefuMessage.MsgMenu> msgMenus = json.getJSONArray("list").toJavaList(WxMpKefuMessage.MsgMenu.class);
        wxService.getKefuService().sendKefuMessage(
            WxMpKefuMessage.MSGMENU()
                .toUser(toUser)
                .headContent(json.getString("head_content"))
                .tailContent(json.getString("tail_content"))
                .msgMenus(msgMenus).build());

        wechatMsgSevice.addWxMsg(WXMsgTool.buildOutMsg(WxConsts.KefuMsgType.IMAGE,toUser,json));
    }



}
