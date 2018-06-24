package com.wangwei.concurrency.example.cache;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

/**
 * @Auther wangwei
 * @Date 2018/4/25 下午4:54
 */
@Component
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisConfig {

    private String host;

    private int port;


}
