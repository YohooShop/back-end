package com.yoooho.mall.rabbitmq;

import com.yoooho.mall.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQPinkSender {
    private static Logger log = LoggerFactory.getLogger(MQSecKillSender.class);

    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    RedisService redisService;
    public void sendMessage(PinkMessage mm) {
        String msg = redisService.beanToString(mm);
        log.info("send message :"+msg);
        amqpTemplate.convertAndSend(MQPinkConfig.PINK_QUEUE,msg);
    }
}
