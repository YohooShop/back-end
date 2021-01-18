package com.yoooho.mall.service.impl;

import com.yoooho.mall.mapper.SmsShopConfigMapper;
import com.yoooho.mall.model.SmsShopConfig;
import com.yoooho.mall.model.SmsShopConfigExample;
import com.yoooho.mall.service.SmsShopConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsShopConfigServiceImpl implements SmsShopConfigService {
    @Autowired
    SmsShopConfigMapper shopConfigMapper;
    @Override
    public int save(SmsShopConfig smsShopConfig) {
        List<SmsShopConfig> shopConfigs = getList();
        if (shopConfigs.size() == 0) {
          return   shopConfigMapper.insertSelective(smsShopConfig);
        }else {
            smsShopConfig.setId(shopConfigs.get(0).getId());
           return shopConfigMapper.updateByPrimaryKeySelective(smsShopConfig);
        }
    }

    @Override
    public SmsShopConfig get() {
        List<SmsShopConfig> shopConfigs = getList();
        if (shopConfigs.size() == 0) {
            SmsShopConfig shopConfig = new SmsShopConfig();
            shopConfig.setStartUsing(false);
            return shopConfig;
        }else {
            return shopConfigs.get(0);
        }
    }

    @Override
    public List<SmsShopConfig> getList(){
        SmsShopConfigExample example = new SmsShopConfigExample();
       return shopConfigMapper.selectByExample(example);
    }
}
