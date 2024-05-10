/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : TestRun
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

package com.sure.java8gu.coding.DiffBetweenRunAndStart;

/**
 * @program: coding
 * @description: xxx
 * @author: Admin
 * @create: 2024-05-03
 **/
public class TestRun {
    public static void main(String[] args) {
        Thread mythread = new ThreadDemo("TestMyThread");
        //main
        System.out.println(Thread.currentThread().getName()+"将要调用mythread.run()");
        mythread.run();
        System.out.println(Thread.currentThread().getName()+"将要调用mythread.start()");
        mythread.start();
    }
}