package com.yoooho.mall.service.Impl;

import com.yoooho.mall.mapper.WechatMenuMapper;
import com.yoooho.mall.model.WechatMenu;

import com.yoooho.mall.service.WechatMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WechatMenuServiceImpl implements WechatMenuService {
    @Autowired
    private WechatMenuMapper wechatMenuMapper;
    @Override
    public WechatMenu findById(String key) {
        return wechatMenuMapper.selectByPrimaryKey(key);
    }

    @Override
    public WechatMenu create(WechatMenu resources) {
        wechatMenuMapper.insert(resources);
        return resources;
    }

    @Override
    public void update(WechatMenu resources) {
        wechatMenuMapper.updateByPrimaryKeySelective(resources);
    }

    @Override
    public boolean isExist(String key) {
        if (findById(key) == null) {
            return false;
        }
        return true;
    }
}
