package com.wangwei.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangwei on 2018/3/28.
 */
@Slf4j
public class CountDownLatchExample2 {

    public final static int threadCount = 200;

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();

        CountDownLatch count = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {

            final int threadNum = i;


            executorService.execute(() -> {

                try {
                    test(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    count.countDown();
                }

            });
        }

        count.await(10, TimeUnit.MILLISECONDS);

        log.info("finish");

        executorService.shutdown();
    }

    public static void test(int threadNum)throws Exception{

        Thread.sleep(100);

        log.info("{}", threadNum);

    }


}
