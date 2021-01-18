package com.yoooho.mall.service;

import com.yoooho.mall.model.CmsSubject;
import com.yoooho.mall.model.CmsSubjectCategory;

import java.util.List;

/**
 * 商品专题Service
 * Created by yoooho on 2019/6/1.
 */
public interface CmsSubjectService {
    /**
     * 查询所有专题
     */
    List<CmsSubject> listAll();

    /**
     * 分页查询专题
     */
    List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 专题分类
     */
    List<CmsSubjectCategory> subCateList();

    int addCate(CmsSubjectCategory subjectCategory);
    int updateCate(CmsSubjectCategory subjectCategory);
    CmsSubjectCategory getCateDetail(Long id);

    CmsSubject getSubjectDetail(Long id);
    int addSubject(CmsSubject subject);
    int updateSubject(CmsSubject subject);

    int showStatus(List<Long> ids, Integer showStatus);

    int showSubjectCateStatus(List<Long> ids, Integer showStatus);
    int updateSubjectCateSort(Long id, Integer sort);
}
