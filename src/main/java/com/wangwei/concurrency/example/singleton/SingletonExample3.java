package com.wangwei.concurrency.example.singleton;

import com.wangwei.concurrency.annotaions.NotThreadSafe;

/**
 * Created by wangwei on 2018/3/26.
 * 懒汉式：第一次使用时才初始化
 */
@NotThreadSafe
public class SingletonExample3 {

    private SingletonExample3() {
    }

    private static SingletonExample3 instance = null;

    public static synchronized SingletonExample3 getInstance(){
        if (instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
