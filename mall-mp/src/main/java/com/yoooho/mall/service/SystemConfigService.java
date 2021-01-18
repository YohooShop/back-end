package com.yoooho.mall.service;

import com.yoooho.mall.model.WxAppConfig;
import com.yoooho.mall.model.WxOfficialAccountConfig;
import com.yoooho.mall.model.WxPayConfig;

public interface SystemConfigService {

    WxOfficialAccountConfig queryWXOfficialAccountConfig();

    void updateWxOfficialAccountConfig (WxOfficialAccountConfig officialAccountConfig);
    WxPayConfig queryWXPayConfig();
    void updateWxPayConfig(WxPayConfig payConfig);

    WxAppConfig queryWXAPPConfig();
    void updateWxAppConfig(WxAppConfig config);

}
