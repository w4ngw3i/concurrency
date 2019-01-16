package com.wangwei.net.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @Auther wangwei
 * @Date 2018/5/18 下午2:04
 */
public class SocketTxtClient {

    public static void main(String[] args)throws Exception {
        Socket socket = new Socket("192.168.0.9", 10008);

        //从键盘读取信息
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //获取socket输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        //获取socket输入流
        BufferedReader brSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String text = null;

        while ((text=br.readLine()) != null){
            if ("over".equalsIgnoreCase(text))
                break;
            bw.write(text);
            //加结束标记防止服务端一直阻塞
            bw.newLine();
            bw.flush();

            String readLine = brSocket.readLine();
            System.out.println("server:"+readLine);

        }

        br.close();
        bw.close();

    }
}
