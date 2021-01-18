package com.yoooho.mall.mapper;

import com.yoooho.mall.model.UmsMemberSignContinue;
import com.yoooho.mall.model.UmsMemberSignContinueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberSignContinueMapper {
    long countByExample(UmsMemberSignContinueExample example);

    int deleteByExample(UmsMemberSignContinueExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsMemberSignContinue record);

    int insertSelective(UmsMemberSignContinue record);

    List<UmsMemberSignContinue> selectByExample(UmsMemberSignContinueExample example);

    UmsMemberSignContinue selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsMemberSignContinue record, @Param("example") UmsMemberSignContinueExample example);

    int updateByExample(@Param("record") UmsMemberSignContinue record, @Param("example") UmsMemberSignContinueExample example);

    int updateByPrimaryKeySelective(UmsMemberSignContinue record);

    int updateByPrimaryKey(UmsMemberSignContinue record);
}
