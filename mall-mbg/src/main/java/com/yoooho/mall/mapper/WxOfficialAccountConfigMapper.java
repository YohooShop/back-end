package com.yoooho.mall.mapper;

import com.yoooho.mall.model.WxOfficialAccountConfig;
import com.yoooho.mall.model.WxOfficialAccountConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxOfficialAccountConfigMapper {
    long countByExample(WxOfficialAccountConfigExample example);

    int deleteByExample(WxOfficialAccountConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WxOfficialAccountConfig record);

    int insertSelective(WxOfficialAccountConfig record);

    List<WxOfficialAccountConfig> selectByExampleWithBLOBs(WxOfficialAccountConfigExample example);

    List<WxOfficialAccountConfig> selectByExample(WxOfficialAccountConfigExample example);

    WxOfficialAccountConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WxOfficialAccountConfig record, @Param("example") WxOfficialAccountConfigExample example);

    int updateByExampleWithBLOBs(@Param("record") WxOfficialAccountConfig record, @Param("example") WxOfficialAccountConfigExample example);

    int updateByExample(@Param("record") WxOfficialAccountConfig record, @Param("example") WxOfficialAccountConfigExample example);

    int updateByPrimaryKeySelective(WxOfficialAccountConfig record);

    int updateByPrimaryKeyWithBLOBs(WxOfficialAccountConfig record);

    int updateByPrimaryKey(WxOfficialAccountConfig record);
}