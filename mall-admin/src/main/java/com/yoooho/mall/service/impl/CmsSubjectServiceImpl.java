package com.yoooho.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.yoooho.mall.mapper.CmsSubjectCategoryMapper;
import com.yoooho.mall.mapper.CmsSubjectMapper;
import com.yoooho.mall.model.CmsSubject;
import com.yoooho.mall.model.CmsSubjectCategory;
import com.yoooho.mall.model.CmsSubjectCategoryExample;
import com.yoooho.mall.model.CmsSubjectExample;
import com.yoooho.mall.service.CmsSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * 商品专题Service实现类
 * Created by yoooho on 2019/6/1.
 */
@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {
    @Autowired
    private CmsSubjectMapper subjectMapper;

    @Autowired

    private CmsSubjectCategoryMapper subjectCategoryMapper;

    @Override
    public List<CmsSubject> listAll() {
        return subjectMapper.selectByExample(new CmsSubjectExample());
    }

    @Override
    public List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        CmsSubjectExample example = new CmsSubjectExample();
        CmsSubjectExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andTitleLike("%" + keyword + "%");
        }
        return subjectMapper.selectByExample(example);
    }

    @Override
    public List<CmsSubjectCategory> subCateList() {
        return subjectCategoryMapper.selectByExample(new CmsSubjectCategoryExample());
    }

    @Override
    public int addCate(CmsSubjectCategory subjectCategory) {

        return subjectCategoryMapper.insert(subjectCategory);
    }

    @Override
    public int updateCate(CmsSubjectCategory subjectCategory) {
        return subjectCategoryMapper.updateByPrimaryKeySelective(subjectCategory);
    }

    @Override
    public CmsSubjectCategory getCateDetail(Long id) {
        return subjectCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public CmsSubject getSubjectDetail(Long id) {
        return subjectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addSubject(CmsSubject subject) {
        subject.setCreateTime(new Date());
        return subjectMapper.insertSelective(subject);
    }

    @Override
    public int updateSubject(CmsSubject subject) {
        subject.setCreateTime(new Date());
        return subjectMapper.updateByPrimaryKeySelective(subject);
    }

    @Override
    public int showStatus(List<Long> ids, Integer showStatus) {
        CmsSubject subject = new CmsSubject();
        subject.setShowStatus(showStatus);
        CmsSubjectExample example = new CmsSubjectExample();
        example.createCriteria().andIdIn(ids);
        return subjectMapper.updateByExampleSelective(subject, example);
    }

    @Override
    public int showSubjectCateStatus(List<Long> ids, Integer showStatus) {
        CmsSubjectCategory subjectCategory = new CmsSubjectCategory();
        subjectCategory.setShowStatus(showStatus);
        CmsSubjectCategoryExample example = new CmsSubjectCategoryExample();
        example.createCriteria().andIdIn(ids);
        return subjectCategoryMapper.updateByExampleSelective(subjectCategory, example);
    }

    @Override
    public int updateSubjectCateSort(Long id, Integer sort) {
        CmsSubjectCategory subjectCategory = new CmsSubjectCategory();
        subjectCategory.setSort(sort);
        subjectCategory.setId(id);
        return subjectCategoryMapper.updateByPrimaryKeySelective(subjectCategory);
    }
}
