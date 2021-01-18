package com.yoooho.mall.mapper;

import com.yoooho.mall.model.OmsPinkBuyer;
import com.yoooho.mall.model.OmsPinkBuyerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsPinkBuyerMapper {
    long countByExample(OmsPinkBuyerExample example);

    int deleteByExample(OmsPinkBuyerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsPinkBuyer record);

    int insertSelective(OmsPinkBuyer record);

    List<OmsPinkBuyer> selectByExample(OmsPinkBuyerExample example);

    OmsPinkBuyer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsPinkBuyer record, @Param("example") OmsPinkBuyerExample example);

    int updateByExample(@Param("record") OmsPinkBuyer record, @Param("example") OmsPinkBuyerExample example);

    int updateByPrimaryKeySelective(OmsPinkBuyer record);

    int updateByPrimaryKey(OmsPinkBuyer record);
}