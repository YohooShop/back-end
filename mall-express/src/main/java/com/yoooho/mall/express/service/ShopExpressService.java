package com.yoooho.mall.express.service;

import com.yoooho.mall.express.domain.KDNExpressCompany;
import com.yoooho.mall.express.service.dto.KDNExpressCompanyDTO;
import com.yoooho.mall.express.service.dto.KDNExpressCompanyQueryCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ShopExpressService {
    /**
     * 查询数据分页
     * @param criteria
     * @param pageable
     * @return
     */
    //@Cacheable
    Map<String,Object> queryAll(KDNExpressCompanyQueryCriteria criteria, Pageable pageable);

    /**
     * 查询所有数据不分页
     * @param criteria
     * @return
     */
    //@Cacheable
    List<KDNExpressCompanyDTO> queryAll(KDNExpressCompanyQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    KDNExpressCompanyDTO findById(Integer id);

    /**
     * 创建
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    KDNExpressCompanyDTO create(KDNExpressCompany resources);

    /**
     * 编辑
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(KDNExpressCompany resources);

    /**
     * 删除
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer id);
}
