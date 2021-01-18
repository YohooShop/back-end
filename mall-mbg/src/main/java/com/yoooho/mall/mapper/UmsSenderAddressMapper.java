package com.yoooho.mall.mapper;

import com.yoooho.mall.model.UmsSenderAddress;
import com.yoooho.mall.model.UmsSenderAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsSenderAddressMapper {
    long countByExample(UmsSenderAddressExample example);

    int deleteByExample(UmsSenderAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsSenderAddress record);

    int insertSelective(UmsSenderAddress record);

    List<UmsSenderAddress> selectByExample(UmsSenderAddressExample example);

    UmsSenderAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsSenderAddress record, @Param("example") UmsSenderAddressExample example);

    int updateByExample(@Param("record") UmsSenderAddress record, @Param("example") UmsSenderAddressExample example);

    int updateByPrimaryKeySelective(UmsSenderAddress record);

    int updateByPrimaryKey(UmsSenderAddress record);
}