package com.wangwei.concurrency.example.threadlocal;

import java.util.Locale;

/**
 * Created by wangwei on 2018/3/27.
 */
public class RequestHolder {

    public static final ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id){

       requestHolder.set(id);

    }

    public static Long getId(){

        return requestHolder.get();

    }

    public static void remove(){

       requestHolder.remove();

    }

}
