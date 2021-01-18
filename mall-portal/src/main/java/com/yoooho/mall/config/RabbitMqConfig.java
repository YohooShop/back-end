package com.yoooho.mall.config;

import com.yoooho.mall.common.KPQueueEnum;
import com.yoooho.mall.domain.PinkQueueEnum;
import com.yoooho.mall.domain.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息队列配置
 * Created by yoooho on 2019/9/14.
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 订单消息实际消费队列所绑定的交换机
     */
    @Bean
    DirectExchange orderDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_ORDER_CANCEL.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 订单延迟队列队列所绑定的交换机
     */
    @Bean
    DirectExchange orderTtlDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 订单实际消费队列
     */
    @Bean
    public Queue orderQueue() {
        return new Queue(QueueEnum.QUEUE_ORDER_CANCEL.getName());
    }

    /**
     * 订单延迟队列（死信队列）
     */
    @Bean
    public Queue orderTtlQueue() {
        return QueueBuilder
                .durable(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getName())
                .withArgument("x-dead-letter-exchange", QueueEnum.QUEUE_ORDER_CANCEL.getExchange())//到期后转发的交换机
                .withArgument("x-dead-letter-routing-key", QueueEnum.QUEUE_ORDER_CANCEL.getRouteKey())//到期后转发的路由键
                .build();
    }

    /**
     * 将订单队列绑定到交换机
     */
    @Bean
    Binding orderBinding(DirectExchange orderDirect,Queue orderQueue){
        return BindingBuilder
                .bind(orderQueue)
                .to(orderDirect)
                .with(QueueEnum.QUEUE_ORDER_CANCEL.getRouteKey());
    }

    /**
     * 将订单延迟队列绑定到交换机
     */
    @Bean
    Binding orderTtlBinding(DirectExchange orderTtlDirect,Queue orderTtlQueue){
        return BindingBuilder
                .bind(orderTtlQueue)
                .to(orderTtlDirect)
                .with(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRouteKey());
    }


    /***************************秒杀数据更新mq********************/

    /**
     * 消息实际消费队列所绑定的交换机
     */
    @Bean
    DirectExchange kpDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(KPQueueEnum.QUEUE_KPRODUCT_CHANGEN.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 延迟队列队列所绑定的交换机
     */
    @Bean
    DirectExchange kpTtlDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(KPQueueEnum.QUEUE_TTL_KPRODUCT_CHANGEN.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 实际消费队列
     */
    @Bean
    public Queue kpQueue() {
        return new Queue(KPQueueEnum.QUEUE_KPRODUCT_CHANGEN.getName());
    }

    /**
     * 延迟队列（死信队列）
     */
    @Bean
    public Queue kpTtlQueue() {
        return QueueBuilder
                .durable(KPQueueEnum.QUEUE_TTL_KPRODUCT_CHANGEN.getName())
                .withArgument("x-dead-letter-exchange", KPQueueEnum.QUEUE_KPRODUCT_CHANGEN.getExchange())//到期后转发的交换机
                .withArgument("x-dead-letter-routing-key", KPQueueEnum.QUEUE_KPRODUCT_CHANGEN.getRouteKey())//到期后转发的路由键
                .build();
    }

    /**
     * 将订单队列绑定到交换机
     */
    @Bean
    Binding kpBinding(DirectExchange kpDirect, Queue kpQueue){
        return BindingBuilder
                .bind(kpQueue)
                .to(kpDirect)
                .with(KPQueueEnum.QUEUE_KPRODUCT_CHANGEN.getRouteKey());
    }

    /**
     * 将订单延迟队列绑定到交换机
     */
    @Bean
    Binding kpTtlBinding(DirectExchange kpTtlDirect,Queue kpTtlQueue){
        return BindingBuilder
                .bind(kpTtlQueue)
                .to(kpTtlDirect)
                .with(KPQueueEnum.QUEUE_TTL_KPRODUCT_CHANGEN.getRouteKey());
    }


    /***************************团购有效时间数mq********************/


    /**
     * 订单消息实际消费队列所绑定的交换机
     */
    @Bean
    DirectExchange pinkCancelDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(PinkQueueEnum.QUEUE_PINK_CANCEL.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 订单延迟队列队列所绑定的交换机
     */
    @Bean
    DirectExchange pinkCancelTtlDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange(PinkQueueEnum.QUEUE_TTL_PINK_CANCEL.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 拼团实际消费队列
     */
    @Bean
    public Queue pinkCancelQueue() {
        return new Queue(PinkQueueEnum.QUEUE_PINK_CANCEL.getName());
    }

    /**
     * 订单延迟队列（死信队列）
     */
    @Bean
    public Queue pinkCancelTtlQueue() {
        return QueueBuilder
                .durable(PinkQueueEnum.QUEUE_TTL_PINK_CANCEL.getName())
                .withArgument("x-dead-letter-exchange", PinkQueueEnum.QUEUE_PINK_CANCEL.getExchange())//到期后转发的交换机
                .withArgument("x-dead-letter-routing-key", PinkQueueEnum.QUEUE_PINK_CANCEL.getRouteKey())//到期后转发的路由键
                .build();
    }

    /**
     * 将订单队列绑定到交换机
     */
    @Bean
    Binding pinkBinding(DirectExchange pinkCancelDirect,Queue pinkCancelQueue){
        return BindingBuilder
                .bind(pinkCancelQueue)
                .to(pinkCancelDirect)
                .with(PinkQueueEnum.QUEUE_PINK_CANCEL.getRouteKey());
    }

    /**
     * 将订单延迟队列绑定到交换机
     */
    @Bean
    Binding pinkCancelTtlBinding(DirectExchange pinkCancelTtlDirect,Queue pinkCancelTtlQueue){
        return BindingBuilder
                .bind(pinkCancelTtlQueue)
                .to(pinkCancelTtlDirect)
                .with(QueueEnum.QUEUE_TTL_ORDER_CANCEL.getRouteKey());
    }


}
