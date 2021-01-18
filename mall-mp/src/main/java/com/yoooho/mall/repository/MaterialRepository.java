package com.yoooho.mall.repository;

import com.yoooho.mall.domian.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface MaterialRepository extends JpaRepository<Material, String>, JpaSpecificationExecutor<Material> {
}
