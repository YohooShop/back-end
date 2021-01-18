package com.yoooho.mall.service.impl;

import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.dto.UmsMemberQueryParam;
import com.yoooho.mall.mapper.UmsMemberMapper;
import com.yoooho.mall.model.UmsMember;
import com.yoooho.mall.model.UmsMemberExample;
import com.yoooho.mall.service.UmsMemberService;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    UmsMemberMapper memberMapper;
    @Override
    public Map<String, Object> queryAll(UmsMemberQueryParam criteria, Pageable pageable) {
        UmsMemberExample example = new UmsMemberExample();

        UmsMemberExample.Criteria  criteria1 = example.createCriteria();
        if ( StringUtil.isNotBlank(criteria.getNickname())) {
            criteria1.andNicknameLike(criteria.getNickname());
        }
        if (StringUtil.isNotBlank(criteria.getPhone())) {
            criteria1.andPhoneLike(criteria.getPhone());
        }
        List<UmsMember> members = memberMapper.selectByExample(example);
        CommonPage result = CommonPage.restPage(members);
        List list = new ArrayList();
        for (int i = 0; i < result.getList().size(); i++) {
            UmsMember member = (UmsMember) result.getList().get(i);
            Map map = new HashMap();
            map.put("uid",member.getId());
            map.put("nickname",member.getNickname());
            map.put("avatar",member.getIcon());
            map.put("phone",member.getPhone());
            list.add(map);
        }

        Map<String,Object> map = new LinkedHashMap<>(2);
        map.put("content",list);
        map.put("totalElements",result.getTotal());
        return map;
    }
}
