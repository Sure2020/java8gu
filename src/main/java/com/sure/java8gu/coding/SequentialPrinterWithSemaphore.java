/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : SequentialPrinterWithSemaphore
 * Date Created : 2024-05-05
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-05-05       Admin     xxx
 * --------------------------------------------------------------------
 */

package com.sure.java8gu.coding;

import java.util.concurrent.Semaphore;

/**
 * @program: coding
 * @description: xxx
 * @author: Admin
 * @create: 2024-05-05
 **/
public class SequentialPrinterWithSemaphore {
    static Semaphore print1Semaphore = new Semaphore(1);
    static Semaphore print2Semaphore = new Semaphore(0);
    static private int MAX_NUMBER = 100;
    static private volatile int number = 1;

    public static void main(String[] args) {
        System.out.println("testing");
        Thread print1Thread = new Thread(new print1());
        //这里将print2写成了print1，小失误，用肉眼看出来了
        Thread print2Thread = new Thread(new print2());
        print1Thread.start();
        print2Thread.start();
    }



    static class print1 implements Runnable{

        @Override
        public void run() {
            try {
                // 【关键】acquire不能写到while里面，因为多线程在运行，如果过了number<=MAX_NUMBER这个限制后，下一步等待semaphore的到来，其到来后，可能number已经不满足number<=MAX_NUMBER这个限制，导致多打印一个数字
                // 补充：事实证明acquire写到while外面也会出现打印101的情况，最后将number<=MAX_NUMBER去掉等于号，就可以了，原因未知！！！

                // 最后补充，两个关键，1.acquire要在while里面，2.number<MAX_NUMBER不能用等于号，原因尚未研究明白，先记一下吧
                while(number<MAX_NUMBER){
                    print1Semaphore.acquire();
                    if(number%2==1){
                        System.out.println(number);
                        number++;
                        //print2Semaphore.release();
                    }
                    print2Semaphore.release();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
    static class print2 implements Runnable{

        @Override
        public void run() {
            try {

                //在调整代码时，把while循环调没了，后来又加上了，粗心了呗

                while(number<MAX_NUMBER){
                    print2Semaphore.acquire();
                    if(number%2==0){
                        System.out.println(number);
                        number++;
                        //print1Semaphore.release();
                    }
                    print1Semaphore.release();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}