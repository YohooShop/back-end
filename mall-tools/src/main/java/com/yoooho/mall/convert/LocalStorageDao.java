package com.yoooho.mall.convert;

import com.yoooho.mall.domian.LocalStorage;
import com.yoooho.mall.service.dto.LocalStorageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocalStorageDao extends BaseMapper<LocalStorageDTO, LocalStorage> {

}
