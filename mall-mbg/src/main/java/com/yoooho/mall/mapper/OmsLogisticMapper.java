package com.yoooho.mall.mapper;

import com.yoooho.mall.model.OmsLogistic;
import com.yoooho.mall.model.OmsLogisticExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsLogisticMapper {
    long countByExample(OmsLogisticExample example);

    int deleteByExample(OmsLogisticExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OmsLogistic record);

    int insertSelective(OmsLogistic record);

    List<OmsLogistic> selectByExampleWithBLOBs(OmsLogisticExample example);

    List<OmsLogistic> selectByExample(OmsLogisticExample example);

    OmsLogistic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OmsLogistic record, @Param("example") OmsLogisticExample example);

    int updateByExampleWithBLOBs(@Param("record") OmsLogistic record, @Param("example") OmsLogisticExample example);

    int updateByExample(@Param("record") OmsLogistic record, @Param("example") OmsLogisticExample example);

    int updateByPrimaryKeySelective(OmsLogistic record);

    int updateByPrimaryKeyWithBLOBs(OmsLogistic record);

    int updateByPrimaryKey(OmsLogistic record);
}