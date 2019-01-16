package com.wangwei.net.tcp;

import javax.sound.midi.Soundbank;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther wangwei
 * @Date 2018/5/18 上午11:06
 */
public class TCPServer {
    public static void main(String[] args)throws Exception {
        ServerSocket serverSocket = new ServerSocket(10001);

        //获取客户端连接的socket对象
        Socket socket = serverSocket.accept();

        String hostAddress = socket.getInetAddress().getHostAddress();

        System.out.println(hostAddress+"connect......");

        InputStream inputStream = socket.getInputStream();

        byte[] buf = new byte[1024];

        int len = inputStream.read(buf);

        System.out.println(new String(buf, 0, len));

        socket.close();//关闭客户端
    }
}
