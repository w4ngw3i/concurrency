package com.wangwei.net.tcp;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @Auther wangwei
 * @Date 2018/5/18 上午11:04
 */
public class TCPClient {
    public static void main(String[] args)throws Exception {
        Socket socket = new Socket("192.168.0.9", 10001);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("tcp servier 哥们我来了".getBytes());
        socket.close();
    }
}
