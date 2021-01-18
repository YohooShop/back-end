package com.yoooho.mall.service.mapper;


import com.yoooho.mall.convert.BaseMapper;
import com.yoooho.mall.domian.WechatReply;
import com.yoooho.mall.dto.WechatReplyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WechatReplyMapper extends BaseMapper<WechatReplyDTO, WechatReply> {
}
