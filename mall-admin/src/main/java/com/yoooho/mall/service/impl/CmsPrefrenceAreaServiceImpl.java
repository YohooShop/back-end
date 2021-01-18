package com.yoooho.mall.service.impl;

import com.yoooho.mall.mapper.CmsPrefrenceAreaMapper;
import com.yoooho.mall.model.CmsPrefrenceArea;
import com.yoooho.mall.model.CmsPrefrenceAreaExample;
import com.yoooho.mall.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选Service实现类
 * Created by yoooho on 2019/6/1.
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}
