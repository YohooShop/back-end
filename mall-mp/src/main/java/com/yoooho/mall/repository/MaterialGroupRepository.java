package com.yoooho.mall.repository;

import com.yoooho.mall.domian.MaterialGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author hupeng
* @date 2020-01-09
*/
public interface MaterialGroupRepository extends JpaRepository<MaterialGroup, String>, JpaSpecificationExecutor<MaterialGroup> {
}
