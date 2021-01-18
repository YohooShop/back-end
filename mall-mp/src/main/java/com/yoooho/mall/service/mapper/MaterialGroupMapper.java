package com.yoooho.mall.service.mapper;

import com.yoooho.mall.convert.BaseMapper;
import com.yoooho.mall.domian.MaterialGroup;
import com.yoooho.mall.dto.MaterialGroupDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MaterialGroupMapper extends BaseMapper<MaterialGroupDto, MaterialGroup> {
}
