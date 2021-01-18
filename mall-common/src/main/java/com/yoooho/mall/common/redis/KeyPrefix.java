package com.yoooho.mall.common.redis;

public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();

}
