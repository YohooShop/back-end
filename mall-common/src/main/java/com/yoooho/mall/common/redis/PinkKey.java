package com.yoooho.mall.common.redis;

public class PinkKey extends BasePrefix{
    public PinkKey (String prefix) {
        super(prefix);
    }
    public static SeckillKey isGoodsOver = new SeckillKey("go");
    public static SeckillKey getPinkPath = new SeckillKey("path");
}
