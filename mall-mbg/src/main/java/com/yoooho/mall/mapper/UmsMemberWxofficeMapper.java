package com.yoooho.mall.mapper;

import com.yoooho.mall.model.UmsMemberWxoffice;
import com.yoooho.mall.model.UmsMemberWxofficeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberWxofficeMapper {
    long countByExample(UmsMemberWxofficeExample example);

    int deleteByExample(UmsMemberWxofficeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberWxoffice record);

    int insertSelective(UmsMemberWxoffice record);

    List<UmsMemberWxoffice> selectByExample(UmsMemberWxofficeExample example);

    UmsMemberWxoffice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberWxoffice record, @Param("example") UmsMemberWxofficeExample example);

    int updateByExample(@Param("record") UmsMemberWxoffice record, @Param("example") UmsMemberWxofficeExample example);

    int updateByPrimaryKeySelective(UmsMemberWxoffice record);

    int updateByPrimaryKey(UmsMemberWxoffice record);
}