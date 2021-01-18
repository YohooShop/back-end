package com.yoooho.mall.mapper;

import com.yoooho.mall.model.AlipayConfig;
import com.yoooho.mall.model.AlipayConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlipayConfigMapper {
    long countByExample(AlipayConfigExample example);

    int deleteByExample(AlipayConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AlipayConfig record);

    int insertSelective(AlipayConfig record);

    List<AlipayConfig> selectByExampleWithBLOBs(AlipayConfigExample example);

    List<AlipayConfig> selectByExample(AlipayConfigExample example);

    AlipayConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AlipayConfig record, @Param("example") AlipayConfigExample example);

    int updateByExampleWithBLOBs(@Param("record") AlipayConfig record, @Param("example") AlipayConfigExample example);

    int updateByExample(@Param("record") AlipayConfig record, @Param("example") AlipayConfigExample example);

    int updateByPrimaryKeySelective(AlipayConfig record);

    int updateByPrimaryKeyWithBLOBs(AlipayConfig record);

    int updateByPrimaryKey(AlipayConfig record);
}