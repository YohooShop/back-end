package com.yoooho.mall.mapper;

import com.yoooho.mall.model.AliyunSmsTemplate;
import com.yoooho.mall.model.AliyunSmsTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AliyunSmsTemplateMapper {
    long countByExample(AliyunSmsTemplateExample example);

    int deleteByExample(AliyunSmsTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AliyunSmsTemplate record);

    int insertSelective(AliyunSmsTemplate record);

    List<AliyunSmsTemplate> selectByExample(AliyunSmsTemplateExample example);

    AliyunSmsTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AliyunSmsTemplate record, @Param("example") AliyunSmsTemplateExample example);

    int updateByExample(@Param("record") AliyunSmsTemplate record, @Param("example") AliyunSmsTemplateExample example);

    int updateByPrimaryKeySelective(AliyunSmsTemplate record);

    int updateByPrimaryKey(AliyunSmsTemplate record);
}