package com.yoooho.mall.mapper;

import com.yoooho.mall.model.AliyunSms;
import com.yoooho.mall.model.AliyunSmsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AliyunSmsMapper {
    long countByExample(AliyunSmsExample example);

    int deleteByExample(AliyunSmsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AliyunSms record);

    int insertSelective(AliyunSms record);

    List<AliyunSms> selectByExample(AliyunSmsExample example);

    AliyunSms selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AliyunSms record, @Param("example") AliyunSmsExample example);

    int updateByExample(@Param("record") AliyunSms record, @Param("example") AliyunSmsExample example);

    int updateByPrimaryKeySelective(AliyunSms record);

    int updateByPrimaryKey(AliyunSms record);
}