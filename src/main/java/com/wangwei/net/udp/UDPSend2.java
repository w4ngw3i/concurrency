package com.wangwei.net.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Auther wangwei
 * @Date 2018/5/18 上午10:39
 */
public class UDPSend2 {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = null;

        while ((line=reader.readLine()) != null){
            if (line.equals("886"))
                break;
            byte[] buf = line.getBytes();

            DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.9"), 10000);

            ds.send(dp);
        }

        ds.close();
    }
}
