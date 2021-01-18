package com.yoooho.mall.mapper;

import com.yoooho.mall.model.OmsOrderRefund;
import com.yoooho.mall.model.OmsOrderRefundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsOrderRefundMapper {
    long countByExample(OmsOrderRefundExample example);

    int deleteByExample(OmsOrderRefundExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderRefund record);

    int insertSelective(OmsOrderRefund record);

    List<OmsOrderRefund> selectByExample(OmsOrderRefundExample example);

    OmsOrderRefund selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsOrderRefund record, @Param("example") OmsOrderRefundExample example);

    int updateByExample(@Param("record") OmsOrderRefund record, @Param("example") OmsOrderRefundExample example);

    int updateByPrimaryKeySelective(OmsOrderRefund record);

    int updateByPrimaryKey(OmsOrderRefund record);
}