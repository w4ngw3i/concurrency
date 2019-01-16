package com.wangwei.net.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Auther wangwei
 * @Date 2018/5/18 上午11:17
 */
public class TCPClient2 {
    public static void main(String[] args)throws Exception {
        Socket s = new Socket("192.168.0.9", 10002);
        OutputStream os = s.getOutputStream();
        os.write("服务端你好！".getBytes());

        InputStream is = s.getInputStream();

        byte[] buf = new byte[1024];

        int len = is.read(buf);
        System.out.println(new String(buf, 0, len));

        s.close();
    }
}
