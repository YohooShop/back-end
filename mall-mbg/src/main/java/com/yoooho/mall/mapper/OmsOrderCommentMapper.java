package com.yoooho.mall.mapper;

import com.yoooho.mall.model.OmsOrderComment;
import com.yoooho.mall.model.OmsOrderCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsOrderCommentMapper {
    long countByExample(OmsOrderCommentExample example);

    int deleteByExample(OmsOrderCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsOrderComment record);

    int insertSelective(OmsOrderComment record);

    List<OmsOrderComment> selectByExampleWithBLOBs(OmsOrderCommentExample example);

    List<OmsOrderComment> selectByExample(OmsOrderCommentExample example);

    OmsOrderComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsOrderComment record, @Param("example") OmsOrderCommentExample example);

    int updateByExampleWithBLOBs(@Param("record") OmsOrderComment record, @Param("example") OmsOrderCommentExample example);

    int updateByExample(@Param("record") OmsOrderComment record, @Param("example") OmsOrderCommentExample example);

    int updateByPrimaryKeySelective(OmsOrderComment record);

    int updateByPrimaryKeyWithBLOBs(OmsOrderComment record);

    int updateByPrimaryKey(OmsOrderComment record);
}