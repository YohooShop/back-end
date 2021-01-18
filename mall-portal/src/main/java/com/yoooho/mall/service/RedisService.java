package com.yoooho.mall.service;

import com.yoooho.mall.common.redis.KeyPrefix;

import java.util.List;

/**
 * redis操作Service,
 * 对象和数组都以json形式进行存储
 */
public interface RedisService {
    /**
     * 存储数据
     */
    void set(String key, String value);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置超期时间
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    boolean remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);


    /**
     * 获取当个对象
     * */
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz);

    /**
     * 设置对象
     * */
    public <T> boolean set(KeyPrefix prefix, String key, T value);

    /**
     * 判断key是否存在
     * */
    public <T> boolean exists(KeyPrefix prefix, String key);

    /**
     * 删除
     * */
    public boolean delete(KeyPrefix prefix, String key);

    /**
     * 增加值
     * */
    public <T> Long incr(KeyPrefix prefix, String key, long delta);
    /**
     * 减少值
     * */
    public <T> Long decr(KeyPrefix prefix, String key, long delta);

    /**
     * 减少值
     * */
    public <T> Long decr(String key, long delta);


    public  <T> String beanToString(T value);

    public  <T> T stringToBean(String str, Class<T> clazz);

    /**
     * 获取符合条件的key
     * @param pattern	表达式
     * @return
     */
    public List<String> keys(String pattern);
}
