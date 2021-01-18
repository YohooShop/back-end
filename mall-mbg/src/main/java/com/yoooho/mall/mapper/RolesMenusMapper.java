package com.yoooho.mall.mapper;

import com.yoooho.mall.model.RolesMenus;
import com.yoooho.mall.model.RolesMenusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesMenusMapper {
    long countByExample(RolesMenusExample example);

    int deleteByExample(RolesMenusExample example);

    int deleteByPrimaryKey(@Param("menuId") Long menuId, @Param("roleId") Long roleId);

    int insert(RolesMenus record);

    int insertSelective(RolesMenus record);

    List<RolesMenus> selectByExample(RolesMenusExample example);

    int updateByExampleSelective(@Param("record") RolesMenus record, @Param("example") RolesMenusExample example);

    int updateByExample(@Param("record") RolesMenus record, @Param("example") RolesMenusExample example);
}