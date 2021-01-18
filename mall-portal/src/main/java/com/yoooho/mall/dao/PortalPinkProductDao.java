package com.yoooho.mall.dao;

import com.yoooho.mall.domain.OmsPinkDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PortalPinkProductDao {

    List<OmsPinkDetail> selectPinkingDetailByPinkId(@Param("id")Long id);

}
