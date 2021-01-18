package com.yoooho.mall.mapper;

import com.yoooho.mall.model.SmsShopConfig;
import com.yoooho.mall.model.SmsShopConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsShopConfigMapper {
    long countByExample(SmsShopConfigExample example);

    int deleteByExample(SmsShopConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsShopConfig record);

    int insertSelective(SmsShopConfig record);

    List<SmsShopConfig> selectByExample(SmsShopConfigExample example);

    SmsShopConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsShopConfig record, @Param("example") SmsShopConfigExample example);

    int updateByExample(@Param("record") SmsShopConfig record, @Param("example") SmsShopConfigExample example);

    int updateByPrimaryKeySelective(SmsShopConfig record);

    int updateByPrimaryKey(SmsShopConfig record);
}