package com.wangwei.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangwei on 2018/3/25.
 */
@Slf4j
public class SyncchronizedExample2 {

    /**
     * 修饰一个类
     * @param j
     */
    public static void test1(int j){
        synchronized (SyncchronizedExample2.class){
            for (int i=0; i<10; i++){
                log.info("test1:{} {}", j,i);
            }
        }
    }

    /**
     * 修饰一个静态方法
     * @param j
     */
    public static synchronized void test2(int j){
        for (int i=0; i<10; i++){
            log.info("test2: {} {}", j, i);
        }
    }

    public static void main(String[] args) {

        SyncchronizedExample2 example1 = new SyncchronizedExample2();
        SyncchronizedExample2 example2 = new SyncchronizedExample2();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            example1.test2(1);
        });

        executorService.execute(() -> {
            example2.test2(2);
        });
    }
}
