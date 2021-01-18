package com.yoooho.mall.service.impl;

import com.yoooho.mall.mapper.UmsSenderAddressMapper;
import com.yoooho.mall.model.UmsSenderAddress;
import com.yoooho.mall.model.UmsSenderAddressExample;
import com.yoooho.mall.service.UmsSenderAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UmsSenderAddressServiceImpl implements UmsSenderAddressService {

    @Autowired
    UmsSenderAddressMapper senderAddressMapper;
    @Override
    public int add(UmsSenderAddress address) {
        if (address.getDefaultStatus() == 1){
           resetDefAddress();
        }
        return senderAddressMapper.insert(address);
    }

    void resetDefAddress(){
        UmsSenderAddressExample example = new UmsSenderAddressExample();
        example.createCriteria().andDefaultStatusEqualTo(1);
        List<UmsSenderAddress> list = senderAddressMapper.selectByExample(example);
        for (int i = 0; i <list.size() ; i++) {
            UmsSenderAddress senderAddress = list.get(i);
            senderAddress.setDefaultStatus(0);
            senderAddressMapper.updateByPrimaryKey(senderAddress);
        }
    }

    @Override
    public List addressList() {
        UmsSenderAddressExample example = new UmsSenderAddressExample();
        List list = senderAddressMapper.selectByExample(example);
        return list;
    }

    @Override
    public UmsSenderAddress addressDetail(Long addressId) {
        return  senderAddressMapper.selectByPrimaryKey(addressId);
    }

    @Override
    public int updateAddress(UmsSenderAddress address) {
        return senderAddressMapper.updateByPrimaryKey(address);
    }

    @Override
    public int delAddress(Long addressId) {
        return senderAddressMapper.deleteByPrimaryKey(addressId);
    }

    @Override
    public int defaultAddress(Long addressId, int state) {
        resetDefAddress();
        UmsSenderAddress senderAddress = senderAddressMapper.selectByPrimaryKey(addressId);
        senderAddress.setDefaultStatus(state);
        return senderAddressMapper.updateByPrimaryKey(senderAddress);
    }
}
