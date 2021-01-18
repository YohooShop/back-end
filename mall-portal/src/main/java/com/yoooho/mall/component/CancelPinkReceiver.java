package com.yoooho.mall.component;

import com.yoooho.mall.service.PinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "mall.pink.cancel")
public class CancelPinkReceiver {
    private static Logger LOGGER = LoggerFactory.getLogger(CancelOrderReceiver.class);
    @Autowired
    private PinkService pinkService;
    @RabbitHandler
    public void handle(Long orderId){
        pinkService.cancelPink(orderId);
        LOGGER.info("process pinkId:{}",orderId);
    }
}
