package com.yoooho.mall.express.repository;

import com.yoooho.mall.express.domain.KDNExpressCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface KDNExpressCompanyRepository extends JpaRepository<KDNExpressCompany, Integer>, JpaSpecificationExecutor {
    /**
     * findByCode
     * @param code
     * @return
     */
    KDNExpressCompany findByCode(String code);
}
