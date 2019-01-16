package com.wangwei.net.tcp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther wangwei
 * @Date 2018/5/18 下午4:50
 */
public class PicThread implements Runnable {
    private Socket socket;

    public PicThread(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {
        int count = 1;
        String ip = socket.getInetAddress().getHostAddress();
        try {
            System.out.println(ip+"....connect.....");

            InputStream is = socket.getInputStream();


            File file = new File(ip + "(" + (count) + ")" + ".jpg");
            while (file.exists())
                file = new File(ip + "(" + (count++) + ")" + ".jpg");

            FileOutputStream fos = new FileOutputStream(file);

            byte[] buf = new byte[1024];

            int len = 0;

            while ((len=is.read(buf))!=-1){
                fos.write(buf, 0, len);
            }

            OutputStream os = socket.getOutputStream();
            os.write("上传成功".getBytes());
            socket.close();
            fos.close();
        }catch (Exception e) {

            throw new RuntimeException("上传失败");
        }

    }
}
