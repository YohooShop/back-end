package com.yoooho.mall.rabbitmq;

import com.yoooho.mall.controller.OmsPortalKillController;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="mall.seckillProduct.change")
public class MQSeckillProductChangeReceiver {
    @Autowired
    OmsPortalKillController portalKillController;
    @RabbitHandler
    public void handle(Long goodsId){
        portalKillController.resetSeckillProduct(goodsId);
        System.out.println("秒杀商品改变了");
    }
}
