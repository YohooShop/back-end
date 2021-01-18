package com.yoooho.mall.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.yoooho.mall.common.annotation.QueryHelp;
import com.yoooho.mall.common.utils.PageUtil;
import com.yoooho.mall.common.utils.ValidationUtil;
import com.yoooho.mall.domian.Material;
import com.yoooho.mall.dto.MaterialDto;
import com.yoooho.mall.dto.MaterialQueryCriteria;
import com.yoooho.mall.repository.MaterialRepository;
import com.yoooho.mall.service.MaterialService;
import com.yoooho.mall.service.mapper.MaterialMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    private final MaterialMapper materialMapper;

    public MaterialServiceImpl(MaterialRepository materialRepository, MaterialMapper materialMapper) {
        this.materialRepository = materialRepository;
        this.materialMapper = materialMapper;
    }

    @Override
    //@Cacheable
    public Map<String,Object> queryAll(MaterialQueryCriteria criteria, Pageable pageable){
        Page<Material> page = materialRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(materialMapper::toDto));
    }

    @Override
    //@Cacheable
    public List<MaterialDto> queryAll(MaterialQueryCriteria criteria){
        return materialMapper.toDto(materialRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    //@Cacheable(key = "#p0")m
    public MaterialDto findById(String id) {
        Material mterial = materialRepository.findById(id).orElseGet(Material::new);
        ValidationUtil.isNull(mterial.getId(),"Material","id",id);
        return materialMapper.toDto(mterial);
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public MaterialDto create(Material resources) {
        resources.setId(IdUtil.simpleUUID());
        return materialMapper.toDto(materialRepository.save(resources));
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(Material resources) {
        Material material = materialRepository.findById(resources.getId()).orElseGet(Material::new);
        ValidationUtil.isNull( material.getId(),"Material","id",resources.getId());
        material.copy(resources);
        materialRepository.save(material);
    }

    @Override
    //@CacheEvict(allEntries = true)
    public void deleteAll(String[] ids) {
        for (String id : ids) {
            materialRepository.deleteById(id);
        }
    }

    @Override
    public void deleteById(String id) {
        materialRepository.deleteById(id);
    }
}
