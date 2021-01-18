package com.yoooho.mall.rabbitmq;

import com.yoooho.mall.common.KPQueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQSeckillProductChangeSender {
    private static Logger LOGGER = LoggerFactory.getLogger(MQSeckillProductChangeSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(final Long goodsId, final long delayTimes){
        //给延迟队列发送消息
        amqpTemplate.convertAndSend( KPQueueEnum.QUEUE_TTL_KPRODUCT_CHANGEN.getExchange(), KPQueueEnum.QUEUE_TTL_KPRODUCT_CHANGEN.getRouteKey(), goodsId, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //给消息设置延迟毫秒值
                message.getMessageProperties().setExpiration(String.valueOf(delayTimes));
                return message;
            }
        });
    }


}
