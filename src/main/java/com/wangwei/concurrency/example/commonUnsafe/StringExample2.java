package com.wangwei.concurrency.example.commonUnsafe;

import com.wangwei.concurrency.annotaions.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by wangwei on 2018/3/27.
 */
@Slf4j
public class StringExample2 {

    //请求总数
    public static int clientTitle = 5000;

    //同时执行的线程数
    public static int threadTile = 200;

    public static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(threadTile);

        final CountDownLatch countDownLatch = new CountDownLatch(clientTitle);

        for (int i = 0; i < clientTitle; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        executorService.shutdown();

        log.info("size:{}", stringBuffer.length());

    }

    public static void update(){

       stringBuffer.append("1");

    }
}
