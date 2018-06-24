package com.wangwei.concurrency.example.enumdemo;

/**
 * Created by wangwei on 2018/3/26.
 * 自定义枚举类
 */
public class Season {

    /**
     * 声明为final在构造器中初始化
     */
    private final String seasonName;

    private final String seasonDesc;


    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    /**
     * 创建枚举类对象
     * @return
     */
    public static final Season SPRING = new Season("spring", "春暖花开");
    public static final Season SUMMER = new Season("summer", "夏日炎炎");

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
