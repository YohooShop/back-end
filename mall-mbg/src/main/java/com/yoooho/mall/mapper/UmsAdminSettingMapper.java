package com.yoooho.mall.mapper;

import com.yoooho.mall.model.UmsAdminSetting;
import com.yoooho.mall.model.UmsAdminSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsAdminSettingMapper {
    long countByExample(UmsAdminSettingExample example);

    int deleteByExample(UmsAdminSettingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsAdminSetting record);

    int insertSelective(UmsAdminSetting record);

    List<UmsAdminSetting> selectByExample(UmsAdminSettingExample example);

    UmsAdminSetting selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsAdminSetting record, @Param("example") UmsAdminSettingExample example);

    int updateByExample(@Param("record") UmsAdminSetting record, @Param("example") UmsAdminSettingExample example);

    int updateByPrimaryKeySelective(UmsAdminSetting record);

    int updateByPrimaryKey(UmsAdminSetting record);
}