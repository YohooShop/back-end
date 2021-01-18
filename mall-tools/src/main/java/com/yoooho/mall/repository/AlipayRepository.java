package com.yoooho.mall.repository;

import com.yoooho.mall.domian.AlipayConfig;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlipayRepository extends JpaRepository<AlipayConfig, Long> {
}
