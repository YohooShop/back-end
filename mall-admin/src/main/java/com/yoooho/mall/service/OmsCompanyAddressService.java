package com.yoooho.mall.service;

import com.yoooho.mall.model.OmsCompanyAddress;

import java.util.List;

/**
 * 收货地址管Service
 * Created by yoooho on 2019/10/18.
 */
public interface OmsCompanyAddressService {
    /**
     * 获取全部收货地址
     */
    List<OmsCompanyAddress> list();
}
