package com.yoooho.mall.config;


import com.google.common.collect.Maps;
import com.yoooho.mall.handler.*;
import com.yoooho.mall.model.WxOfficialAccountConfig;
import com.yoooho.mall.handler.*;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import me.chanjar.weixin.mp.constant.WxMpEventConstants;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.EventType;
import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * 公众号配置
 * @author hupeng
 * @date 2020/01/20
 */
@Configuration
public class WxMpConfiguration {

    private static Map<String, WxMpService> mpServices = Maps.newHashMap();
    private static Map<String, WxMpMessageRouter> routers = Maps.newHashMap();

    private static LogHandler logHandler;
    private static NullHandler nullHandler;
    private static KfSessionHandler kfSessionHandler;
    private static StoreCheckNotifyHandler storeCheckNotifyHandler;
    private static LocationHandler locationHandler;
    private static MenuHandler menuHandler;
    private static MsgHandler msgHandler;
    private static UnsubscribeHandler unsubscribeHandler;
    private static SubscribeHandler subscribeHandler;
    private static ScanHandler scanHandler;
    private static RedisHandler redisHandler;

    public WxMpConfiguration(LogHandler logHandler,NullHandler nullHandler,KfSessionHandler kfSessionHandler,
                             StoreCheckNotifyHandler storeCheckNotifyHandler,LocationHandler locationHandler,
                             MenuHandler menuHandler,MsgHandler msgHandler,UnsubscribeHandler unsubscribeHandler,
                             SubscribeHandler subscribeHandler,ScanHandler scanHandler,
                             RedisHandler redisHandler){
        this.logHandler = logHandler;
        this.nullHandler = nullHandler;
        this.kfSessionHandler = kfSessionHandler;
        this.storeCheckNotifyHandler = storeCheckNotifyHandler;
        this.locationHandler = locationHandler;
        this.menuHandler = menuHandler;
        this.msgHandler = msgHandler;
        this.unsubscribeHandler = unsubscribeHandler;
        this.subscribeHandler = subscribeHandler;
        this.scanHandler = scanHandler;
        this.redisHandler = redisHandler;
    }


    /**
     * 获取WxMpService
     * @return
     */
    public static WxMpService getWxMpService(WxOfficialAccountConfig config) {

        WxMpService wxMpService = mpServices.get(config.getApi());
        //增加一个redis标识
        if(wxMpService == null) {
            WxMpDefaultConfigImpl configStorage = new WxMpDefaultConfigImpl();
            configStorage.setAppId(config.getAppid());
            configStorage.setSecret(config.getAppsecret());
            configStorage.setToken(config.getToken());
            configStorage.setAesKey(config.getEncodingaeskey());
            wxMpService = new WxMpServiceImpl();
            wxMpService.setWxMpConfigStorage(configStorage);
            mpServices.put(config.getApi(), wxMpService);
            routers.put(config.getApi(), newRouter(wxMpService));
        }
        return wxMpService;
    }

    /**
     * 移除WxMpService
     */
    public static void removeWxMpService(WxOfficialAccountConfig config){
        mpServices.remove(config.getApi());
        routers.remove(config.getApi());
    }

    /**
     *  获取WxMpMessageRouter
     */
    public static WxMpMessageRouter getWxMpMessageRouter(WxOfficialAccountConfig config) {
        WxMpMessageRouter wxMpMessageRouter = routers.get(config.getApi());
        return wxMpMessageRouter;
    }

    private static WxMpMessageRouter newRouter(WxMpService wxMpService) {
        final WxMpMessageRouter newRouter = new WxMpMessageRouter(wxMpService);

        // 记录所有事件的日志 （异步执行）
        newRouter.rule().handler(logHandler).next();

        // 接收客服会话管理事件
        newRouter.rule().async(false).msgType(XmlMsgType.EVENT)
                .event(WxMpEventConstants.CustomerService.KF_CREATE_SESSION)
                .handler(kfSessionHandler).end();
        newRouter.rule().async(false).msgType(XmlMsgType.EVENT)
                .event(WxMpEventConstants.CustomerService.KF_CLOSE_SESSION)
                .handler(kfSessionHandler)
                .end();
        newRouter.rule().async(false).msgType(XmlMsgType.EVENT)
                .event(WxMpEventConstants.CustomerService.KF_SWITCH_SESSION)
                .handler(kfSessionHandler).end();

        // 门店审核事件
        newRouter.rule().async(false).msgType(XmlMsgType.EVENT)
                .event(WxMpEventConstants.POI_CHECK_NOTIFY)
                .handler(storeCheckNotifyHandler).end();

        // 自定义菜单事件
        newRouter.rule().async(false).msgType(XmlMsgType.EVENT)
                .event(WxConsts.MenuButtonType.CLICK).handler(menuHandler).end();

        // 点击菜单连接事件
        newRouter.rule().async(false).msgType(XmlMsgType.EVENT)
                .event(WxConsts.MenuButtonType.VIEW).handler(menuHandler).end();

        // 扫码事件
        newRouter.rule().async(false).msgType(XmlMsgType.EVENT)
                .event(EventType.SCANCODE_WAITMSG).handler(menuHandler).end();

        // 关注事件
        newRouter.rule().async(false).msgType(XmlMsgType.EVENT)
                .event(EventType.SUBSCRIBE).handler(subscribeHandler)
                .end();

        // 取消关注事件
        newRouter.rule().async(false).msgType(XmlMsgType.EVENT)
                .event(EventType.UNSUBSCRIBE)
                .handler(unsubscribeHandler).end();

        // 上报地理位置事件
        newRouter.rule().async(false).msgType(XmlMsgType.EVENT)
                .event(EventType.LOCATION).handler(locationHandler)
                .end();


        // 默认
        newRouter.rule().async(false).handler(msgHandler).end();

        return newRouter;
    }

}
