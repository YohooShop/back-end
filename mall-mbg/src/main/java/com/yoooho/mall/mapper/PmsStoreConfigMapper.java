package com.yoooho.mall.mapper;

import com.yoooho.mall.model.PmsStoreConfig;
import com.yoooho.mall.model.PmsStoreConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsStoreConfigMapper {
    long countByExample(PmsStoreConfigExample example);

    int deleteByExample(PmsStoreConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsStoreConfig record);

    int insertSelective(PmsStoreConfig record);

    List<PmsStoreConfig> selectByExample(PmsStoreConfigExample example);

    PmsStoreConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsStoreConfig record, @Param("example") PmsStoreConfigExample example);

    int updateByExample(@Param("record") PmsStoreConfig record, @Param("example") PmsStoreConfigExample example);

    int updateByPrimaryKeySelective(PmsStoreConfig record);

    int updateByPrimaryKey(PmsStoreConfig record);
}