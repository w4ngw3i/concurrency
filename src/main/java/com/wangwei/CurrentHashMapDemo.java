package com.wangwei;

import com.google.common.util.concurrent.AtomicLongMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther wangwei
 * @Date 2018/4/24 下午3:40
 */
public class CurrentHashMapDemo {
    private  final ConcurrentHashMap<String, Long> urlCounter = new ConcurrentHashMap<>();

    private AtomicLongMap<String> urlCounter3 = AtomicLongMap.create();

    public long increase3(String url) {
        long newValue = urlCounter3.incrementAndGet(url);
        return newValue;
    }


    public Long getUrlCount3(String url) {
        return urlCounter3.get(url);
    }


    /**
     * 统计调用次数 1 安全
     * @param url
     * @return
     */
    public long increase2(String url) {
        Long oldValue, newValue;
        while (true) {
            oldValue = urlCounter.get(url);
            if (oldValue == null) {
                newValue = 1l;
                //初始化成功，退出循环
                if (urlCounter.putIfAbsent(url, 1l) == null)
                    break;
                //如果初始化失败，说明其他线程已经初始化过了
            } else {
                newValue = oldValue + 1;
                //+1成功，退出循环
                if (urlCounter.replace(url, oldValue, newValue))
                    break;
                //如果+1失败，说明其他线程已经修改过了旧值
            }
        }
        return newValue;
    }

    /**
     * 第一种不安全统计
     * @param url
     * @return
     */
    public long increase1(String url){
        Long oldValue = urlCounter.get(url);
        Long newValue = (oldValue == null)? 1L : oldValue+1;
        urlCounter.put(url, newValue);
        return newValue;
    }

    /**
     * 获取调用次数
     * @param url
     * @return
     */
    public Long getUrlCount(String url){
        return urlCounter.get(url);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CurrentHashMapDemo hashMapDemo = new CurrentHashMapDemo();
        int callTime = 100000;
        String url ="http://wangwei.nat300.top";
        CountDownLatch countDownLatch = new CountDownLatch(callTime);

        for (int i = 0; i < callTime; i++) {
            executorService.execute(() -> {
                hashMapDemo.increase3(url);
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        System.out.println("调用次数："+  hashMapDemo.getUrlCount3(url));
    }


}
