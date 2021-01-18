package com.yoooho.mall.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by yoooho on 2019/4/8.
 */
@Configuration
@MapperScan("com.yoooho.mall.convern")
public class MyBatisConfig {
}
