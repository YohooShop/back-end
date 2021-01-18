package com.yoooho.mall.mapper;

import com.yoooho.mall.model.PmsStoreStaff;
import com.yoooho.mall.model.PmsStoreStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsStoreStaffMapper {
    long countByExample(PmsStoreStaffExample example);

    int deleteByExample(PmsStoreStaffExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsStoreStaff record);

    int insertSelective(PmsStoreStaff record);

    List<PmsStoreStaff> selectByExample(PmsStoreStaffExample example);

    PmsStoreStaff selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsStoreStaff record, @Param("example") PmsStoreStaffExample example);

    int updateByExample(@Param("record") PmsStoreStaff record, @Param("example") PmsStoreStaffExample example);

    int updateByPrimaryKeySelective(PmsStoreStaff record);

    int updateByPrimaryKey(PmsStoreStaff record);
}