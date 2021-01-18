package com.yoooho.mall.access;

import com.yoooho.mall.common.redis.BasePrefix;

public class AccessKey extends BasePrefix {
    private AccessKey( int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static AccessKey withExpire(int expireSeconds) {
        return new AccessKey(expireSeconds, "access");
    }
}
