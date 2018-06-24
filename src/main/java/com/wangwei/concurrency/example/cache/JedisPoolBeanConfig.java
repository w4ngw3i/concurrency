package com.wangwei.concurrency.example.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

/**
 * @Auther wangwei
 * @Date 2018/4/25 下午5:16
 */
@Configuration
public class JedisPoolBeanConfig {

    @Bean(name = "redisPoll")
    public JedisPool jedisPool(@Value("${jedis.host}") String host, @Value("${jedis.port}") int port){
        return new JedisPool(host, port);
    }
}
