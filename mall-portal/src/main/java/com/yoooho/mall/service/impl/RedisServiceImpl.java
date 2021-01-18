package com.yoooho.mall.service.impl;

import com.alibaba.fastjson.JSON;
import com.yoooho.mall.common.redis.KeyPrefix;
import com.yoooho.mall.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * redis操作Service的实现类
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean expire(String key, long expire) {
        return stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    @Override
    public boolean remove(String key) {
        return  stringRedisTemplate.delete(key);
    }

    @Override
    public Long increment(String key, long delta) {
        return stringRedisTemplate.opsForValue().increment(key,delta);
    }

    /**
     * scan 实现
     * @param pattern	表达式
     * @param consumer	对迭代到的key进行操作
     */
    public void scan(String pattern, Consumer<byte[]> consumer) {
        this.stringRedisTemplate.execute((RedisConnection connection) -> {
            try (Cursor<byte[]> cursor = connection.scan(ScanOptions.scanOptions().count(Long.MAX_VALUE).match(pattern).build())) {
                cursor.forEachRemaining(consumer);
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * 获取符合条件的key
     * @param pattern	表达式
     * @return
     */
    public List<String> keys(String pattern) {
        List<String> keys = new ArrayList<>();
        scan(pattern, item -> {
            //符合条件的key
            String key = new String(item, StandardCharsets.UTF_8);
            keys.add(key);
        });
        return keys;
    }

    /**
     * 获取当个对象
     * */
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {

            //生成真正的key
            String realKey  = prefix.getPrefix() + key;
            String  str = get(realKey);
            T t =  stringToBean(str, clazz);
            return t;
    }
    /**
     * 设置对象
     * */
    public <T> boolean set(KeyPrefix prefix, String key, T value) {
        String str = beanToString(value);
        if(str == null || str.length() <= 0) {
            return false;
        }
        //生成真正的key
        String realKey  = prefix.getPrefix() + key;
        int seconds =  prefix.expireSeconds();
        if(seconds <= 0) {
            stringRedisTemplate.opsForValue().set(realKey,str);
        }else {
//            stringRedisTemplate.opsForValue().set(realKey,str);
            stringRedisTemplate.opsForValue().set(realKey,str,seconds, TimeUnit.SECONDS);
        }
        return true;
    }

    /**
     * 判断key是否存在
     * */
    public <T> boolean exists(KeyPrefix prefix, String key) {
        //生成真正的key
        String realKey  = prefix.getPrefix() + key;
        return   stringRedisTemplate.hasKey(realKey);
    }

    /**
     * 删除
     * */
    public boolean delete(KeyPrefix prefix, String key) {
        //生成真正的key
        String realKey  = prefix.getPrefix() + key;
        return remove(realKey);
    }

    /**
     * 增加值
     * */
    public <T> Long incr(KeyPrefix prefix, String key , long delta) {
        String realKey  = prefix.getPrefix() + key;
       return stringRedisTemplate.opsForValue().increment(realKey, delta);
    }

    /**
     * 减少值
     * */
    public <T> Long decr(KeyPrefix prefix, String key , long delta) {
        String realKey  = prefix.getPrefix() + key;
        return stringRedisTemplate.opsForValue().decrement(realKey,delta);
    }
    /**
     * 减少值
     * */
    public <T> Long decr(String key , long delta) {
        return stringRedisTemplate.opsForValue().decrement(key , delta);
    }
    public boolean delete(KeyPrefix prefix) {
        if(prefix == null) {
            return false;
        }
        List<String> keys = keys(prefix.getPrefix());
        if(keys==null || keys.size() <= 0) {
            return true;
        }
        stringRedisTemplate.delete(keys);
        return  true;
    }


    public  <T> String beanToString(T value) {
        if(value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if(clazz == int.class || clazz == Integer.class) {
            return ""+value;
        }else if(clazz == String.class) {
            return (String)value;
        }else if(clazz == long.class || clazz == Long.class) {
            return ""+value;
        }else {
            return JSON.toJSONString(value);
        }
    }
    @SuppressWarnings("unchecked")
    public  <T> T stringToBean(String str, Class<T> clazz) {
        if(str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if(clazz == int.class || clazz == Integer.class) {
            return (T)Integer.valueOf(str);
        }else if(clazz == String.class) {
            return (T)str;
        }else if(clazz == long.class || clazz == Long.class) {
            return  (T)Long.valueOf(str);
        }else {
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }


}
