package com.wangwei.concurrency.example.singleton;

import com.wangwei.concurrency.annotaions.NotThreadSafe;

/**
 * Created by wangwei on 2018/3/26.
 * 懒汉式：第一次使用时才初始化
 */
@NotThreadSafe
public class SingletonExample6 {

    private SingletonExample6() {
    }

    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }


    public static SingletonExample6 getInstance(){

        return instance;
    }
}
