package com.yoooho.mall.service.Impl;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.yoooho.mall.config.TaskExcutor;
import com.yoooho.mall.config.WxMpConfiguration;
import com.yoooho.mall.dao.WechatFansDao;
import com.yoooho.mall.mapper.WechatFansMapper;
import com.yoooho.mall.model.WechatFans;
import com.yoooho.mall.model.WxOfficialAccountConfig;
import com.yoooho.mall.service.SystemConfigService;
import com.yoooho.mall.service.WechatFansService;
import lombok.RequiredArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class WechatFansServiceImpl implements WechatFansService {

    private volatile static  boolean syncWxUserTaskRunning=false;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SystemConfigService systemConfigService;

    @Autowired
    WechatFansMapper wechatFansMapper;

    @Autowired
    WechatFansDao wechatFansDao;

    @Override

    /**
     * 同步用户列表,公众号一次拉取调用最多拉取10000个关注者的OpenID，可以通过传入nextOpenid参数多次拉取
     */
    public void syncFans() {
        if(syncWxUserTaskRunning)return;//同步较慢，防止个多线程重复执行同步任务
        syncWxUserTaskRunning=true;
        logger.info("同步公众号粉丝列表：任务开始");
        boolean hasMore=true;
        String nextOpenid=null;

        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        WxMpUserService wxMpUserService = wxService.getUserService();
        try {
            int page=1;
            while (hasMore){
                WxMpUserList wxMpUserList = wxMpUserService.userList(nextOpenid);//拉取openid列表，每次最多1万个
                logger.info("拉取openid列表：第{}页，数量：{}",page++,wxMpUserList.getCount());
                List<String> openids = wxMpUserList.getOpenids();
                this.syncFans(openids);
                nextOpenid=wxMpUserList.getNextOpenid();
                hasMore=!StringUtils.isEmpty(nextOpenid);
            }
        } catch (WxErrorException e) {
            logger.error("同步公众号粉丝出错:",e);
        }
        logger.info("同步公众号粉丝列表：任务已全部添加到线程池");
        syncWxUserTaskRunning=false;
    }

    /**
     * 通过传入的openid列表，同步用户列表
     * @param openids
     */
    @Override
    public void syncFans(List<String> openids) throws WxErrorException {
        if(openids.size()<1)return;
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        final String batch=openids.get(0).substring(20);//截取首个openid的一部分做批次号（打印日志时使用，无实际意义）
        WxMpUserService wxMpUserService = wxService.getUserService();
        int start=0,batchSize=openids.size(),end=Math.min(100,batchSize);
        logger.info("开始处理批次：{}，批次数量：{}",batch,batchSize);
        while (start<end && end<=batchSize){//分批处理,每次最多拉取100个用户信息
            final int finalStart = start,finalEnd = end;
            final List<String> subOpenids=openids.subList(finalStart,finalEnd);
            TaskExcutor.submit(()->{//使用线程池同步数据，否则大量粉丝数据需同步时会很慢
                logger.info("同步批次:【{}--{}-{}】，数量：{}",batch, finalStart, finalEnd,subOpenids.size());
                List<WxMpUser> wxMpUsers = null;//批量获取用户信息，每次最多100个
                try {
                    wxMpUsers = wxMpUserService.userInfoList(subOpenids);
                } catch (WxErrorException e) {
                    logger.error("同步出错，批次：【{}--{}-{}】，错误信息：{}",batch, finalStart, finalEnd,e);
                }
                if(wxMpUsers!=null && !wxMpUsers.isEmpty()){
                    for (int i = 0; i < wxMpUsers.size(); i++) {
                        WxMpUser mpUser = wxMpUsers.get(i);
                        WechatFans wechatFans = new WechatFans();
                        wechatFans.setOpenid(mpUser.getOpenId());
                        wechatFans.setNickname(mpUser.getNickname());
                        wechatFans.setSex(mpUser.getSex());
                        wechatFans.setCity(mpUser.getCity());
                        wechatFans.setProvince(mpUser.getProvince());
                        wechatFans.setHeadimgurl(mpUser.getHeadImgUrl());
                        wechatFans.setSubscribeTime(new Date(mpUser.getSubscribeTime()));
                       wechatFans.setSubscribe(mpUser.getSubscribe()? 1 : 0);
//                        wechatFans.setSubscribe(mpUser.getSubscribe());
                        wechatFans.setUnionid(mpUser.getUnionId());
                        wechatFans.setRemark(mpUser.getRemark());
                        wechatFans.setTagidList(JSON.toJSONString(mpUser.getTagIds()));
                        wechatFans.setSubscribeScene(mpUser.getSubscribeScene());
                        wechatFans.setQrSceneStr(mpUser.getQrSceneStr());
                        logger.error("插入开始");
                        if (wechatFansMapper.selectByPrimaryKey(mpUser.getOpenId())==null){
                            wechatFansMapper.insertSelective(wechatFans);
                        }else {
                            wechatFansMapper.updateByPrimaryKeySelective(wechatFans);
                        }
                        logger.error("插入结束");
                    }
                }
            });
            start=end;
            end=Math.min(end+100,openids.size());
        }
        logger.info("批次：{}处理完成",batch);
    }

    @Override
    public List<WechatFans> queryPage(Map<String, Object> params) {
        int pageNum = Integer.parseInt((String) params.get("page")) ;
        int pageSize = Integer.parseInt((String) params.get("limit"));
        PageHelper.startPage(pageNum, pageSize);
        List<WechatFans> wechatFansList = wechatFansDao.selectFans(params);
        return wechatFansList;
    }

    @Override
    public WechatFans getById(String openId) {
        return wechatFansMapper.selectByPrimaryKey(openId);
    }

    @Override
    public void removeByIds(List<String> ids) {
        for (int i = 0; i < ids.size(); i++) {
            String openId = ids.get(i);
            wechatFansMapper.deleteByPrimaryKey(openId);
        }
    }

    @Override
    public List<WechatFans> listByIds(List<String> ids) {
        List<WechatFans> list = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++) {
            list.add(wechatFansMapper.selectByPrimaryKey(ids.get(i)));
        }
        return list;
    }

    /**
     * 异步批量同步用户信息
     * @param openidList
     */
    @Override
    @Async
    public void refreshUserInfoAsync(String[] openidList) {
        logger.info("批量更新用户信息：任务开始");
        for(String openid:openidList){
            TaskExcutor.submit(()->this.refreshUserInfo(openid));
        }
        logger.info("批量更新用户信息：任务全部添加到线程池");
    }

    /**
     * 根据openid更新用户信息
     *
     * @param openid
     * @return
     */
    @Override
    public WechatFans refreshUserInfo(String openid) {
        try {
            // 获取微信用户基本信息
            logger.info("更新用户信息，openid={}",openid);
            WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
            WxMpService wxService = WxMpConfiguration.getWxMpService(config);
            WxMpUser mpUser = wxService.getUserService().userInfo(openid, null);
            if (mpUser == null) {
                logger.error("获取不到用户信息，无法更新,openid:{}",openid);
                return null;
            }
            WechatFans wechatFans = new WechatFans();
            wechatFans.setOpenid(mpUser.getOpenId());
            wechatFans.setNickname(mpUser.getNickname());
            wechatFans.setSex(mpUser.getSex());
            wechatFans.setCity(mpUser.getCity());
            wechatFans.setProvince(mpUser.getProvince());
            wechatFans.setHeadimgurl(mpUser.getHeadImgUrl());
            wechatFans.setSubscribeTime(new Date(mpUser.getSubscribeTime()));
           wechatFans.setSubscribe(mpUser.getSubscribe()? 1 : 0);
//            wechatFans.setSubscribe(mpUser.getSubscribe());
            wechatFans.setUnionid(mpUser.getUnionId());
            wechatFans.setRemark(mpUser.getRemark());
            wechatFans.setTagidList(JSON.toJSONString(mpUser.getTagIds()));
            wechatFans.setSubscribeScene(mpUser.getSubscribeScene());
            wechatFans.setQrSceneStr(mpUser.getQrSceneStr());
            if (wechatFansMapper.selectByPrimaryKey(mpUser.getOpenId())==null){
                wechatFansMapper.insertSelective(wechatFans);
            }else {
                wechatFansMapper.updateByPrimaryKeySelective(wechatFans);
            }
            return  wechatFans;
        } catch (Exception e) {
            logger.error("更新用户信息失败,openid:{}",openid);
        }
        return null;
    }
}
