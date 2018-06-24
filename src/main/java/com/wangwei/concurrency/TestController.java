package com.wangwei.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangwei on 2018/3/24.
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){

        return "test";
    }
}
