package com.wangwei.concurrency.example.threadlocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangwei on 2018/3/27.
 */
@Controller
@RequestMapping("/threadLocal")
public class ThreadLocalController {

    @RequestMapping("/test")
    @ResponseBody
    public Long test(){

        return RequestHolder.getId();

    }
}
