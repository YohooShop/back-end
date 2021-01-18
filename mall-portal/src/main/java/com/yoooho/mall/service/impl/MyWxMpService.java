package com.yoooho.mall.service.impl;
import com.yoooho.mall.config.WeChatAccountConfig;

import me.chanjar.weixin.common.bean.WxJsapiSignature;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.util.RandomUtils;
import me.chanjar.weixin.common.util.crypto.SHA1;

import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;


@Service
public class MyWxMpService extends WxMpServiceImpl {
    Logger log = LoggerFactory.getLogger(MyWxMpService.class);

    @Autowired
    private WeChatAccountConfig weChatAccountConfig;

    @PostConstruct
    public void init() {
        //放在内存中，这里可以放在缓存里
        // todo:

//
//        final WxMpConfigStorage config = new WxMpConfigStorage();
//        config.setAppId(this.weChatAccountConfig.getAppId());
//        config.setSecret(this.weChatAccountConfig.getSecret());
//        config.setToken(this.weChatAccountConfig.getToken());
//        config.setAesKey(this.weChatAccountConfig.getAesKey());
//        super.setWxMpConfigStorage(config);
    }

    /**
     * jssdk配置
     * sdk里面的这个方面sha1加密有错误，重写它
     *
     * @param url
     * @return
     * @throws WxErrorException
     */

    @Override
    public WxJsapiSignature createJsapiSignature(String url) throws WxErrorException {
        long timestamp = System.currentTimeMillis() / 1000L;
        String noncestr = RandomUtils.getRandomStr();
        String jsapiTicket = this.getJsapiTicket(false);
        String signature = null;
        signature = SHA1.genWithAmple(new String[]{"jsapi_ticket=" + jsapiTicket, "noncestr=" + noncestr, "timestamp=" + timestamp, "url=" + url});
        WxJsapiSignature jsapiSignature = new WxJsapiSignature();
        jsapiSignature.setAppId(this.getWxMpConfigStorage().getAppId());
        jsapiSignature.setTimestamp(timestamp);
        jsapiSignature.setNonceStr(noncestr);
        jsapiSignature.setUrl(url);
        jsapiSignature.setSignature(signature);
        return jsapiSignature;
    }


    public synchronized WxMpUser getWxMpUser(HttpServletRequest request) throws WxErrorException {
        String code = request.getParameter("code");
        log.info("wx code is :" + code);
        WxMpUser wxMpUser = null;
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = null;

        wxMpOAuth2AccessToken = oauth2getAccessToken(code);
        wxMpUser = oauth2getUserInfo(wxMpOAuth2AccessToken, null);

        return wxMpUser;
    }

    public synchronized WxMpUser getWxMpUserbycode(String code) throws WxErrorException {

        WxMpUser wxMpUser = null;
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = null;
        wxMpOAuth2AccessToken = oauth2getAccessToken(code);
        wxMpUser = oauth2getUserInfo(wxMpOAuth2AccessToken, null);

        return wxMpUser;
    }

    public WxJsapiSignature getJsapi(HttpServletRequest request) {
        String currentUrl = request.getRequestURL().toString() + "?" + request.getQueryString();
        log.info("current url is :" + currentUrl);
        //获取jssdk
        WxJsapiSignature jsapiSignature = null;
        try {
            jsapiSignature = this.createJsapiSignature(currentUrl);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return jsapiSignature;
    }
}
