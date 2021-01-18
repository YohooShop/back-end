package com.yoooho.mall.service.impl;


import com.yoooho.mall.common.annotation.QueryHelp;
import com.yoooho.mall.common.exception.BadRequestException;
import com.yoooho.mall.common.utils.FileUtil;
import com.yoooho.mall.common.utils.ValidationUtil;
import com.yoooho.mall.domain.Dept;
import com.yoooho.mall.service.DeptService;
import com.yoooho.mall.service.dto.DeptDTO;
import com.yoooho.mall.service.dto.DeptQueryCriteria;
import com.yoooho.mall.repository.DeptRepository;
import com.yoooho.mall.service.convern.DeptMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
* @author Zheng Jie
* @date 2019-03-25
*/
@Service
@CacheConfig(cacheNames = "dept")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DeptServiceImpl implements DeptService {

    private final DeptRepository deptRepository;

    private final DeptMapper deptMapper;

    public DeptServiceImpl(DeptRepository deptRepository, DeptMapper deptMapper) {
        this.deptRepository = deptRepository;
        this.deptMapper = deptMapper;
    }

    @Override
    @Cacheable
    public List<DeptDTO> queryAll(DeptQueryCriteria criteria) {
        return deptMapper.toDto(deptRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Cacheable(key = "#p0")
    public DeptDTO findById(Long id) {
        Dept dept = deptRepository.findById(id).orElseGet(Dept::new);
        ValidationUtil.isNull(dept.getId(),"Dept","id",id);
        return deptMapper.toDto(dept);
    }

    @Override
    @Cacheable
    public List<Dept> findByPid(long pid) {
        return deptRepository.findByPid(pid);
    }

    @Override
    public Set<Dept> findByRoleIds(Long id) {
        return deptRepository.findByRoles_Id(id);
    }

    @Override
    @Cacheable
    public Object buildTree(List<DeptDTO> deptDtos) {
        Set<DeptDTO> trees = new LinkedHashSet<>();
        Set<DeptDTO> depts= new LinkedHashSet<>();
        List<String> deptNames = deptDtos.stream().map(DeptDTO::getName).collect(Collectors.toList());
        boolean isChild;
        List<Dept> deptList = deptRepository.findAll();
        for (DeptDTO deptDTO : deptDtos) {
            isChild = false;
            if ("0".equals(deptDTO.getPid().toString())) {
                trees.add(deptDTO);
            }
            for (DeptDTO it : deptDtos) {
                if (it.getPid().equals(deptDTO.getId())) {
                    isChild = true;
                    if (deptDTO.getChildren() == null) {
                        deptDTO.setChildren(new ArrayList<>());
                    }
                    deptDTO.getChildren().add(it);
                }
            }
            if(isChild) {
                depts.add(deptDTO);
                for (Dept dept : deptList) {
                    if(dept.getId() == deptDTO.getPid() && !deptNames.contains(dept.getName())){
                        depts.add(deptDTO);
                    }
                }
            }
        }

        if (CollectionUtils.isEmpty(trees)) {
            trees = depts;
        }

        Integer totalElements = deptDtos.size();

        Map<String, Object> map = new HashMap<>(2);
        map.put("totalElements",totalElements);
        map.put("content", CollectionUtils.isEmpty(trees)? deptDtos :trees);
        return map;
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public DeptDTO create(Dept resources) {
       List list = deptRepository.findByPid((long) 0);
       if (list.size() == 0) {
           resources.setPid((long)0);
       }
        return deptMapper.toDto(deptRepository.save(resources));
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(Dept resources) {
        if(resources.getId().equals(resources.getPid())) {
            throw new BadRequestException("上级不能为自己");
        }
        Dept dept = deptRepository.findById(resources.getId()).orElseGet(Dept::new);
        ValidationUtil.isNull( dept.getId(),"Dept","id",resources.getId());
        resources.setId(dept.getId());
        deptRepository.save(resources);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<DeptDTO> deptDtos) {
        for (DeptDTO deptDto : deptDtos) {
            deptRepository.deleteById(deptDto.getId());
        }
    }

    @Override
    public void download(List<DeptDTO> deptDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        for (DeptDTO deptDTO : deptDtos) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("部门名称", deptDTO.getName());
            map.put("部门状态", deptDTO.getEnabled() ? "启用" : "停用");
            map.put("创建日期", sdf.format(deptDTO.getCreateTime()));
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }

    @Override
    public Set<DeptDTO> getDeleteDepts(List<Dept> menuList, Set<DeptDTO> deptDtos) {
        for (Dept dept : menuList) {
            deptDtos.add(deptMapper.toDto(dept));
            List<Dept> depts = deptRepository.findByPid(dept.getId());
            if(depts!=null && depts.size()!=0){
                getDeleteDepts(depts, deptDtos);
            }
        }
        return deptDtos;
    }
}
