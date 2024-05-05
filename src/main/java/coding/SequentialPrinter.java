/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : SequentialPrinter
 * Date Created : 2024-05-03
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-05-03       Admin     xxx
 * --------------------------------------------------------------------
 */

package coding;

/**
 * @program: coding
 * @description: xxx
 * @author: Admin
 * @create: 2024-05-03
 **/
/**
 * 使用wait notify
 * @author Hollis
 */
public class SequentialPrinter {
    private static Integer number = 1;
    private static Integer MAX_NUMBER=100;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        System.out.println("testing");
        Thread print1Thread = new Thread(new print1());
        Thread print2Thread = new Thread(new print2());
        //这里run要写成start，调用Thread 的run方法只是调用普通方法，调start方法才是启动了一个线程
        /*print1Thread.run();
        print2Thread.run();*/
        print1Thread.start();
        print2Thread.start();
    }

    //这里要写成类，而不是方法
    public static class print1 implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                while(number<=MAX_NUMBER){
                    if(number%2==1){
                        System.out.println(number);
                        number++;
                        lock.notify();
                    }else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    /*if(number%2!=1){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        System.out.println(number);
                        number++;
                        lock.notify();
                    }*/
                }
            }
        }
    }
    public static class print2 implements Runnable {
        @Override
        public void run() {
            synchronized (lock){
                while(number<=MAX_NUMBER){
                    if(number%2==0){
                        System.out.println(number);
                        number++;
                        lock.notify();
                    }else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    /*if(number%2!=0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        System.out.println(number);
                        number++;
                        lock.notify();
                    }*/
                }
            }
        }
    }
}
