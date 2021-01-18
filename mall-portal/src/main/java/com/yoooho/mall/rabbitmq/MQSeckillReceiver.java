package com.yoooho.mall.rabbitmq;

import com.yoooho.mall.domain.KillOrderParam;
import com.yoooho.mall.model.OmsOrder;
import com.yoooho.mall.model.PmsProductSeckill;
import com.yoooho.mall.service.*;
import com.yoooho.mall.service.OmsPortalOrderService;
import com.yoooho.mall.service.RedisService;
import com.yoooho.mall.service.SeckillProductServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQSeckillReceiver {
    private static Logger log = LoggerFactory.getLogger(MQSeckillReceiver.class);

    @Autowired
    RedisService redisService;

    @Autowired
    OmsPortalOrderService orderService;


    @Autowired
    SeckillProductServer seckillProductServer;
    @RabbitListener(queues=MQSeckillConfig.QUEUE)
    public void receive(String message) {
        log.info("receive message:"+message);
    }

    //接口优化4：请求出队
    @RabbitListener(queues=MQSeckillConfig.MIAOSHA_QUEUE)
    public void miaoshaReceive(String message) {


        log.info("receive message:"+message);

        SecKillMessage mm  = redisService.stringToBean(message, SecKillMessage.class);
        PmsProductSeckill productSeckill= null;
        try {
          productSeckill = seckillProductServer.getKillProduct(mm.getGoodsId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(productSeckill == null) {
            return;
        }
        int stock = productSeckill.getStock()-productSeckill.getLockStock();

        if(stock <= 0) {
            return;
        }

        OmsOrder order = orderService.getKillOrderByUserIdGoodsId(mm.getUserId(), mm.getGoodsId());
        if(order != null) {
            return;
        }
        KillOrderParam orderParam = new KillOrderParam();
        orderParam.setId(mm.getGoodsId());
        orderParam.setUserId(mm.getUserId());
        orderService.generateKillOrder(orderParam);
    }

}
