package com.wangwei.net.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther wangwei
 * @Date 2018/5/18 上午11:17
 */
public class TCPServer2 {
    public static void main(String[] args)throws Exception {
        ServerSocket ss = new ServerSocket(10002);

        Socket s = ss.accept();

        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+"...connect....");

        InputStream is = s.getInputStream();

        byte[] buf = new byte[1024];

        int len = is.read(buf);

        System.out.println(new String(buf, 0, len));

        OutputStream os = s.getOutputStream();
        Thread.sleep(10000);
        os.write("收到你的信息，感谢使用".getBytes());

        s.close();
        ss.close();
    }
}
