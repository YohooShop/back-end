package com.yoooho.mall.repository;

import com.yoooho.mall.domian.WechatReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WechatReplyRepository  extends JpaRepository<WechatReply, Long>, JpaSpecificationExecutor {
    /**
     * findByKey
     * @param key
     * @return
     */
    WechatReply findByMatchValue(String key);
}
