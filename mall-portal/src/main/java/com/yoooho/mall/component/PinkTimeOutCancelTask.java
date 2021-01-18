package com.yoooho.mall.component;

import com.yoooho.mall.common.CommonResult;
import com.yoooho.mall.service.PinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PinkTimeOutCancelTask {
    private Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    @Autowired
    PinkService pinkService;
    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每10分钟扫描一次，扫描设定超时时间
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutPink(){
        CommonResult result = pinkService.cancelTimeOutPink();
        LOGGER.info("取消定时任务拼团",result);
    }
}
