package com.yoooho.mall.mapper;

import com.yoooho.mall.model.WechatArticle;
import com.yoooho.mall.model.WechatArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatArticleMapper {
    long countByExample(WechatArticleExample example);

    int deleteByExample(WechatArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WechatArticle record);

    int insertSelective(WechatArticle record);

    List<WechatArticle> selectByExampleWithBLOBs(WechatArticleExample example);

    List<WechatArticle> selectByExample(WechatArticleExample example);

    WechatArticle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WechatArticle record, @Param("example") WechatArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") WechatArticle record, @Param("example") WechatArticleExample example);

    int updateByExample(@Param("record") WechatArticle record, @Param("example") WechatArticleExample example);

    int updateByPrimaryKeySelective(WechatArticle record);

    int updateByPrimaryKeyWithBLOBs(WechatArticle record);

    int updateByPrimaryKey(WechatArticle record);
}