package com.yoooho.mall.mapper;

import com.yoooho.mall.model.WechatMsg;
import com.yoooho.mall.model.WechatMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatMsgMapper {
    long countByExample(WechatMsgExample example);

    int deleteByExample(WechatMsgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WechatMsg record);

    int insertSelective(WechatMsg record);

    List<WechatMsg> selectByExampleWithBLOBs(WechatMsgExample example);

    List<WechatMsg> selectByExample(WechatMsgExample example);

    WechatMsg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WechatMsg record, @Param("example") WechatMsgExample example);

    int updateByExampleWithBLOBs(@Param("record") WechatMsg record, @Param("example") WechatMsgExample example);

    int updateByExample(@Param("record") WechatMsg record, @Param("example") WechatMsgExample example);

    int updateByPrimaryKeySelective(WechatMsg record);

    int updateByPrimaryKeyWithBLOBs(WechatMsg record);

    int updateByPrimaryKey(WechatMsg record);
}