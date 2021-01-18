package com.yoooho.mall.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQPinkConfig {
    public static final String PINK_QUEUE = "pink.queue";
    /**
     * Direct模式 交换机Exchange
     * */
    @Bean
    public Queue pinkQueue() {
        return new Queue(PINK_QUEUE, true);
    }
}
