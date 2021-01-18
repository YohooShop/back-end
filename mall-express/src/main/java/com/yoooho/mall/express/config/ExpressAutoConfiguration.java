package com.yoooho.mall.express.config;


import com.yoooho.mall.express.service.ExpressService;
import com.yoooho.mall.express.service.Impl.ExpressServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ExpressProperties.class)
public class ExpressAutoConfiguration {

    private final ExpressProperties properties;

    public ExpressAutoConfiguration(ExpressProperties properties) {
        this.properties = properties;
    }

    @Bean
    public ExpressService expressService() {
        ExpressService expressService = new ExpressServiceImpl();
        expressService.setProperties(properties);
        return expressService;
    }

}
