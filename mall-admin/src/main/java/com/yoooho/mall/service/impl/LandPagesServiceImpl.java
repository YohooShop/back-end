package com.yoooho.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.yoooho.mall.mapper.LandPagesMapper;
import com.yoooho.mall.model.LandPages;
import com.yoooho.mall.model.LandPagesExample;
import com.yoooho.mall.service.LandPagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LandPagesServiceImpl implements LandPagesService {

    @Autowired
    LandPagesMapper landPagesMapper;
    @Override
    public int add(LandPages landPages) {
        LandPagesExample example = new LandPagesExample();
        example.createCriteria().andUrlKeyEqualTo(landPages.getUrlKey())
        .andDeleteStatusEqualTo(false);
        if ( landPagesMapper.selectByExample(example).size() == 0){
            landPages.setCreateTime(new Date());
            return landPagesMapper.insertSelective(landPages);
        }else {
            return 2;
        }
    }

    @Override
    public int update(LandPages landPages) {
        landPages.setUpdateTime(new Date());
        return  landPagesMapper.updateByPrimaryKeySelective(landPages);
    }

    @Override
    public List<LandPages> list( Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        LandPagesExample example = new LandPagesExample();
        example.createCriteria().andDeleteStatusEqualTo(false);
        List <LandPages> landPagesList = landPagesMapper.selectByExampleWithBLOBs(example);
        return  landPagesList;
    }

    @Override
    public List<LandPages> listAll() {
        LandPagesExample example = new LandPagesExample();
        example.createCriteria().andDeleteStatusEqualTo(false);
        List <LandPages> landPagesList = landPagesMapper.selectByExampleWithBLOBs(example);
        return  landPagesList;
    }

    @Override
    public LandPages info(Long id) {
        return landPagesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delete(Long id) {
        LandPages landPages =  landPagesMapper.selectByPrimaryKey(id);
        landPages.setDeleteStatus(true);
        return landPagesMapper.updateByPrimaryKeySelective(landPages);
    }

    @Override
    public int updateStatus(Long id, boolean showStatus) {
        LandPages landPages =  landPagesMapper.selectByPrimaryKey(id);
        landPages.setShowStatus(showStatus);
        return landPagesMapper.updateByPrimaryKeySelective(landPages);
    }


}
