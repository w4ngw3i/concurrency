package com.wangwei.concurrency.example.enumdemo;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by wangwei on 2018/3/26.
 */
@Slf4j
public class SeasonTest {

    public static void main(String[] args) {
        Season spring = Season.SPRING;
        log.info("{} : {}", spring.getSeasonName(), spring.getSeasonDesc());
    }
}
