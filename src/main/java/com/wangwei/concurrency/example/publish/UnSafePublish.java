package com.wangwei.concurrency.example.publish;

import com.wangwei.concurrency.annotaions.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by wangwei on 2018/3/26.
 */
@Slf4j
@NotThreadSafe
public class UnSafePublish {

    private String[] status = {"a", "b", "c"};

    public String[] getStatus(){

        return status;
    }

    public static void main(String[] args) {
        UnSafePublish unSafePublish = new UnSafePublish();
        log.info("{}", Arrays.toString(unSafePublish.getStatus()));

        unSafePublish.getStatus()[0] = "d";

        log.info("{}", Arrays.toString(unSafePublish.getStatus()));
    }
}
