package com.yoooho.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.yoooho.mall.common.CommonPage;
import com.yoooho.mall.mapper.PmsStoreMapper;
import com.yoooho.mall.model.PmsStore;
import com.yoooho.mall.model.PmsStoreExample;
import com.yoooho.mall.service.PmsStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PmsStoreServiceImpl implements PmsStoreService {
    @Autowired
    PmsStoreMapper pmsStoreMapper;
    @Override
    public CommonPage queryStoreList(Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        PmsStoreExample example = new PmsStoreExample();
        example.createCriteria().andIsDelEqualTo(false).andIsShowEqualTo(true);
        List<PmsStore> stores = pmsStoreMapper.selectByExample(example);
        CommonPage result = CommonPage.restPage(stores);
        return result;
    }

    @Override
    public List<PmsStore> queryStoreAll() {
        PmsStoreExample example = new PmsStoreExample();
        example.createCriteria().andIsDelEqualTo(false).andIsShowEqualTo(true);
        List<PmsStore> stores = pmsStoreMapper.selectByExample(example);
        return stores;
    }

    @Override
    public PmsStore queryStoreDetail(Long id) {
        return pmsStoreMapper.selectByPrimaryKey(id);
    }
}
