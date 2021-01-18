package com.yoooho.mall.mapper;

import com.yoooho.mall.model.WechatTemplate;
import com.yoooho.mall.model.WechatTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatTemplateMapper {
    long countByExample(WechatTemplateExample example);

    int deleteByExample(WechatTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WechatTemplate record);

    int insertSelective(WechatTemplate record);

    List<WechatTemplate> selectByExampleWithBLOBs(WechatTemplateExample example);

    List<WechatTemplate> selectByExample(WechatTemplateExample example);

    WechatTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WechatTemplate record, @Param("example") WechatTemplateExample example);

    int updateByExampleWithBLOBs(@Param("record") WechatTemplate record, @Param("example") WechatTemplateExample example);

    int updateByExample(@Param("record") WechatTemplate record, @Param("example") WechatTemplateExample example);

    int updateByPrimaryKeySelective(WechatTemplate record);

    int updateByPrimaryKeyWithBLOBs(WechatTemplate record);

    int updateByPrimaryKey(WechatTemplate record);
}