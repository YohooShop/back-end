package com.yoooho.mall.mapper;

import com.yoooho.mall.model.UmsMer;
import com.yoooho.mall.model.UmsMerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMerMapper {
    long countByExample(UmsMerExample example);

    int deleteByExample(UmsMerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMer record);

    int insertSelective(UmsMer record);

    List<UmsMer> selectByExample(UmsMerExample example);

    UmsMer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMer record, @Param("example") UmsMerExample example);

    int updateByExample(@Param("record") UmsMer record, @Param("example") UmsMerExample example);

    int updateByPrimaryKeySelective(UmsMer record);

    int updateByPrimaryKey(UmsMer record);
}
