package com.wangwei.concurrency.example.singleton;

import com.wangwei.concurrency.annotaions.NotThreadSafe;

/**
 * Created by wangwei on 2018/3/26.
 * 懒汉式：第一次使用时才初始化
 */
@NotThreadSafe
public class SingletonExample1 {

    private SingletonExample1() {
    }

    private static SingletonExample1 instance = null;

    public static SingletonExample1 getInstance(){
        if (instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
