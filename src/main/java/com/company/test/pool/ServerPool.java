package com.company.test.pool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Administrator on 2016/7/24.
 */
public class ServerPool {
    private static final int POOLSIZE = 2;

    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(20000);
//        ThreadPoolExecutor executor = new ThreadPoolExecutor()
        for (int i = 0; i < POOLSIZE; i++) {
            Thread thread = new Thread() {
                public void run() {
                    try {
                        Socket client = server.accept();
                        System.out.println("与客户端连接成功");
                        ServerThread.execute(client);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
    }
}
