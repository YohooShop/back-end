package com.yoooho.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 * Created by yoooho on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.yoooho.mall.mapper","com.yoooho.mall.dao"})
public class MyBatisConfig {
}
