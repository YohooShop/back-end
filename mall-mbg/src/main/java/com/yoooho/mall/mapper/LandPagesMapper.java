package com.yoooho.mall.mapper;

import com.yoooho.mall.model.LandPages;
import com.yoooho.mall.model.LandPagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LandPagesMapper {
    long countByExample(LandPagesExample example);

    int deleteByExample(LandPagesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LandPages record);

    int insertSelective(LandPages record);

    List<LandPages> selectByExampleWithBLOBs(LandPagesExample example);

    List<LandPages> selectByExample(LandPagesExample example);

    LandPages selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LandPages record, @Param("example") LandPagesExample example);

    int updateByExampleWithBLOBs(@Param("record") LandPages record, @Param("example") LandPagesExample example);

    int updateByExample(@Param("record") LandPages record, @Param("example") LandPagesExample example);

    int updateByPrimaryKeySelective(LandPages record);

    int updateByPrimaryKeyWithBLOBs(LandPages record);

    int updateByPrimaryKey(LandPages record);
}