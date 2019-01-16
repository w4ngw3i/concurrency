package com.wangwei.net.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Auther wangwei
 * @Date 2018/5/18 下午5:13
 */
public class LoginClient {
    public static void main(String[] args)throws Exception {
        Socket socket = new Socket("192.168.0.9", 10009);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader bufIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        for (int i = 0; i < 3; i++) {
            String line = br.readLine();
            if (line == null)
                break;
            pw.println(line);

            String readLine = bufIn.readLine();
            if (readLine.contains("欢迎"))
                break;
            System.out.println(readLine);
        }

        br.close();
        socket.close();

    }
}
