package com.yoooho.mall.mapper;

import com.yoooho.mall.model.EmailConfig;
import com.yoooho.mall.model.EmailConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmailConfigMapper {
    long countByExample(EmailConfigExample example);

    int deleteByExample(EmailConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EmailConfig record);

    int insertSelective(EmailConfig record);

    List<EmailConfig> selectByExample(EmailConfigExample example);

    EmailConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EmailConfig record, @Param("example") EmailConfigExample example);

    int updateByExample(@Param("record") EmailConfig record, @Param("example") EmailConfigExample example);

    int updateByPrimaryKeySelective(EmailConfig record);

    int updateByPrimaryKey(EmailConfig record);
}