package com.yoooho.mall.service;

import com.yoooho.mall.domian.Material;
import com.yoooho.mall.dto.MaterialDto;
import com.yoooho.mall.dto.MaterialQueryCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface MaterialService {
    /**
     * 查询数据分页
     * @param criteria 条件
     * @param pageable 分页参数
     * @return Map<String,Object>
     */
    Map<String,Object> queryAll(MaterialQueryCriteria criteria, Pageable pageable);

    /**
     * 查询所有数据不分页
     * @param criteria 条件参数
     * @return List<MaterialDto>
     */
    List<MaterialDto> queryAll(MaterialQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return MaterialDto
     */
    MaterialDto findById(String id);

    /**
     * 创建
     * @param resources /
     * @return MaterialDto
     */
    MaterialDto create(Material resources);

    /**
     * 编辑
     * @param resources /
     */
    void update(Material resources);

    /**
     * 多选删除
     * @param ids /
     */
    void deleteAll(String[] ids);

    void deleteById(String id);
}
