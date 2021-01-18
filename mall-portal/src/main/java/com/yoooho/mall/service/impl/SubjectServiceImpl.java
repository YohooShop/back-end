package com.yoooho.mall.service.impl;

import com.yoooho.mall.dao.SubjectDao;
import com.yoooho.mall.mapper.CmsSubjectMapper;

import com.yoooho.mall.model.CmsSubject;
import com.yoooho.mall.model.PmsProduct;
import com.yoooho.mall.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    CmsSubjectMapper subjectMapper;
    @Autowired
    private SubjectDao subjectDao;
    @Override
    public Object getSubjectDetail(Long subjectId) {
       CmsSubject subject = subjectMapper.selectByPrimaryKey(subjectId);
        return subject;
    }

    @Override
    public Object getSubjectGoods(Long subjectId, Integer pageSize, Integer pageNum) {
        List<PmsProduct> pmsProducts = subjectDao.selectSubjectProduct(subjectId,pageSize,pageSize * (pageNum - 1));
        return pmsProducts;
    }
}
