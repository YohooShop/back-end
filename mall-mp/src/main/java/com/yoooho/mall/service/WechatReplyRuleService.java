package com.yoooho.mall.service;


import com.yoooho.mall.domian.WechatReply;
import com.yoooho.mall.dto.WechatReplyDTO;
import com.yoooho.mall.dto.WechatReplyParams;
import com.yoooho.mall.dto.WechatReplyQueryCriteria;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
* @author hupeng
* @date 2019-10-10
*/
//@CacheConfig(cacheNames = "yxWechatReply")
public interface WechatReplyRuleService {

    /**
    * 查询数据分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable
    Map<String, Object> queryAll(WechatReplyQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria
    * @return
    */
    //@Cacheable
    List<WechatReplyDTO> queryAll(WechatReplyQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
   Object findById(Integer id);

    /**
     * 创建
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    WechatReplyDTO create(WechatReplyParams resources);

    /**
     * 编辑
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(WechatReplyParams resources);

    /**
     * 删除
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer id);

    WechatReply isExist(String key);


    /**
     * 获取当前时段内所有有效的回复规则
     *
     * @return
     */
    public List<com.yoooho.mall.model.WechatReply> getValidRules();

    /**
     * 筛选符合条件的回复规则
     *
     * @param exactMatch 是否精确匹配
     * @param keywords   关键词
     * @return 规则列表
     */
    List getMatchedRules(boolean exactMatch, String keywords);


    void delect(List<Long>ids) throws Exception;

}
