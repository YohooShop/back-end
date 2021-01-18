package com.yoooho.mall.mapper;

import com.yoooho.mall.model.UmsJob;
import com.yoooho.mall.model.UmsJobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsJobMapper {
    long countByExample(UmsJobExample example);

    int deleteByExample(UmsJobExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsJob record);

    int insertSelective(UmsJob record);

    List<UmsJob> selectByExample(UmsJobExample example);

    UmsJob selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsJob record, @Param("example") UmsJobExample example);

    int updateByExample(@Param("record") UmsJob record, @Param("example") UmsJobExample example);

    int updateByPrimaryKeySelective(UmsJob record);

    int updateByPrimaryKey(UmsJob record);
}