package com.company.test;

import com.company.test.tcp.Server;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/7/16.
 */
class MyThread implements Runnable {
    int p = 10000;
    @Override
    public void run() {
        for (int i=0;i<10000;i++) {
            if (p>0)
                System.out.println("p is : " + p--);
            if (p==0) {
                long end = Calendar.getInstance().getTimeInMillis();
                System.out.println("end: " + end);
                break;
            }
        }
    }
}
public class Test {
    public static void reflect(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String name = fields[i].getName();
//            jo.put("id", userEntity.getId());
            System.out.println("jo.put(\"" + name + "\", userEntity.get" + name.substring(0,1).toUpperCase() +
                    name.substring(1) + "());");

        }
    }
    public static void splitTest(String s) {
        String[] names = s.split("\\.");
        System.out.println(names[0]);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
//        reflect(new UserEntity());
//        splitTest("abc.s");
//        int i = 1;
//        while (i<=108) {
//            System.out.println(i + ",");
//            i++;
//        }
//        long start = Calendar.getInstance().getTimeInMillis();
//        System.out.println("start: " + start);
//        MyThread my = new MyThread();
//        new Thread(my).start();
//        new Thread(my).start();
//        new Thread(my).start();
//        int p = 100000000;
//        for (int i=0;i<10000;i++) {
//            if (p>0)
//                System.out.println("p is :" + p--);
//        }
//        long end = Calendar.getInstance().getTimeInMillis();
//        System.out.println("time: " + (end - start));
        ServerSocket serverSocket = new ServerSocket(20006);
        Socket client = null;
        boolean f = true;
        while (f) {
            client = serverSocket.accept();
            System.out.println("与客户端连接成功！");
            new Thread(new Server(client)).start();
        }
        serverSocket.close();
    }
}
