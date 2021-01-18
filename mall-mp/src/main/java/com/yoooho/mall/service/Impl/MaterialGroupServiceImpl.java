package com.yoooho.mall.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.yoooho.mall.common.annotation.QueryHelp;
import com.yoooho.mall.common.utils.PageUtil;
import com.yoooho.mall.common.utils.ValidationUtil;
import com.yoooho.mall.domian.MaterialGroup;
import com.yoooho.mall.dto.MaterialGroupDto;
import com.yoooho.mall.dto.MaterialGroupQueryCriteria;
import com.yoooho.mall.repository.MaterialGroupRepository;
import com.yoooho.mall.service.MaterialGroupService;
import com.yoooho.mall.service.mapper.MaterialGroupMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MaterialGroupServiceImpl implements MaterialGroupService {
    private final MaterialGroupRepository materialGroupRepository;

    private final MaterialGroupMapper materialGroupMapper;

    public MaterialGroupServiceImpl(MaterialGroupRepository materialGroupRepository, MaterialGroupMapper materialGroupMapper) {
        this.materialGroupRepository = materialGroupRepository;
        this.materialGroupMapper = materialGroupMapper;
    }

    @Override
    //@Cacheable
    public Map<String,Object> queryAll(MaterialGroupQueryCriteria criteria, Pageable pageable){
        Page<MaterialGroup> page = materialGroupRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(materialGroupMapper::toDto));
    }

    @Override
    //@Cacheable
    public List<MaterialGroupDto> queryAll(MaterialGroupQueryCriteria criteria){
        return materialGroupMapper.toDto(materialGroupRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    //@Cacheable(key = "#p0")
    public MaterialGroupDto findById(String id) {
        MaterialGroup materialGroup = materialGroupRepository.findById(id).orElseGet(MaterialGroup::new);
        ValidationUtil.isNull(materialGroup.getId(),"YxMaterialGroup","id",id);
        return materialGroupMapper.toDto(materialGroup);
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public MaterialGroupDto create(MaterialGroup resources) {
        resources.setId(IdUtil.simpleUUID());
        return materialGroupMapper.toDto(materialGroupRepository.save(resources));
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(MaterialGroup resources) {
        MaterialGroup yxMaterialGroup = materialGroupRepository.findById(resources.getId()).orElseGet(MaterialGroup::new);
        ValidationUtil.isNull( yxMaterialGroup.getId(),"YxMaterialGroup","id",resources.getId());
        yxMaterialGroup.copy(resources);
        materialGroupRepository.save(yxMaterialGroup);
    }

    @Override
    //@CacheEvict(allEntries = true)
    public void deleteAll(String[] ids) {
        for (String id : ids) {
            materialGroupRepository.deleteById(id);
        }
    }

    @Override
    public void deleteById(String id) {
        materialGroupRepository.deleteById(id);
    }
}
