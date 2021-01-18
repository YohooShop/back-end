package com.yoooho.mall.mapper;

import com.yoooho.mall.model.AliyunossConfig;
import com.yoooho.mall.model.AliyunossConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AliyunossConfigMapper {
    long countByExample(AliyunossConfigExample example);

    int deleteByExample(AliyunossConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AliyunossConfig record);

    int insertSelective(AliyunossConfig record);

    List<AliyunossConfig> selectByExample(AliyunossConfigExample example);

    AliyunossConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AliyunossConfig record, @Param("example") AliyunossConfigExample example);

    int updateByExample(@Param("record") AliyunossConfig record, @Param("example") AliyunossConfigExample example);

    int updateByPrimaryKeySelective(AliyunossConfig record);

    int updateByPrimaryKey(AliyunossConfig record);
}