package com.yoooho.mall.service.Impl;

import com.yoooho.mall.common.annotation.QueryHelp;
import com.yoooho.mall.common.utils.PageUtil;
import com.yoooho.mall.common.utils.ValidationUtil;
import com.yoooho.mall.convert.SmsTemplateMapper;
import com.yoooho.mall.domian.SmsTemplate;
import com.yoooho.mall.repository.SmsTemplateRepository;
import com.yoooho.mall.service.SMSService;
import com.yoooho.mall.service.dto.SMSQueryCriteria;
import com.yoooho.mall.utils.AliyunSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SMSServiceImpl implements SMSService {

    @Autowired
    SmsTemplateRepository smsTemplateRepository;

    @Autowired
    SmsTemplateMapper smsTemplateMapper;
    @Override
    public Map queryAll(SMSQueryCriteria criteria, Pageable pageable) {
        Page<SmsTemplate> page =smsTemplateRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(smsTemplateMapper::toDto));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(SmsTemplate smsTemplate) {
        smsTemplate.setCreateTime(new Date());
        if (smsTemplateMapper.toDto(smsTemplateRepository.save(smsTemplate)) == null){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SmsTemplate resources) {
        Optional<SmsTemplate> optionalSmsTemplate = smsTemplateRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalSmsTemplate,"SmsTemplate","id",resources.getId());
        SmsTemplate smsTemplate = optionalSmsTemplate.get();
        smsTemplate.copy(resources);
        smsTemplateRepository.save(smsTemplate);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete( Long id) {
        smsTemplateRepository.deleteById(id);
    }

    @Override
    public void sendSMS(Long id, String content, String phoneNumbers) {
       Optional<SmsTemplate> smsTemplate = smsTemplateRepository.findById(id);
       ValidationUtil.isNull(smsTemplate,"SmsTemplate","id",id);
       if (smsTemplate.get().getKey() == 1) {
           content = "{ \"code\":"+content + "}";
       }
       AliyunSms.sendSms(phoneNumbers,smsTemplate.get(),content);
    }

    @Override
    public SmsTemplate queryByKey(Integer key) {
        List<SmsTemplate> list = smsTemplateRepository.findByKeyAndStatus(key,1);
        if (list.size() == 0) {
            return  null;
        }
        return list.get(0);
    }

    @Override
    public boolean sendSMS(SmsTemplate template, String content, String phoneNumbers) {
        return AliyunSms.sendSms(phoneNumbers,template,content);
    }
}
