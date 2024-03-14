/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : MultiThreadTest
 * Date Created : 2024-03-14
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-14       Admin     xxx
 * --------------------------------------------------------------------
 */

package com.sure.java8gu.high_performance;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: com.sure.java8gu.high_performance
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-14
 **/
public class MultiThreadTest {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-%d").build();
        ExecutorService executor = new ThreadPoolExecutor(2, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), threadFactory);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world !");
            }
        });
        System.out.println(" ===> main Thread! " );
    }
}