package com.wangwei.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangwei on 2018/3/28.
 */
@Slf4j
public class CyclicBarrierExample1 {

    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args)throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {

            final int threadNum = i;

            Thread.sleep(1000);

            executor.execute(() -> {

                try {
                    race(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void race(int threadNum) throws Exception {

        Thread.sleep(1000);

        log.info("{} is ready", threadNum);

        barrier.await();

        log.info("{} continue", threadNum);

    }
}
