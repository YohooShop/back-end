package com.yoooho.mall.domain;

import lombok.Getter;

/**
 * 消息队列枚举配置
 * Created by yoooho on 2019/9/14.
 */
@Getter
public enum PinkQueueEnum {
    /**
     * 消息通知队列
     */
    QUEUE_PINK_CANCEL("mall.pink.direct", "mall.pink.cancel", "mall.pink.cancel"),
    /**
     * 消息通知ttl队列
     */
    QUEUE_TTL_PINK_CANCEL("mall.pink.direct.ttl", "mall.pink.cancel.ttl", "mall.pink.cancel.ttl");

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

    PinkQueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
