package com.wangwei.concurrency.example.atomic;

import com.wangwei.concurrency.annotaions.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by wangwei on 2018/3/24.
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");


    @Getter
    private volatile int count = 100;

    private static AtomicExample5 example5 = new AtomicExample5();

    public static void main(String[] args) {

        if (updater.compareAndSet(example5, 100, 110)){
            log.info("updater success1, {}", example5.getCount());
        }
        if (updater.compareAndSet(example5, 110, 120)){
            log.info("updater success2, {}", example5.getCount());
        }else {
            log.info("updater failed, {}", example5.getCount());
        }



    }
}
