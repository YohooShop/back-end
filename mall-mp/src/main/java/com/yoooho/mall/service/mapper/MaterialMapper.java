package com.yoooho.mall.service.mapper;


import com.yoooho.mall.convert.BaseMapper;
import com.yoooho.mall.domian.Material;
import com.yoooho.mall.dto.MaterialDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author hupeng
* @date 2020-01-09
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MaterialMapper extends BaseMapper<MaterialDto, Material> {

}
