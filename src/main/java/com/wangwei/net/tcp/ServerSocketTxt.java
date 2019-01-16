package com.wangwei.net.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther wangwei
 * @Date 2018/5/18 下午2:12
 */
public class ServerSocketTxt {

    public static void main(String[] args)throws Exception {

        ServerSocket ss = new ServerSocket(10008);

        Socket socket = ss.accept();

        //从客户端socket获取源
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String line = null;

        while ((line=bufIn.readLine())!=null){
            System.out.println(line);
            bufOut.write(line.toUpperCase());
            bufOut.newLine();
            bufOut.flush();
        }

        socket.close();
        ss.close();

    }

}
