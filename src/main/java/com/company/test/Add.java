package com.company.test;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Administrator on 2016/7/25.
 */
public class Add {
    public static void add() {
        p++;
    }
    AtomicLong aLong = new AtomicLong(0);

    public void add1() {
        aLong.incrementAndGet();
    }
//    private static int num;
//    private static boolean flag;
//    private static class MyThread extends Thread {
//        @Override
//        public void run() {
//            while (!flag) {
//                Thread.yield();
//            }
//            System.out.println(num);
//        }
//    }
    public static void main(String[] args) throws InterruptedException {

//        num = 1;
//        flag = true;
//        new MyThread().start();
//        System.out.println("hello");
//        for (int i=0;i<10000;i++) {
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    add();
//                }
//            });
//            thread.start();
//        }
//        Thread.sleep(2000);
//        System.out.println("p: " + p);
//    }
        /**
         * @corePoolSize 线程池维护的线程最小数量
         * @maximumPoolSize 线程池维护的线程最大数量
         * @keepAliveTime 线程池维护线程所允许的空闲时间
         * @unit keepAliveTime的时间单位
         * @workQueue 线程池缓存队列
         * */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for (int i=0;i<1000;i++)
            executor.execute(new MyThread());
        executor.submit(new MyThread());
        executor.shutdown();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("p:" + p);

    }
    public static int p = 0;
    public static class MyThread implements Runnable {
        @Override
        public void run() {
            synchronized (this) {
                p++;
            }
        }
    }
}
