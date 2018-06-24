package com.wangwei.concurrency.example.immutable;


import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by wangwei on 2018/3/27.
 */
public class ImmutableExample1 {

    private final static Integer a = 1;

    private final static String b = "2";

    public static final Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }




}
