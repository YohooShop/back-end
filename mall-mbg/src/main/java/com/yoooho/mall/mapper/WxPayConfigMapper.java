package com.yoooho.mall.mapper;

import com.yoooho.mall.model.WxPayConfig;
import com.yoooho.mall.model.WxPayConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxPayConfigMapper {
    long countByExample(WxPayConfigExample example);

    int deleteByExample(WxPayConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WxPayConfig record);

    int insertSelective(WxPayConfig record);

    List<WxPayConfig> selectByExample(WxPayConfigExample example);

    WxPayConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WxPayConfig record, @Param("example") WxPayConfigExample example);

    int updateByExample(@Param("record") WxPayConfig record, @Param("example") WxPayConfigExample example);

    int updateByPrimaryKeySelective(WxPayConfig record);

    int updateByPrimaryKey(WxPayConfig record);
}