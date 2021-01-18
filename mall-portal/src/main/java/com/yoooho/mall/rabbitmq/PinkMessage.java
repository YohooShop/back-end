package com.yoooho.mall.rabbitmq;

public class PinkMessage {
    private Long userId;
    private Long goodsId;
    private Integer pinkType;
    private Long pinkId;
    public long getUserId() {
        return userId;
    }



    public Long getGoodsId() {
        return goodsId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getPinkType() {
        return pinkType;
    }

    public void setPinkType(Integer pinkType) {
        this.pinkType = pinkType;
    }

    public Long getPinkId() {
        return pinkId;
    }

    public void setPinkId(Long pinkId) {
        this.pinkId = pinkId;
    }
}
