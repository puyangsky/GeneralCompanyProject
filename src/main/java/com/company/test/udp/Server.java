package com.company.test.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Administrator on 2016/7/24.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        String str_send = "Hello client";
        byte[] buf = new byte[1024];
        DatagramSocket socket = new DatagramSocket(3000);
        DatagramPacket dp_recv = new DatagramPacket(buf, 1024);
        System.out.println("server is on, waiting for client...");
        boolean f = true;
        while (f) {
            socket.receive(dp_recv);
            System.out.println("server receive from client: ");
            String str_recv = new String(dp_recv.getData(), 0, dp_recv.getLength()) + " from " +
            dp_recv.getAddress() + ":" + dp_recv.getPort();
            System.out.println(str_recv);
            DatagramPacket dp_send = new DatagramPacket(str_send.getBytes(), str_send.length(),
                    dp_recv.getAddress(), 9000);
            socket.send(dp_send);
            dp_recv.setLength(1024);
        }
        socket.close();
    }
}
