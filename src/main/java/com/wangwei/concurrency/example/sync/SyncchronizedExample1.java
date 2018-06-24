package com.wangwei.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangwei on 2018/3/25.
 */
@Slf4j
public class SyncchronizedExample1 {

    /**
     * 修饰一个代码块：作用对象是调用对象
     * @param j
     */
    public void test1(int j){
        synchronized (this){
            for (int i=0; i<10; i++){
                log.info("test1:{} {}", j,i);
            }
        }
    }

    /**
     * 修饰一个方法：作用对象是调用对象
     * @param j
     */
    public synchronized void test2(int j){
        for (int i=0; i<10; i++){
            log.info("test2: {} {}", j, i);
        }
    }

    public static void main(String[] args) {

        SyncchronizedExample1 example1 = new SyncchronizedExample1();
        SyncchronizedExample1 example2 = new SyncchronizedExample1();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(() -> {
            example1.test2(1);
        });

        executorService.execute(() -> {
            example2.test2(2);
        });
    }
}
