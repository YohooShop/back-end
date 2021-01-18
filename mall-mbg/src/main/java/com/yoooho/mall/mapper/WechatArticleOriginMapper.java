package com.yoooho.mall.mapper;

import com.yoooho.mall.model.WechatArticleOrigin;
import com.yoooho.mall.model.WechatArticleOriginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatArticleOriginMapper {
    long countByExample(WechatArticleOriginExample example);

    int deleteByExample(WechatArticleOriginExample example);

    int deleteByPrimaryKey(String mid);

    int insert(WechatArticleOrigin record);

    int insertSelective(WechatArticleOrigin record);

    List<WechatArticleOrigin> selectByExample(WechatArticleOriginExample example);

    WechatArticleOrigin selectByPrimaryKey(String mid);

    int updateByExampleSelective(@Param("record") WechatArticleOrigin record, @Param("example") WechatArticleOriginExample example);

    int updateByExample(@Param("record") WechatArticleOrigin record, @Param("example") WechatArticleOriginExample example);

    int updateByPrimaryKeySelective(WechatArticleOrigin record);

    int updateByPrimaryKey(WechatArticleOrigin record);
}