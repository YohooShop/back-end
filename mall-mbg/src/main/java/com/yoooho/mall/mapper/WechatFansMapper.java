package com.yoooho.mall.mapper;

import com.yoooho.mall.model.WechatFans;
import com.yoooho.mall.model.WechatFansExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatFansMapper {
    long countByExample(WechatFansExample example);

    int deleteByExample(WechatFansExample example);

    int deleteByPrimaryKey(String openid);

    int insert(WechatFans record);

    int insertSelective(WechatFans record);

    List<WechatFans> selectByExampleWithBLOBs(WechatFansExample example);

    List<WechatFans> selectByExample(WechatFansExample example);

    WechatFans selectByPrimaryKey(String openid);

    int updateByExampleSelective(@Param("record") WechatFans record, @Param("example") WechatFansExample example);

    int updateByExampleWithBLOBs(@Param("record") WechatFans record, @Param("example") WechatFansExample example);

    int updateByExample(@Param("record") WechatFans record, @Param("example") WechatFansExample example);

    int updateByPrimaryKeySelective(WechatFans record);

    int updateByPrimaryKeyWithBLOBs(WechatFans record);

    int updateByPrimaryKey(WechatFans record);
}