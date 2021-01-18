package com.yoooho.mall.mapper;

import com.yoooho.mall.model.WechatMenu;
import com.yoooho.mall.model.WechatMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatMenuMapper {
    long countByExample(WechatMenuExample example);

    int deleteByExample(WechatMenuExample example);

    int deleteByPrimaryKey(String name);

    int insert(WechatMenu record);

    int insertSelective(WechatMenu record);

    List<WechatMenu> selectByExampleWithBLOBs(WechatMenuExample example);

    List<WechatMenu> selectByExample(WechatMenuExample example);

    WechatMenu selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") WechatMenu record, @Param("example") WechatMenuExample example);

    int updateByExampleWithBLOBs(@Param("record") WechatMenu record, @Param("example") WechatMenuExample example);

    int updateByExample(@Param("record") WechatMenu record, @Param("example") WechatMenuExample example);

    int updateByPrimaryKeySelective(WechatMenu record);

    int updateByPrimaryKeyWithBLOBs(WechatMenu record);

    int updateByPrimaryKey(WechatMenu record);
}