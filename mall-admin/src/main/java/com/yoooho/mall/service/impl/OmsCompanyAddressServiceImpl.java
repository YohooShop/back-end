package com.yoooho.mall.service.impl;

import com.yoooho.mall.mapper.OmsCompanyAddressMapper;
import com.yoooho.mall.model.OmsCompanyAddress;
import com.yoooho.mall.model.OmsCompanyAddressExample;
import com.yoooho.mall.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管理Service实现类
 * Created by yoooho on 2019/10/18.
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;
    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
