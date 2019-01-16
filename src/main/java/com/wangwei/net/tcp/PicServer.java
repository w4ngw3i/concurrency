package com.wangwei.net.tcp;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther wangwei
 * @Date 2018/5/18 下午4:10
 */
public class PicServer {
    public static void main(String[] args)throws Exception {
        ServerSocket ss = new ServerSocket(10009);
        while (true){
            Socket s = ss.accept();
            new Thread(new PicThread(s)).start();
        }
    }

}
