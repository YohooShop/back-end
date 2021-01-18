package com.yoooho.mall.common;

public enum ProductState {

    NORMAL(1,"正常"),
    SECKILL(2,"秒杀"),
    GROUPBUY(3,"团购");

    private long state;
    private String name;

    private ProductState(long state, String name) {
        this.state = state;
        this.name = name;
    }

    public long getState() {
        return state;
    }

    public void setState(long state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
