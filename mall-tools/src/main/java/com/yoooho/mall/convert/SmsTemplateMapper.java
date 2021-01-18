package com.yoooho.mall.convert;

import com.yoooho.mall.domian.SmsTemplate;
import com.yoooho.mall.service.dto.SmsTemplateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SmsTemplateMapper extends BaseMapper<SmsTemplateDTO, SmsTemplate> {
}
