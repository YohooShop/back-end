package com.yoooho.mall.mapper;

import com.yoooho.mall.model.PmsProductSeckill;
import com.yoooho.mall.model.PmsProductSeckillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsProductSeckillMapper {
    long countByExample(PmsProductSeckillExample example);

    int deleteByExample(PmsProductSeckillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProductSeckill record);

    int insertSelective(PmsProductSeckill record);

    List<PmsProductSeckill> selectByExampleWithBLOBs(PmsProductSeckillExample example);

    List<PmsProductSeckill> selectByExample(PmsProductSeckillExample example);

    PmsProductSeckill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsProductSeckill record, @Param("example") PmsProductSeckillExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsProductSeckill record, @Param("example") PmsProductSeckillExample example);

    int updateByExample(@Param("record") PmsProductSeckill record, @Param("example") PmsProductSeckillExample example);

    int updateByPrimaryKeySelective(PmsProductSeckill record);

    int updateByPrimaryKeyWithBLOBs(PmsProductSeckill record);

    int updateByPrimaryKey(PmsProductSeckill record);
}