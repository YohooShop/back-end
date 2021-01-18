package com.yoooho.mall.repository;

import com.yoooho.mall.domian.WechatTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WechatTemplateRepository extends JpaRepository<WechatTemplate, Integer>, JpaSpecificationExecutor {
    WechatTemplate findByTempkey(String key);
}
