package com.yoooho.mall.service.Impl;

import com.yoooho.mall.common.annotation.QueryHelp;
import com.yoooho.mall.common.utils.PageUtil;
import com.yoooho.mall.common.utils.ValidationUtil;
import com.yoooho.mall.domian.WechatTemplate;
import com.yoooho.mall.dto.WechatTemplateDTO;
import com.yoooho.mall.dto.WechatTemplateQueryCriteria;
import com.yoooho.mall.repository.WechatTemplateRepository;
import com.yoooho.mall.service.WechatTemplateService;
import com.yoooho.mall.service.mapper.WechatTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class WechatTemplateServiceImpl implements WechatTemplateService {
    @Autowired
    private WechatTemplateRepository wechatTemplateRepository;

    @Autowired
    private WechatTemplateMapper wechatTemplateMapper;



    @Override
    public WechatTemplate findByTempkey(String key) {
        return wechatTemplateRepository.findByTempkey(key);
    }

    @Override
    public Map<String,Object> queryAll(WechatTemplateQueryCriteria criteria, Pageable pageable){
        Page<WechatTemplate> page =wechatTemplateRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(wechatTemplateMapper::toDto));
    }

    @Override
    public List<WechatTemplateDTO> queryAll(WechatTemplateQueryCriteria criteria){
        return wechatTemplateMapper.toDto(wechatTemplateRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public WechatTemplateDTO findById(Integer id) {
        Optional<WechatTemplate> wechatTemplate = wechatTemplateRepository.findById(id);
        ValidationUtil.isNull(wechatTemplate,"WechatTemplate","id",id);
        return wechatTemplateMapper.toDto(wechatTemplate.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public WechatTemplateDTO create(WechatTemplate resources) {
        return wechatTemplateMapper.toDto(wechatTemplateRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(WechatTemplate resources) {
        Optional<WechatTemplate> optionalWechatTemplate = wechatTemplateRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalWechatTemplate,"WechatTemplate","id",resources.getId());
        WechatTemplate wechatTemplate = optionalWechatTemplate.get();
        wechatTemplate.copy(resources);
        wechatTemplateRepository.save(wechatTemplate);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        wechatTemplateRepository.deleteById(id);
    }

}
