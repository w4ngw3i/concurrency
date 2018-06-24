package com.wangwei.concurrency.example.enumdemo;

/**
 * Created by wangwei on 2018/3/26.
 * 使用关键字enum定义枚举类
 */
enum  SeasonEnum {
    /**
     * 必须放在首位
     * @return
     */
//    public static final SeasonEnum SPRING = new SeasonEnum("spring", "春暖花开")
    /**
     * 枚举简写
      */
    SPRING("spring", "春暖花开"),
    SUMMER ("summer", "夏日炎炎");

    /**
     * 声明为final在构造器中初始化
     */
    private final String seasonName;

    private final String seasonDesc;


    private SeasonEnum(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }


    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
