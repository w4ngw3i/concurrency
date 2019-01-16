package com.wangwei.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Auther wangwei
 * @Date 2018/5/18 上午10:38
 */
public class UDPReceive2 {

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(10000);

        while (true){
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            ds.receive(dp);
            String hostAddress = dp.getAddress().getHostAddress();
            int port = dp.getPort();
            String data = new String(dp.getData(), 0, dp.getLength());
            System.out.println(hostAddress+":"+port+":"+data);
        }
    }
}
