package com.wangwei;

import java.util.concurrent.Semaphore;

/**
 * @Auther wangwei
 * @Date 2018/4/24 下午9:07
 */
public class SemaphoneDemo {
    public static void main(String[] args) {
        int N = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < N; i++) {

            new SemThread(semaphore, i).start();
        }
    }

    static class SemThread extends Thread{
        private Semaphore semaphore;
        private int num;
        public SemThread(Semaphore semaphore, int num){
            this.semaphore = semaphore;
            this.num = num;
        }
        @Override
        public void run(){
            try {
                semaphore.acquire();
                System.out.println("第"+this.num+"号工人占了一台机器。。");
                Thread.sleep(2000);
                System.out.println("第"+this.num+"号工人释放了一台机器。。");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
