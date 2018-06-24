package com.wangwei.concurrency.example.lock;

import com.wangwei.concurrency.annotaions.NotThreadSafe;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangwei on 2018/3/24.
 */
@Slf4j
@NotThreadSafe
public class LockExample1 {

    //请求总数
    public static int clientTitle = 5000;

    //同时执行的线程数
    public static int threadTile = 200;

    public static int count = 0;

    private static final   Lock lock = new ReentrantLock();

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

        log.info("count:{}", count);

    }

    private synchronized static void add(){

        lock.lock();
        try {
            count++;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
