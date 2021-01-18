package com.yoooho.mall.component;

import com.yoooho.mall.express.service.ExpressService;
import com.yoooho.mall.express.service.OrderExpressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QueryOrderExpressTask {
    private Logger LOGGER = LoggerFactory.getLogger(QueryOrderExpressTask.class);
    @Autowired
    ExpressService expressService;

    @Autowired
    OrderExpressService orderExpressService;
    @Scheduled(cron = "0 0/1 * ? * ?")
    private void queryOrderExpress(){
        orderExpressService.queryOrderExpress();
        LOGGER.info("查询物流");
    }
}
