package com.yoooho.mall.service;

import com.yoooho.mall.model.WechatFans;
import me.chanjar.weixin.common.error.WxErrorException;

import java.util.List;
import java.util.Map;

public interface WechatFansService {


    /**
     * 同步用户列表,公众号一次拉取调用最多拉取10000个关注者的OpenID，可以通过传入nextOpenid参数多次拉取
     */
    public void syncFans();

    /**
     * 通过传入的openid列表，同步用户列表
     * @param openids
     */
    public void syncFans(List<String> openids) throws WxErrorException;

    /**
     * 分页查询用户数据
     * @param params
     * @return
     */
    public List<WechatFans> queryPage(Map<String, Object> params);

    /**
     * 根据openid更新用户信息
     *
     * @param openid
     * @return
     */
    public WechatFans refreshUserInfo(String openid);

    /**
     * 异步批量更新用户信息
     * @param openidList
     */
    void refreshUserInfoAsync(String[] openidList);

    public WechatFans getById(String openId);

    public void removeByIds(List<String> ids);

    public List<WechatFans> listByIds(List<String> ids);

}
