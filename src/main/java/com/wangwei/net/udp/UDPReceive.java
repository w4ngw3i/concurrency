package com.wangwei.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Auther wangwei
 * @Date 2018/5/18 上午10:19
 */
public class UDPReceive {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(8888);

        byte[] buf = new byte[1024];

        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        ds.receive(dp);

        String hostAddress = dp.getAddress().getHostAddress();
        int port = dp.getPort();
        String data = new String(dp.getData(), 0, dp.getLength());
        System.out.println("消息来自："+hostAddress+":"+port+":"+data);

        ds.close();
    }
}
