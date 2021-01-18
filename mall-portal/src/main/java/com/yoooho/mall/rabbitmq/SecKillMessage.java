package com.yoooho.mall.rabbitmq;

public class SecKillMessage {
    private Long userId;
    private Long goodsId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }
    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

}
