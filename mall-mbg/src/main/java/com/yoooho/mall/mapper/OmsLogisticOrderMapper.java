package com.yoooho.mall.mapper;

import com.yoooho.mall.model.OmsLogisticOrder;
import com.yoooho.mall.model.OmsLogisticOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsLogisticOrderMapper {
    long countByExample(OmsLogisticOrderExample example);

    int deleteByExample(OmsLogisticOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OmsLogisticOrder record);

    int insertSelective(OmsLogisticOrder record);

    List<OmsLogisticOrder> selectByExampleWithBLOBs(OmsLogisticOrderExample example);

    List<OmsLogisticOrder> selectByExample(OmsLogisticOrderExample example);

    OmsLogisticOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OmsLogisticOrder record, @Param("example") OmsLogisticOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") OmsLogisticOrder record, @Param("example") OmsLogisticOrderExample example);

    int updateByExample(@Param("record") OmsLogisticOrder record, @Param("example") OmsLogisticOrderExample example);

    int updateByPrimaryKeySelective(OmsLogisticOrder record);

    int updateByPrimaryKeyWithBLOBs(OmsLogisticOrder record);

    int updateByPrimaryKey(OmsLogisticOrder record);
}
