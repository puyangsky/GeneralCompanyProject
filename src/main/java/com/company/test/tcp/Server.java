package com.company.test.tcp;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by Administrator on 2016/7/24.
 */
public class Server implements Runnable{
    private Socket client = null;
    public Server(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            PrintStream out = new PrintStream(client.getOutputStream());
            BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag = true;
            while (flag) {
                String str = buf.readLine();
                if (str == null || str.equals("")) {
                    flag = false;
                }else {
                    if ("bye".equals(str)) {
                        flag = false;
                    } else {
                        out.println("echo:" + str);
                    }
                }
            }
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
