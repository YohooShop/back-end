package com.yoooho.mall.mapper;

import com.yoooho.mall.model.RolesDepts;
import com.yoooho.mall.model.RolesDeptsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesDeptsMapper {
    long countByExample(RolesDeptsExample example);

    int deleteByExample(RolesDeptsExample example);

    int deleteByPrimaryKey(@Param("deptId") Long deptId, @Param("roleId") Long roleId);

    int insert(RolesDepts record);

    int insertSelective(RolesDepts record);

    List<RolesDepts> selectByExample(RolesDeptsExample example);

    int updateByExampleSelective(@Param("record") RolesDepts record, @Param("example") RolesDeptsExample example);

    int updateByExample(@Param("record") RolesDepts record, @Param("example") RolesDeptsExample example);
}