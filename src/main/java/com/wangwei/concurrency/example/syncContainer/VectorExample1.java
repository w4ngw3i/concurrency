package com.wangwei.concurrency.example.syncContainer;

import com.wangwei.concurrency.annotaions.NotThreadSafe;

import java.util.Vector;

/**
 * Created by wangwei on 2018/3/27.
 */
@NotThreadSafe
public class VectorExample1 {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }

        new Thread(() -> {
            for (int i = 0; i < vector.size(); i++) {
                vector.remove(i);
            }
        }).start();


        new Thread(() -> {
            for (int i = 0; i < vector.size(); i++) {
                vector.get(i);
            }
        }).start();

    }
}
