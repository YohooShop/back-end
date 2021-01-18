package com.yoooho.mall.mapper;

import com.yoooho.mall.model.PmsStore;
import com.yoooho.mall.model.PmsStoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsStoreMapper {
    long countByExample(PmsStoreExample example);

    int deleteByExample(PmsStoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsStore record);

    int insertSelective(PmsStore record);

    List<PmsStore> selectByExample(PmsStoreExample example);

    PmsStore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsStore record, @Param("example") PmsStoreExample example);

    int updateByExample(@Param("record") PmsStore record, @Param("example") PmsStoreExample example);

    int updateByPrimaryKeySelective(PmsStore record);

    int updateByPrimaryKey(PmsStore record);
}