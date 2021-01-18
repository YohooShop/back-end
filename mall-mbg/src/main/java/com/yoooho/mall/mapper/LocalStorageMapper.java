package com.yoooho.mall.mapper;

import com.yoooho.mall.model.LocalStorage;
import com.yoooho.mall.model.LocalStorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LocalStorageMapper {
    long countByExample(LocalStorageExample example);

    int deleteByExample(LocalStorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LocalStorage record);

    int insertSelective(LocalStorage record);

    List<LocalStorage> selectByExample(LocalStorageExample example);

    LocalStorage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LocalStorage record, @Param("example") LocalStorageExample example);

    int updateByExample(@Param("record") LocalStorage record, @Param("example") LocalStorageExample example);

    int updateByPrimaryKeySelective(LocalStorage record);

    int updateByPrimaryKey(LocalStorage record);
}