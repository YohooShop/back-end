package com.yoooho.mall.service;


import com.yoooho.mall.model.WechatMenu;

public interface WechatMenuService {

    /**
     * 根据ID查询
     * @param key
     * @return
     */

    WechatMenu findById(String key);

    /**
     * 创建
     * @param resources
     * @return
     */
    WechatMenu create(WechatMenu resources);

    /**
     * 编辑
     * @param resources
     */

    void update(WechatMenu resources);

    boolean isExist(String key);
}
