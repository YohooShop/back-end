package com.yoooho.mall.service.mapper;


import com.yoooho.mall.convert.BaseMapper;
import com.yoooho.mall.domian.WXArticle;
import com.yoooho.mall.dto.WechatArticleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleMapper extends BaseMapper<WechatArticleDTO, WXArticle> {

}
