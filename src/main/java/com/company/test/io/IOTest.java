package com.company.test.io;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/7/24.
 */
public class IOTest {
    public static void normal() throws Exception {
        long start = Calendar.getInstance().getTimeInMillis();
        FileInputStream is = new FileInputStream("D:\\image\\test.txt");
        InputStream in = is;
        BufferedReader bf = new BufferedReader(new InputStreamReader(in));
        for (int i =0;i<10;i++)
            System.out.println(bf.readLine());
        byte[] bytes = new byte[1024*10];
        is.read(bytes);
        long end = Calendar.getInstance().getTimeInMillis();
        String s = new String(bytes);
//        System.out.println(s);
        System.out.println("io use time: " + (end-start));
    }

    public static void nio() throws Exception {
        long start = Calendar.getInstance().getTimeInMillis();
        FileInputStream is = new FileInputStream("D:\\image\\test.txt");
        FileChannel fc = is.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024*10);
        fc.read(buffer);
        long end = Calendar.getInstance().getTimeInMillis();
//        String s = new String(buffer.array());
//        System.out.println(s);
        System.out.println("nio use time: " + (end-start));
    }

    public static void main(String[] args) throws Exception {
//        nio();
        normal();
    }
}
