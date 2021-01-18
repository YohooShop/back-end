package com.yoooho.mall.mapper;

import com.yoooho.mall.model.MaterialGroup;
import com.yoooho.mall.model.MaterialGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialGroupMapper {
    long countByExample(MaterialGroupExample example);

    int deleteByExample(MaterialGroupExample example);

    int deleteByPrimaryKey(String id);

    int insert(MaterialGroup record);

    int insertSelective(MaterialGroup record);

    List<MaterialGroup> selectByExample(MaterialGroupExample example);

    MaterialGroup selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MaterialGroup record, @Param("example") MaterialGroupExample example);

    int updateByExample(@Param("record") MaterialGroup record, @Param("example") MaterialGroupExample example);

    int updateByPrimaryKeySelective(MaterialGroup record);

    int updateByPrimaryKey(MaterialGroup record);
}