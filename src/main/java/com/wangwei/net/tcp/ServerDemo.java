package com.wangwei.net.tcp;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther wangwei
 * @Date 2018/5/18 下午6:26
 */
public class ServerDemo {
    public static void main(String[] args)throws Exception {
        ServerSocket ss = new ServerSocket(11000);

        Socket s = ss.accept();

        System.out.println(s.getInetAddress().getHostAddress()+"----connect----");

        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

        pw.println("客户端你好～！");

        s.close();

        ss.close();
    }
}
