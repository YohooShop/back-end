package com.yoooho.mall.common.redis;

public class GoodsKey extends BasePrefix{


    public GoodsKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
    public static GoodsKey getGoodsList = new GoodsKey(60, "gl");
    public static GoodsKey getGoodsDetail = new GoodsKey(60, "gd");
    public static KeyPrefix getKillGoodsStock = new GoodsKey(0,"kgs");
    public static KeyPrefix getPinkGoodsStock = new GoodsKey(0,"pgs");
}
