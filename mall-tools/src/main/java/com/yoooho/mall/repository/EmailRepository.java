package com.yoooho.mall.repository;

import com.yoooho.mall.domian.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailConfig,Long> {
}
