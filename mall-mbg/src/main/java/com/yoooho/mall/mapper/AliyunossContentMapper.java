package com.yoooho.mall.mapper;

import com.yoooho.mall.model.AliyunossContent;
import com.yoooho.mall.model.AliyunossContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AliyunossContentMapper {
    long countByExample(AliyunossContentExample example);

    int deleteByExample(AliyunossContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AliyunossContent record);

    int insertSelective(AliyunossContent record);

    List<AliyunossContent> selectByExample(AliyunossContentExample example);

    AliyunossContent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AliyunossContent record, @Param("example") AliyunossContentExample example);

    int updateByExample(@Param("record") AliyunossContent record, @Param("example") AliyunossContentExample example);

    int updateByPrimaryKeySelective(AliyunossContent record);

    int updateByPrimaryKey(AliyunossContent record);
}