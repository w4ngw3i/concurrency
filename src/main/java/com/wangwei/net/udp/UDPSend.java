package com.wangwei.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Auther wangwei
 * @Date 2018/5/18 上午10:08
 */
public class UDPSend {

    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket();

        byte[] buf = "来自udp服务端".getBytes();

        DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.0.9"), 8888);

        ds.send(dp);

        ds.close();
    }
}
