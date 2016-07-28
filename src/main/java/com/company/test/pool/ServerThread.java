package com.company.test.pool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by Administrator on 2016/7/24.
 */
public class ServerThread implements Runnable {
    Socket client = null;
    public ServerThread(Socket client) {
        this.client = client;
    }

    public static void execute(Socket client) {
        try {
            PrintStream out = new PrintStream(client.getOutputStream());
            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag = true;
            while (flag) {
                String str = buf.readLine();
                if (str == null || "".equals(str)) {
                    flag = false;
                } else {
                    if ("bye".equals(str)) {
                        flag = false;
                    } else {
                        out.print("echo:" + str);
                    }
                }
            }
            out.close();
            buf.close();
            client.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        execute(client);
    }
}
