package com.company.test.udp;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.*;

/**
 * Created by Administrator on 2016/7/24.
 */
public class Client {
    private static final int TIMEOUT = 3000;
    private static final int MAXNUM = 5;
    public static void main(String[] args) throws IOException {
        String send = "Hello server!";
        byte[] bytes = new byte[1024];
        DatagramSocket socket = new DatagramSocket(9000);
        InetAddress loc = InetAddress.getLocalHost();
        DatagramPacket dp_send = new DatagramPacket(send.getBytes(), send.length(), loc, 3000);
        DatagramPacket dp_recv = new DatagramPacket(bytes, 1024);
        socket.setSoTimeout(TIMEOUT);
        int tries = 0;
        boolean recv = false;
        while (tries < MAXNUM && !recv) {
            socket.send(dp_send);
            try {
                socket.receive(dp_recv);
                if (!dp_recv.getAddress().equals(loc)) {
                    throw new IOException("not from localhost");
                }
                recv = true;
            } catch (InterruptedIOException e) {
                tries++;
                System.out.println("remaining " + (5 - tries) + " more times...");
//                e.printStackTrace();
            }
        }

        if (recv) {
            System.out.println("receive from server:");
            String str_recv = new String(dp_recv.getData(), 0, dp_recv.getLength()) + " from " +
                    dp_recv.getAddress() + ":" + dp_recv.getPort();
            System.out.println(str_recv);
            dp_recv.setLength(1024);
        } else {
            System.out.printf("No response...");
        }
        socket.close();
    }
}
