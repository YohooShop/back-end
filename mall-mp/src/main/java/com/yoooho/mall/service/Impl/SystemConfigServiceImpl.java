package com.yoooho.mall.service.Impl;

import com.yoooho.mall.mapper.WxAppConfigMapper;
import com.yoooho.mall.mapper.WxOfficialAccountConfigMapper;
import com.yoooho.mall.mapper.WxPayConfigMapper;
import com.yoooho.mall.model.WxAppConfig;
import com.yoooho.mall.model.WxOfficialAccountConfig;

import com.yoooho.mall.model.WxPayConfig;
import com.yoooho.mall.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SystemConfigServiceImpl implements SystemConfigService {
    @Autowired
    WxOfficialAccountConfigMapper officialAccountConfigMapper;

    @Autowired
    WxAppConfigMapper wxAppConfigMapper;

    @Autowired
    WxPayConfigMapper wxPayConfigMapper;

    @Override
    public WxOfficialAccountConfig queryWXOfficialAccountConfig() {
        WxOfficialAccountConfig officialAccountConfig = officialAccountConfigMapper.selectByPrimaryKey((long)1);
        if (officialAccountConfig == null){
            return new WxOfficialAccountConfig();
        }else {
            return officialAccountConfig;
        }
    }

    @Override
    public void updateWxOfficialAccountConfig(WxOfficialAccountConfig officialAccountConfig) {
        WxOfficialAccountConfig config = officialAccountConfigMapper.selectByPrimaryKey((long)1);
        if (config == null){
            officialAccountConfigMapper.insert(officialAccountConfig);
        }else {
            officialAccountConfig.setId((long) 1);
            officialAccountConfigMapper.updateByPrimaryKeySelective(officialAccountConfig);
        }
    }

    @Override
    public WxPayConfig queryWXPayConfig() {
        WxPayConfig wxPayConfig = wxPayConfigMapper.selectByPrimaryKey(1);
        if (wxPayConfig == null){
            return new WxPayConfig();
        }else {
            return wxPayConfig;
        }
    }

    @Override
    public void updateWxPayConfig(WxPayConfig payConfig) {
        WxPayConfig wxPayConfig = wxPayConfigMapper.selectByPrimaryKey(1);
        if (wxPayConfig == null){
            wxPayConfigMapper.insert(payConfig);
        }else {
            payConfig.setId(1);
            wxPayConfigMapper.updateByPrimaryKeySelective(payConfig);
        }
    }

    @Override
    public WxAppConfig queryWXAPPConfig() {
        WxAppConfig wxAppConfig = wxAppConfigMapper.selectByPrimaryKey(1);
        if (wxAppConfig== null){
            return new WxAppConfig();
        }else {
            return wxAppConfig;
        }
    }

    @Override
    public void updateWxAppConfig(WxAppConfig config) {
        WxAppConfig wxAppConfig = wxAppConfigMapper.selectByPrimaryKey(1);
        if (wxAppConfig== null){
            wxAppConfigMapper.insert(config);
        }else {
            config.setId(1);
            wxAppConfigMapper.updateByPrimaryKeySelective(config);
        }
    }
}
