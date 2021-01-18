package com.yoooho.mall.common;

import lombok.Getter;

@Getter
public enum KPQueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_KPRODUCT_CHANGEN("mall.seckillProduct.direct", "mall.seckillProduct.change", "mall.seckillProduct.change"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_KPRODUCT_CHANGEN("mall.seckillProduct.direct.ttl", "mall.seckillProduct.change.ttl", "mall.seckillProduct.change.ttl");

    /**
     * 交换名称
     */
    private String exchange;
    /**
     * 队列名称
     */
    private String name;
    /**
     * 路由键
     */
    private String routeKey;

    KPQueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}


