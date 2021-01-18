package com.yoooho.mall.repository;

import com.yoooho.mall.domian.SmsTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SmsTemplateRepository  extends JpaRepository<SmsTemplate, Long>, JpaSpecificationExecutor<SmsTemplate> {

    List<SmsTemplate> findByKeyAndStatus(Integer key, Integer status);
}
