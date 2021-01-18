package com.yoooho.mall.service.impl;

import com.yoooho.mall.common.annotation.QueryHelp;
import com.yoooho.mall.common.utils.PageUtil;
import com.yoooho.mall.common.utils.ValidationUtil;
import com.yoooho.mall.service.DictDetailService;
import com.yoooho.mall.service.dto.DictDetailDTO;
import com.yoooho.mall.service.dto.DictDetailQueryCriteria;
import com.yoooho.mall.domain.DictDetail;
import com.yoooho.mall.repository.DictDetailRepository;
import com.yoooho.mall.service.convern.DictDetailMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
* @author Zheng Jie
* @date 2019-04-10
*/
@Service
@CacheConfig(cacheNames = "dictDetail")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictDetailServiceImpl implements DictDetailService {

    private final DictDetailRepository dictDetailRepository;

    private final DictDetailMapper dictDetailMapper;

    public DictDetailServiceImpl(DictDetailRepository dictDetailRepository, DictDetailMapper dictDetailMapper) {
        this.dictDetailRepository = dictDetailRepository;
        this.dictDetailMapper = dictDetailMapper;
    }

    @Override
    @Cacheable
    public Map<String, Object> queryAll(DictDetailQueryCriteria criteria, Pageable pageable) {
        Page<DictDetail> page = dictDetailRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(dictDetailMapper::toDto));
    }

    @Override
    @Cacheable(key = "#p0")
    public DictDetailDTO findById(Long id) {
        DictDetail dictDetail = dictDetailRepository.findById(id).orElseGet(DictDetail::new);
        ValidationUtil.isNull(dictDetail.getId(),"DictDetail","id",id);
        return dictDetailMapper.toDto(dictDetail);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public DictDetailDTO create(DictDetail resources) {
        return dictDetailMapper.toDto(dictDetailRepository.save(resources));
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(DictDetail resources) {
        DictDetail dictDetail = dictDetailRepository.findById(resources.getId()).orElseGet(DictDetail::new);
        ValidationUtil.isNull( dictDetail.getId(),"DictDetail","id",resources.getId());
        resources.setId(dictDetail.getId());
        dictDetailRepository.save(resources);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        dictDetailRepository.deleteById(id);
    }
}
