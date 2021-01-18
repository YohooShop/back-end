package com.yoooho.mall.mapper;

import com.yoooho.mall.model.OmsOrderFace;
import com.yoooho.mall.model.OmsOrderFaceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsOrderFaceMapper {
    long countByExample(OmsOrderFaceExample example);

    int deleteByExample(OmsOrderFaceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OmsOrderFace record);

    int insertSelective(OmsOrderFace record);

    List<OmsOrderFace> selectByExample(OmsOrderFaceExample example);

    OmsOrderFace selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OmsOrderFace record, @Param("example") OmsOrderFaceExample example);

    int updateByExample(@Param("record") OmsOrderFace record, @Param("example") OmsOrderFaceExample example);

    int updateByPrimaryKeySelective(OmsOrderFace record);

    int updateByPrimaryKey(OmsOrderFace record);
}