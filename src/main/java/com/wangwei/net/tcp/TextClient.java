package com.wangwei.net.tcp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Auther wangwei
 * @Date 2018/5/18 下午2:56
 */
public class TextClient {
    public static void main(String[] args)throws Exception {
        Socket s = new Socket("192.168.0.9", 10010);

        BufferedReader br = new BufferedReader(new FileReader("count.properties"));

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        String line = null;

        while ((line=br.readLine())!=null){
            out.println(line);
        }

//        out.println("over");
        s.shutdownOutput();

        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        System.out.println(bufIn.readLine());

        s.close();
        br.close();
        out.close();

    }
}
