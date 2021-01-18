package com.yoooho.mall.service;

import com.yoooho.mall.domian.MaterialGroup;
import com.yoooho.mall.dto.MaterialGroupDto;
import com.yoooho.mall.dto.MaterialGroupQueryCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface MaterialGroupService {


    /**
     * 查询数据分页
     * @param criteria 条件
     * @param pageable 分页参数
     * @return Map<String,Object>
     */
    Map<String,Object> queryAll(MaterialGroupQueryCriteria criteria, Pageable pageable);

    /**
     * 查询所有数据不分页
     * @param criteria 条件参数
     * @return List<YxMaterialGroupDto>
     */
    List<MaterialGroupDto> queryAll(MaterialGroupQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return YxMaterialGroupDto
     */
    MaterialGroupDto findById(String id);

    /**
     * 创建
     * @param resources /
     * @return YxMaterialGroupDto
     */
    MaterialGroupDto create(MaterialGroup resources);

    /**
     * 编辑
     * @param resources /
     */
    void update(MaterialGroup resources);

    /**
     * 多选删除
     * @param ids /
     */
    void deleteAll(String[] ids);

    void deleteById(String id);

}
