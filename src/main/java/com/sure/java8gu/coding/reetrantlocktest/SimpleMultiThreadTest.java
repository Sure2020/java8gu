/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : SimpleMultiThreadTest
 * Date Created : 2024-05-06
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-05-06       Admin     xxx
 * --------------------------------------------------------------------
 */

package com.sure.java8gu.coding.reetrantlocktest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: coding.reetrantlocktest
 * @description: xxx
 * @author: Admin
 * @create: 2024-05-06
 **/
public class SimpleMultiThreadTest {
    public static void main(String[] args) {
        System.out.println("testing");
        Thread thread1 = new Thread(new myprint(), "a");
        Thread thread2 =  new Thread(new myprint(), "b");
        Thread thread3 =  new Thread(new myprint(), "c");
        Thread thread4 =  new Thread(new myprint(), "d");
        Thread thread5 =  new Thread(new myprint(), "e");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
    static class myprint implements Runnable{
        Lock lock = new ReentrantLock();
        @Override
        public void run() {
            try {
                lock.lock();
                for(int i =0; i<3;i++){
                    System.out.println(Thread.currentThread().getName() + "   " +i);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }


    }
}