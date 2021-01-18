package com.yoooho.mall.service.impl;


import com.yoooho.mall.mapper.UmsMemberReceiveAddressMapper;
import com.yoooho.mall.model.UmsMember;
import com.yoooho.mall.model.UmsMemberReceiveAddress;
import com.yoooho.mall.model.UmsMemberReceiveAddressExample;
import com.yoooho.mall.service.UmsMemberService;
import com.yoooho.mall.service.UmsMemberReceiveAddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * 用户地址管理Service实现类
 * Created by yoooho on 2019/8/28.
 */
@Service
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {
    @Autowired
    private UmsMemberService memberService;
    @Autowired
    private UmsMemberReceiveAddressMapper addressMapper;
    @Override
    public int add(UmsMemberReceiveAddress address) {
        UmsMember currentMember = memberService.getCurrentMember();
        if (address.getDefaultStatus() == 1){
            UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
            example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andDefaultStatusEqualTo(1);;
            List<UmsMemberReceiveAddress> list = addressMapper.selectByExample(example);
            for (int i = 0; i <list.size() ; i++) {
                UmsMemberReceiveAddress memberReceiveAddress = list.get(i);
                memberReceiveAddress.setDefaultStatus(0);
                addressMapper.updateByPrimaryKey(memberReceiveAddress);
            }
        }

        address.setMemberId(currentMember.getId());
        return addressMapper.insert(address);
    }

    @Override
    public int delete(Long id) {
        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(id);
        return addressMapper.deleteByExample(example);
    }

    @Override
    public int update(Long id, UmsMemberReceiveAddress address) {
        address.setId(null);

        if (address.getDefaultStatus() == 1){
            UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
            UmsMember currentMember = memberService.getCurrentMember();
            example.createCriteria().andMemberIdEqualTo(currentMember.getId());
            List<UmsMemberReceiveAddress> list = addressMapper.selectByExample(example);
            for (int i = 0; i <list.size() ; i++) {
                UmsMemberReceiveAddress memberReceiveAddress = list.get(i);
                if (memberReceiveAddress.getDefaultStatus() == 1){
                    memberReceiveAddress.setDefaultStatus(0);
                    addressMapper.updateByPrimaryKey(memberReceiveAddress);
                }
            }
        }
        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId()).andIdEqualTo(id);
        return addressMapper.updateByExampleSelective(address,example);
    }

    @Override
    public List<UmsMemberReceiveAddress> list() {
        UmsMember currentMember = memberService.getCurrentMember();
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(currentMember.getId());
        example.setOrderByClause("default_status DESC");
        return addressMapper.selectByExample(example);
    }

    @Override
    public UmsMemberReceiveAddress getItem(Long id ,Long userId) {
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(userId).andIdEqualTo(id);
        List<UmsMemberReceiveAddress> addressList = addressMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(addressList)){
            return addressList.get(0);
        }
        return null;
    }

    @Override
    public UmsMemberReceiveAddress getDefaultAddress(Long id) {
        UmsMemberReceiveAddressExample example = new UmsMemberReceiveAddressExample();
        example.createCriteria().andMemberIdEqualTo(id).andDefaultStatusEqualTo(1);
        List<UmsMemberReceiveAddress> addressList = addressMapper.selectByExample(example);
        if (addressList.size() == 0){
            return null;
        }
        return addressList.get(0);
    }
}
