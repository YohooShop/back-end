package com.yoooho.mall.mapper;

import com.yoooho.mall.model.DictDetail;
import com.yoooho.mall.model.DictDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictDetailMapper {
    long countByExample(DictDetailExample example);

    int deleteByExample(DictDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DictDetail record);

    int insertSelective(DictDetail record);

    List<DictDetail> selectByExample(DictDetailExample example);

    DictDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DictDetail record, @Param("example") DictDetailExample example);

    int updateByExample(@Param("record") DictDetail record, @Param("example") DictDetailExample example);

    int updateByPrimaryKeySelective(DictDetail record);

    int updateByPrimaryKey(DictDetail record);
}