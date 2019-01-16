package com.wangwei.net.tcp;

import javax.naming.Name;
import java.io.*;
import java.net.Socket;

/**
 * @Auther wangwei
 * @Date 2018/5/18 下午5:23
 */
public class UserThread implements Runnable {
    private Socket s;

    public UserThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+"....connect....");
        try {
            for (int i = 0; i < 3; i++) {
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

                File file = new File("user.properties");
                if (!file.exists())
                    file.createNewFile();
                BufferedReader brtxt = new BufferedReader(new FileReader(file));

                PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

                String username = br.readLine();

                String line = null;

                boolean flag = false;

                while ((line=brtxt.readLine())!=null){
                    if (username.equals(line)){
                        flag = true;
                        break;
                    }
                }

                if (flag){
                    System.out.println(username+",已登陆");
                    pw.println("欢迎，"+username);
                    break;
                }

                else {
                    System.out.println(username+",尝试登陆");
                    pw.println(username+",用户名不存在");
                }

            }
            s.close();

        }catch (Exception e){
            throw new RuntimeException("校验失败");
        }
    }
}
