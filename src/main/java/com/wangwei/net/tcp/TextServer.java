package com.wangwei.net.tcp;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther wangwei
 * @Date 2018/5/18 下午2:56
 */
public class TextServer {
    public static void main(String[] args)throws Exception {
        ServerSocket ss = new ServerSocket(10010);

        Socket s = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        PrintWriter pw = new PrintWriter(new FileWriter("server_count.properties"), true);

        String line = null;

        while ((line=br.readLine())!=null){
            System.out.println(line);
            if ("over".equalsIgnoreCase(line))
                break;
            pw.println(line);
        }

        PrintWriter printWriter = new PrintWriter(s.getOutputStream(), true);

        printWriter.println("上传成功！");

        s.close();
        ss.close();
        pw.close();


    }
}
