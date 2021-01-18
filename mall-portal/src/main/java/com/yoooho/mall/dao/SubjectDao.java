package com.yoooho.mall.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectDao {
    List selectSubjectProduct(@Param("subject_id")Long subject_id, @Param("size")int size, @Param("offSet") int offSet);
}
