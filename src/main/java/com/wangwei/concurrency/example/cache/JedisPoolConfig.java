package com.wangwei.concurrency.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

/**
 * @Auther wangwei
 * @Date 2018/4/25 下午5:02
 */
@Component
public class JedisPoolConfig {

    @Autowired
    private RedisConfig redisConfig;

    public JedisPool jedisPool(){
        JedisPool jedisPool = new JedisPool(redisConfig.getHost(), redisConfig.getPort());
        return jedisPool;
    }


}
