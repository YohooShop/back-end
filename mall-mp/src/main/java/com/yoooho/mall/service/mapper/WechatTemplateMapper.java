package com.yoooho.mall.service.mapper;

import com.yoooho.mall.convert.BaseMapper;
import com.yoooho.mall.domian.WechatTemplate;
import com.yoooho.mall.dto.WechatTemplateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WechatTemplateMapper extends BaseMapper<WechatTemplateDTO, WechatTemplate> {
}
