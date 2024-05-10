/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : ThreadDemo
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
public class ThreadDemo extends Thread{
    public ThreadDemo(String name){
        super(name);
    }
    public void run(){
        System.out.println(Thread.currentThread().getName()+"运行了run方法");
    }
}