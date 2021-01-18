package com.yoooho.mall.service;

import com.yoooho.mall.model.UmsSenderAddress;

import java.util.List;

public interface UmsSenderAddressService {
    /**
     * 添加收货地址
     */
    int add(UmsSenderAddress address);

    List addressList();

    UmsSenderAddress addressDetail(Long addressId);

    int updateAddress(UmsSenderAddress address);

    int delAddress(Long addressId);

    int defaultAddress(Long addressId, int state);
}
