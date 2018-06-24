package com.wangwei.concurrency.example.singleton;

import com.wangwei.concurrency.annotaions.NotThreadSafe;

/**
 * Created by wangwei on 2018/3/26.
 * 饿汉式：在类装载时初始化
 */
@NotThreadSafe
public class SingletonExample2 {

    private SingletonExample2() {
    }

    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance(){

        return instance;
    }
}
