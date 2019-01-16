package com.wangwei;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther wangwei
 * @Date 2018/4/24 下午2:30
 */
public class CountDownLatchDemo {
    static int n = 5;
    private static CountDownLatch countDownLatch = new CountDownLatch(n);
    static class Boss extends Thread{
        @Override
        public void run(){

            System.out.println("Boss在会议室等待，总共有"+countDownLatch.getCount()+"人参加开会.....");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("员工都到齐了，可以开始开会了");
        }
    }

    static class employee extends Thread{
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName()+",到达会议室。。。。");
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        new Boss().start();

        for (int i = 0; i < n; n--) {
            new employee().start();
        }
    }
}

