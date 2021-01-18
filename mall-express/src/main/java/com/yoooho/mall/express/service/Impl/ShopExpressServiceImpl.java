package com.yoooho.mall.express.service.Impl;

import com.yoooho.mall.common.annotation.QueryHelp;
import com.yoooho.mall.common.utils.PageUtil;
import com.yoooho.mall.common.utils.ValidationUtil;
import com.yoooho.mall.express.domain.KDNExpressCompany;
import com.yoooho.mall.express.repository.KDNExpressCompanyRepository;
import com.yoooho.mall.express.service.ShopExpressService;
import com.yoooho.mall.express.service.mapper.KDNExpressCompanyMapper;
import com.yoooho.mall.express.service.dto.KDNExpressCompanyDTO;
import com.yoooho.mall.express.service.dto.KDNExpressCompanyQueryCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ShopExpressServiceImpl implements ShopExpressService {

    private final KDNExpressCompanyRepository kdnExpressCompanyRepository;

    private final KDNExpressCompanyMapper kdnExpressCompanyMapper;

    public  ShopExpressServiceImpl(KDNExpressCompanyRepository kdnExpressCompanyRepository ,  KDNExpressCompanyMapper kdnExpressCompanyMapper) {
        this.kdnExpressCompanyMapper = kdnExpressCompanyMapper;
        this.kdnExpressCompanyRepository = kdnExpressCompanyRepository;
    }


    @Override
    public Map<String,Object> queryAll(KDNExpressCompanyQueryCriteria criteria, Pageable pageable){
        Page<KDNExpressCompany> page = kdnExpressCompanyRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(kdnExpressCompanyMapper::toDto));
    }

    @Override
    public List<KDNExpressCompanyDTO> queryAll(KDNExpressCompanyQueryCriteria criteria){
        return kdnExpressCompanyMapper.toDto(kdnExpressCompanyRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public KDNExpressCompanyDTO findById(Integer id) {
        Optional<KDNExpressCompany> KDNExpressCompany = kdnExpressCompanyRepository.findById(id);
        ValidationUtil.isNull(KDNExpressCompany,"KDNExpressCompany","id",id);
        return kdnExpressCompanyMapper.toDto(KDNExpressCompany.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public KDNExpressCompanyDTO create(KDNExpressCompany resources) {
        if(kdnExpressCompanyRepository.findByCode(resources.getCode()) != null){
          return null;
        }
        return kdnExpressCompanyMapper.toDto(kdnExpressCompanyRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(KDNExpressCompany resources) {
        Optional<KDNExpressCompany> optionalKDNExpressCompany = kdnExpressCompanyRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalKDNExpressCompany,"KDNExpressCompany","id",resources.getId());
        KDNExpressCompany kdnExpressCompany = optionalKDNExpressCompany.get();
        KDNExpressCompany kdnExpressCompany1 = null;
        kdnExpressCompany1 = kdnExpressCompanyRepository.findByCode(resources.getCode());
        if(kdnExpressCompany1 != null && !kdnExpressCompany1.getId().equals(kdnExpressCompany.getId())){
            return;
        }
        kdnExpressCompany.copy(resources);
        kdnExpressCompanyRepository.save(kdnExpressCompany);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        kdnExpressCompanyRepository.deleteById(id);
    }
}
