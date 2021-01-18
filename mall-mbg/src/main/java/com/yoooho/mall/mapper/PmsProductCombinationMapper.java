package com.yoooho.mall.mapper;

import com.yoooho.mall.model.PmsProductCombination;
import com.yoooho.mall.model.PmsProductCombinationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductCombinationMapper {
    long countByExample(PmsProductCombinationExample example);

    int deleteByExample(PmsProductCombinationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductCombination record);

    int insertSelective(PmsProductCombination record);

    List<PmsProductCombination> selectByExampleWithBLOBs(PmsProductCombinationExample example);

    List<PmsProductCombination> selectByExample(PmsProductCombinationExample example);

    PmsProductCombination selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProductCombination record, @Param("example") PmsProductCombinationExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsProductCombination record, @Param("example") PmsProductCombinationExample example);

    int updateByExample(@Param("record") PmsProductCombination record, @Param("example") PmsProductCombinationExample example);

    int updateByPrimaryKeySelective(PmsProductCombination record);

    int updateByPrimaryKeyWithBLOBs(PmsProductCombination record);

    int updateByPrimaryKey(PmsProductCombination record);
}