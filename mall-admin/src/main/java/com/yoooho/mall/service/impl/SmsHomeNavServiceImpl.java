package com.yoooho.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.yoooho.mall.mapper.SmsHomeNavMapper;
import com.yoooho.mall.model.SmsHomeNav;
import com.yoooho.mall.model.SmsHomeNavExample;
import com.yoooho.mall.service.SmsHomeNavService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsHomeNavServiceImpl implements SmsHomeNavService {

    @Autowired
    SmsHomeNavMapper homeNavMapper;
    @Override
    public int create(SmsHomeNav nav) {
        return homeNavMapper.insertSelective(nav);
    }

    @Override
    public int delete(List<Long> ids) {
        SmsHomeNavExample example = new SmsHomeNavExample();
        example.createCriteria().andIdIn(ids);
        return homeNavMapper.deleteByExample(example);
    }

    @Override
    public int updateStatus(Long id, Integer status) {
        SmsHomeNav record = new SmsHomeNav();
        record.setId(id);
        record.setStatus(status);
        return homeNavMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public SmsHomeNav getItem(Long id) {
        return homeNavMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Long id, SmsHomeNav nav) {
        nav.setId(id);
        return homeNavMapper.updateByPrimaryKeySelective(nav);
    }

    @Override
    public List<SmsHomeNav> list(String name, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        SmsHomeNavExample example = new SmsHomeNavExample();
        SmsHomeNavExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        example.setOrderByClause("sort desc");
        return homeNavMapper.selectByExample(example);
    }
}
