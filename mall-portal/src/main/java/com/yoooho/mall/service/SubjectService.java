package com.yoooho.mall.service;

public interface SubjectService {
    //专题详情
    Object getSubjectDetail(Long subjectId);
    //专题下面的商品
    Object getSubjectGoods( Long subjectId, Integer pageSize, Integer pageNum);
}
