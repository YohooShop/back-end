package com.yoooho.mall.rabbitmq;

import com.yoooho.mall.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQSecKillSender {
    private static Logger log = LoggerFactory.getLogger(MQSecKillSender.class);

    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    RedisService redisService;

    public void send(Object message) {
        String msg = redisService.beanToString(message);
        log.info("send message:"+msg);
        amqpTemplate.convertAndSend(MQSeckillConfig.QUEUE, msg);
    }


    public void sendMessage(SecKillMessage mm) {
        String msg = redisService.beanToString(mm);
        log.info("send message :"+msg);
        amqpTemplate.convertAndSend(MQSeckillConfig.MIAOSHA_QUEUE,msg);
    }
}
