package com.wangwei.concurrency.example.atomic;

import com.wangwei.concurrency.annotaions.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by wangwei on 2018/3/24.
 */
@Slf4j
@ThreadSafe
public class AtomicExample4 {

    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(0);

    public static void main(String[] args) {

        atomicReference.compareAndSet(0, 2);

        atomicReference.compareAndSet(3, 8);

        atomicReference.compareAndSet(2, 18);

        atomicReference.compareAndSet(18, 12);

        log.info("atomicReference:{}", atomicReference.get());

    }
}
