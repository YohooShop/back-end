package com.yoooho.mall.express.service.mapper;


import com.yoooho.mall.express.domain.KDNExpressCompany;
import com.yoooho.mall.express.service.dto.KDNExpressCompanyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KDNExpressCompanyMapper extends EntityMapper<KDNExpressCompanyDTO, KDNExpressCompany> {

}
