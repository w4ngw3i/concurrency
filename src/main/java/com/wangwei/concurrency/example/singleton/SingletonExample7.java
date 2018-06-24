package com.wangwei.concurrency.example.singleton;

import com.wangwei.concurrency.annotaions.NotThreadSafe;
import com.wangwei.concurrency.annotaions.ThreadSafe;

/**
 * Created by wangwei on 2018/3/26.
 * 懒汉式：第一次使用时才初始化
 */
@ThreadSafe
public class SingletonExample7 {

    private SingletonExample7() {
    }

    public static SingletonExample7 getInstance(){

        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton{

        INSTANCE;

        private SingletonExample7 singleton;

        //jvm保证此方法只调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance(){
            return singleton;
        }
    }
}
