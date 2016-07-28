package com.company.test.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Created by Administrator on 2016/7/24.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //实例化一个socket对象，需要ip和port两个参数
        Socket socket = new Socket("127.0.0.1", 20000);
        //设置socket超时时间
        socket.setSoTimeout(10000);
        //创建一个BufferedReader来读取客户端的输入
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //创建一个PrintStream来读取socket的输出流，发送到服务器端
        PrintStream out = new PrintStream(socket.getOutputStream());
        //创建BufferedReader来接受服务器端发送过来的数据
        BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        boolean flag = true;
        while (flag) {
            System.out.print("输入信息:");
            String str = bf.readLine();
            //发送数据到服务器端
            out.println(str);
            if ("bye".equals(str)) {
                flag = false;
            } else {
                try {
                    //输出接受到服务器发送回来的数据
                    String echo = buf.readLine();
                    System.out.println(echo);
                } catch (SocketTimeoutException e) {
                    e.printStackTrace();
                }
            }
        }
        bf.close();
        if (socket != null) {
            socket.close();
        }
    }
}
