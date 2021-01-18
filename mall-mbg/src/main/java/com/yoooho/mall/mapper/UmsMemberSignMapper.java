package com.yoooho.mall.mapper;

import com.yoooho.mall.model.UmsMemberSign;
import com.yoooho.mall.model.UmsMemberSignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberSignMapper {
    long countByExample(UmsMemberSignExample example);

    int deleteByExample(UmsMemberSignExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberSign record);

    int insertSelective(UmsMemberSign record);

    List<UmsMemberSign> selectByExample(UmsMemberSignExample example);

    UmsMemberSign selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberSign record, @Param("example") UmsMemberSignExample example);

    int updateByExample(@Param("record") UmsMemberSign record, @Param("example") UmsMemberSignExample example);

    int updateByPrimaryKeySelective(UmsMemberSign record);

    int updateByPrimaryKey(UmsMemberSign record);
}
