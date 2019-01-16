package com.wangwei.net.tcp;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Auther wangwei
 * @Date 2018/5/18 下午4:03
 */
public class PicClient {
    public static void main(String[] args)throws Exception {
        Socket socket = new Socket("192.168.0.9", 10009);

        FileInputStream fis = new FileInputStream("/Users/wangwei/Pictures/素材/2ddfaa51424063.58ed1b49a6a4d.jpg");

        OutputStream os = socket.getOutputStream();

        byte[] buf = new byte[1024];

        int len = 0;

        while ((len=fis.read(buf))!=-1){
            os.write(buf, 0, len);
        }

        //告诉服务器上传结束
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();

        byte[] bytes = new byte[1024];

        int num = is.read(bytes);

        System.out.println(new String(bytes,0, num));

        fis.close();
        socket.close();

    }
}
