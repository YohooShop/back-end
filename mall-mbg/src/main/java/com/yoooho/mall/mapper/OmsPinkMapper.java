package com.yoooho.mall.mapper;

import com.yoooho.mall.model.OmsPink;
import com.yoooho.mall.model.OmsPinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsPinkMapper {
    long countByExample(OmsPinkExample example);

    int deleteByExample(OmsPinkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsPink record);

    int insertSelective(OmsPink record);

    List<OmsPink> selectByExample(OmsPinkExample example);

    OmsPink selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsPink record, @Param("example") OmsPinkExample example);

    int updateByExample(@Param("record") OmsPink record, @Param("example") OmsPinkExample example);

    int updateByPrimaryKeySelective(OmsPink record);

    int updateByPrimaryKey(OmsPink record);
}