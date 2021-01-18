package com.yoooho.mall.service;

import com.yoooho.mall.model.SmsShopConfig;

import java.util.List;

public interface SmsShopConfigService {
    public int save(SmsShopConfig smsShopConfig);

    public SmsShopConfig get();

    public List<SmsShopConfig> getList();
}
