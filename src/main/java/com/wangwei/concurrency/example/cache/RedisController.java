package com.wangwei.concurrency.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther wangwei
 * @Date 2018/4/25 下午5:18
 */
@RestController
@RequestMapping("/cache")
public class RedisController {

    @Autowired
    private RedisClient redisClient;

    @GetMapping("/set")
    public String set(@RequestParam("k") String k, @RequestParam("v") String v)throws Exception{

        redisClient.set(k, v);

        return "success";
    }

    @GetMapping("/get")
    public String set(@RequestParam("k") String k)throws Exception{

        return redisClient.get(k);

    }


}
