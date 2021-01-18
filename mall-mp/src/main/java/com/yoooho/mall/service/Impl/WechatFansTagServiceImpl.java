package com.yoooho.mall.service.Impl;

import com.yoooho.mall.config.WxMpConfiguration;
import com.yoooho.mall.model.WxOfficialAccountConfig;
import com.yoooho.mall.service.SystemConfigService;
import com.yoooho.mall.service.WechatFansService;
import com.yoooho.mall.service.WechatFansTagService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.tag.WxUserTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@CacheConfig(cacheNames = {"wxUserTagsServiceCache"})
@Slf4j
@Service
public class WechatFansTagServiceImpl implements WechatFansTagService {

    @Autowired
    SystemConfigService systemConfigService;

    @Autowired
    WechatFansService wechatFansService;

    public static final String CACHE_KEY="'WX_USER_TAGS'";

    @Override
    @Cacheable(key = CACHE_KEY)
    public List<WxUserTag> getWxTags() throws WxErrorException {
        log.info("拉取公众号用户标签");
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        return wxService.getUserTagService().tagGet();
    }

    @Override
    @CacheEvict(key = CACHE_KEY)
    public void creatTag(String name) throws WxErrorException {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        wxService.getUserTagService().tagCreate(name);
    }

    @Override
    @CacheEvict(key = CACHE_KEY)
    public void updateTag(Long tagid, String name) throws WxErrorException {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        wxService.getUserTagService().tagUpdate(tagid,name);
    }

    @Override
    @CacheEvict(key = CACHE_KEY)
    public void deleteTag(Long tagid) throws WxErrorException {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        wxService.getUserTagService().tagDelete(tagid);
    }



    @Override
    public void batchTagging(Long tagid, String[] openidList) throws WxErrorException {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        wxService.getUserTagService().batchTagging(tagid,openidList);
        wechatFansService.refreshUserInfoAsync(openidList);//标签更新后更新对应用户信息
    }

    @Override
    public void batchUnTagging(Long tagid, String[] openidList) throws WxErrorException {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        wxService.getUserTagService().batchUntagging(tagid,openidList);
        wechatFansService.refreshUserInfoAsync(openidList);//标签更新后更新对应用户信息
    }

    @Override
    public void tagging(Long tagid, String openid) throws WxErrorException {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        wxService.getUserTagService().batchTagging(tagid,new String[]{openid});
        wechatFansService.refreshUserInfo(openid);
    }

    @Override
    public void untagging(Long tagid, String openid) throws WxErrorException {
        WxOfficialAccountConfig config = systemConfigService.queryWXOfficialAccountConfig();
        WxMpService wxService = WxMpConfiguration.getWxMpService(config);
        wxService.getUserTagService().batchUntagging(tagid,new String[]{openid});
        wechatFansService.refreshUserInfo(openid);
    }
}
