package com.yoooho.mall.service;

import com.yoooho.mall.domian.SmsTemplate;
import com.yoooho.mall.service.dto.SMSQueryCriteria;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface SMSService {
    public Map queryAll(SMSQueryCriteria criteria, Pageable pageable);

    public int add(SmsTemplate smsTemplate);

    public void update(SmsTemplate resources);

    public void delete( Long id);

    public void sendSMS(Long id, String content,  String phoneNumbers);
    public SmsTemplate queryByKey(Integer key);
    public boolean sendSMS(SmsTemplate template, String content,  String phoneNumbers);
}
