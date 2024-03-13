/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : A
 * Date Created : 2024-03-13
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-13       Admin     xxx
 * --------------------------------------------------------------------
 */

package com.sure.java8gu.high_performance;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Application {
    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask =
                new FutureTask<String>(new RealData("name"));
        ExecutorService executor =
                Executors.newFixedThreadPool(1); //使用线程池
        //执行FutureTask，相当于上例中的client.request("name")发送请求
        executor.submit(futureTask);
        //这里可以用一个sleep代替对其他业务逻辑的处理
        //在处理这些业务逻辑过程中，RealData也正在创建，从而充分了利用等待时间
        Thread.sleep(2000);
        //使用真实数据
        //如果call()没有执行完成依然会等待
        System.out.println("数据=" + futureTask.get());
    }
}