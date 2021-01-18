package com.yoooho.mall.mapper;

import com.yoooho.mall.model.WechatReply;
import com.yoooho.mall.model.WechatReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatReplyMapper {
    long countByExample(WechatReplyExample example);

    int deleteByExample(WechatReplyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WechatReply record);

    int insertSelective(WechatReply record);

    List<WechatReply> selectByExample(WechatReplyExample example);

    WechatReply selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WechatReply record, @Param("example") WechatReplyExample example);

    int updateByExample(@Param("record") WechatReply record, @Param("example") WechatReplyExample example);

    int updateByPrimaryKeySelective(WechatReply record);

    int updateByPrimaryKey(WechatReply record);
}