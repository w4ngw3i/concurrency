package com.wangwei.concurrency.example.atomic;

import com.wangwei.concurrency.annotaions.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wangwei on 2018/3/24.
 */
@Slf4j
@ThreadSafe
public class AtomicExample1 {

    //请求总数
    public static int clientTitle = 5000;

    //同时执行的线程数
    public static int threadTile = 200;

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args)throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();

       final Semaphore semaphore = new Semaphore(threadTile);

       final CountDownLatch countDownLatch = new CountDownLatch(clientTitle);

       for (int i=0; i<clientTitle; i++){
           executorService.execute(() -> {
               try {
                   semaphore.acquire();
                   add();
                   semaphore.release();
               } catch (Exception e){
                   log.error("exception",e);
               }
               countDownLatch.countDown();
           });
       }

       countDownLatch.await();

        executorService.shutdown();

        log.info("count:{}", count.get());

    }

    private static void add(){
        count.incrementAndGet();
    }

}
