package com.yoooho.mall.mapper;

import com.yoooho.mall.model.KdnExpressCompany;
import com.yoooho.mall.model.KdnExpressCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KdnExpressCompanyMapper {
    long countByExample(KdnExpressCompanyExample example);

    int deleteByExample(KdnExpressCompanyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(KdnExpressCompany record);

    int insertSelective(KdnExpressCompany record);

    List<KdnExpressCompany> selectByExample(KdnExpressCompanyExample example);

    KdnExpressCompany selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") KdnExpressCompany record, @Param("example") KdnExpressCompanyExample example);

    int updateByExample(@Param("record") KdnExpressCompany record, @Param("example") KdnExpressCompanyExample example);

    int updateByPrimaryKeySelective(KdnExpressCompany record);

    int updateByPrimaryKey(KdnExpressCompany record);
}