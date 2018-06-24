package com.wangwei;

import java.util.concurrent.CyclicBarrier;

/**
 * @Auther wangwei
 * @Date 2018/4/24 下午3:14
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int n=4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(n);
        for (int i=0; i<n; i++){
            new Writer(cyclicBarrier).start();
        }
    }

    static class Writer extends Thread{

        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName()+"正在写入数据。。。。");
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+"写入数据完成。。。。");
                cyclicBarrier.await();

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("所有线程写入数据完成");
        }
    }
}
