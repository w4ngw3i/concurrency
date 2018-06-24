package com.wangwei.concurrency.example.singleton;

import com.wangwei.concurrency.annotaions.NotThreadSafe;

/**
 * Created by wangwei on 2018/3/26.
 * 懒汉式：第一次使用时才初始化
 */
@NotThreadSafe
public class SingletonExample4 {

    private SingletonExample4() {
    }

    private static SingletonExample4 instance = null;

    /**
     * 双重监测机制存在安全问题（JVM和CPU优化，发生了指令重排）
     * 1 memory = allocate() 分配对象内存空间
     * 2 初始化对象
     * 3 设置instance指向分配的内存
     * @return
     */
    public static SingletonExample4 getInstance(){
        if (instance == null){
            synchronized (SingletonExample4.class){
                if (instance == null){
                  instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
