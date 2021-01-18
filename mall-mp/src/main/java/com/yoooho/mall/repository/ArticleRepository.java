package com.yoooho.mall.repository;

import com.yoooho.mall.domian.WXArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticleRepository extends JpaRepository<WXArticle, Integer>, JpaSpecificationExecutor {
}
