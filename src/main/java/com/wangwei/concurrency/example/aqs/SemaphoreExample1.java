package com.wangwei.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by wangwei on 2018/3/28.
 */
@Slf4j
public class SemaphoreExample1 {

    public final static int threadCount = 20;

    public static void main(String[] args) throws Exception {


        ExecutorService executorService = Executors.newCachedThreadPool();

        /**
         * 并发控制：同一时间允许3个线程同时执行
         */
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {

            final int threadNum = i;

            executorService.execute(() -> {

                try {

                    semaphore.acquire();//获取一个许可

                    test(threadNum);

                    semaphore.release();//释放一个许可
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }

    public static void test(int threadNum)throws Exception{

        log.info("{}", threadNum);

        Thread.sleep(100);
    
    }


}
