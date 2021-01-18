package com.yoooho.mall.service;

import com.yoooho.mall.dto.StoreStaffQueryParam;
import com.yoooho.mall.model.PmsStoreStaff;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface StoreStaffService {

    /**
     * 查询数据分页
     * @param criteria 条件
     * @param pageable 分页参数
     * @return Map<String,Object>
     */
    Map<String,Object> queryAll(StoreStaffQueryParam criteria, Pageable pageable);

    /**
     * 查询所有数据不分页
     * @param criteria 条件参数
     * @return List<YxSystemStoreStaffDto>
     */
    List<PmsStoreStaff> queryAll(StoreStaffQueryParam criteria);

    /**
     * 根据ID查询
     * @param id ID
     * @return YxSystemStoreStaffDto
     */
    PmsStoreStaff findById(Long id);

    /**
     * 创建
     * @param resources /
     * @return YxSystemStoreStaffDto
     */
    PmsStoreStaff create(PmsStoreStaff resources);

    /**
     * 编辑
     * @param resources /
     */
    void update(PmsStoreStaff resources);

    /**
     * 多选删除
     * @param ids /
     */
    void deleteAll(Long[] ids);

    /**
     * 导出数据
     * @param all 待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<PmsStoreStaff> all, HttpServletResponse response) throws IOException;
}
