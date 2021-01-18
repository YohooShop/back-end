package com.yoooho.mall.mapper;

import com.yoooho.mall.model.UmsMemberBindwx;
import com.yoooho.mall.model.UmsMemberBindwxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsMemberBindwxMapper {
    long countByExample(UmsMemberBindwxExample example);

    int deleteByExample(UmsMemberBindwxExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UmsMemberBindwx record);

    int insertSelective(UmsMemberBindwx record);

    List<UmsMemberBindwx> selectByExample(UmsMemberBindwxExample example);

    UmsMemberBindwx selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UmsMemberBindwx record, @Param("example") UmsMemberBindwxExample example);

    int updateByExample(@Param("record") UmsMemberBindwx record, @Param("example") UmsMemberBindwxExample example);

    int updateByPrimaryKeySelective(UmsMemberBindwx record);

    int updateByPrimaryKey(UmsMemberBindwx record);
}
