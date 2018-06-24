package com.wangwei.concurrency.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

/**
 * @Auther wangwei
 * @Date 2018/4/25 下午5:08
 */
@Component
public class RedisClient {
    
    @Autowired
    private JedisPoolConfig jedisPoolConfig;

    @Resource(name = "redisPoll")
    private JedisPool jedisPool;
    
    public void set(String key, String value)throws Exception{
        Jedis jedis = null;
        try {
//            JedisPool jedisPool = jedisPoolConfig.jedisPool();
//            jedis = jedisPool.getResource();
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

    public String get(String key)throws Exception{
        Jedis jedis = null;
        try {
//            JedisPool jedisPool = jedisPoolConfig.jedisPool();
//            jedis = jedisPool.getResource();
            jedis = jedisPool.getResource();
            return  jedis.get(key);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }
    }

}
