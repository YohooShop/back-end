package com.yoooho.mall.service;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.dto.WechatArticleQueryCriteria;
import com.yoooho.mall.model.WechatArticle;
import com.yoooho.mall.model.WechatArticleOrigin;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ArticleService {
       /**
     * 查询数据分页
     * @param pageable
     * @return
     */
    //@Cacheable
    Map<String,Object> queryAll( Pageable pageable);

    /**
     * 查询数据分页
     * @param pageable
     * @return
     */
    //@Cacheable
    Map<String,Object> queryAll(WechatArticleQueryCriteria criteria, Pageable pageable);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    WechatArticle findById(Integer id);
    /**
     * 创建
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    WechatArticle create(WechatArticle resources) throws WxErrorException;

    /**
     * 编辑
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(WechatArticle resources) throws WxErrorException;

    /**
     * 删除
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer id);

    CommonResult uploadNews(WechatArticle wechatArticle) throws Exception;


    public WechatArticleOrigin getWechatArticleOrigin(String mediaId);


}
