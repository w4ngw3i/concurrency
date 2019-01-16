package com.wangwei.regex;

/**
 * @Auther wangwei
 * @Date 2018/5/18 下午6:46
 */
public class RegexDemo {

    public static void main(String[] args) {
        RegexDemo.checkQQ2("7777444436为337");
    }

    /**
     * 校验qq号： 长度5-15 0不能开头 只能是数字
     * @param qq
     */
    public static void checkQQ(String qq){

        String regex = "[1-9][0-9]{4,14}";
        boolean matches = qq.matches(regex);
        if (matches)
            System.out.println("qq:"+qq);
        else
            System.out.println("qq号不合法！");

    }


    /**
     * 校验qq号： 长度5-15 0不能开头 只能是数字
     * @param qq
     */
    public static void checkQQ2(String qq){
        int len = qq.length();
        if (len>=5 && len<=15){
            if (!qq.startsWith("0")){
                try {
                   long l = Long.parseLong(qq);
                    System.out.println("qq:"+l);
                }catch (NumberFormatException e){
                    System.out.println("出现非法字符。");
                }

            }else {
                System.out.println("qq号不能以0开头。");
            }

        }else {
            System.out.println("qq号长度不符合规则，长度为5-15位！");
        }
    }


    /**
     * 校验qq号： 长度5-15 0不能开头 只能是数字
     * @param qq
     */
    public static void checkQQ3(String qq){
        int len = qq.length();
        if (len>=5 && len<=15){
            if (!qq.startsWith("0")){
                char[] chars = qq.toCharArray();
                boolean flag = true;
                for (int i = 0; i < chars.length; i++) {
                    if (!(chars[i] >= '0' && chars[i] <= '9')){
                        flag=false;
                        break;
                    }
                }
                if (flag){
                    System.out.println("qq:"+qq);
                }else {
                    System.out.println("qq号只能是数字。");
                }

            }else {
                System.out.println("qq号不能以0开头。");
            }

        }else {
            System.out.println("qq号长度不符合规则，长度为5-15位！");
        }
    }
}
