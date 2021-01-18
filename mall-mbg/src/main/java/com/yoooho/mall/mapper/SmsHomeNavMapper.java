package com.yoooho.mall.mapper;

import com.yoooho.mall.model.SmsHomeNav;
import com.yoooho.mall.model.SmsHomeNavExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsHomeNavMapper {
    long countByExample(SmsHomeNavExample example);

    int deleteByExample(SmsHomeNavExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsHomeNav record);

    int insertSelective(SmsHomeNav record);

    List<SmsHomeNav> selectByExample(SmsHomeNavExample example);

    SmsHomeNav selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsHomeNav record, @Param("example") SmsHomeNavExample example);

    int updateByExample(@Param("record") SmsHomeNav record, @Param("example") SmsHomeNavExample example);

    int updateByPrimaryKeySelective(SmsHomeNav record);

    int updateByPrimaryKey(SmsHomeNav record);
}