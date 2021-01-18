package com.yoooho.mall.mapper;

import com.yoooho.mall.model.WxAppConfig;
import com.yoooho.mall.model.WxAppConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxAppConfigMapper {
    long countByExample(WxAppConfigExample example);

    int deleteByExample(WxAppConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxAppConfig record);

    int insertSelective(WxAppConfig record);

    List<WxAppConfig> selectByExample(WxAppConfigExample example);

    WxAppConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxAppConfig record, @Param("example") WxAppConfigExample example);

    int updateByExample(@Param("record") WxAppConfig record, @Param("example") WxAppConfigExample example);

    int updateByPrimaryKeySelective(WxAppConfig record);

    int updateByPrimaryKey(WxAppConfig record);
}