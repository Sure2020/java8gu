/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : RealData
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

import java.util.concurrent.Callable; /**
 * @program: com.sure.java8gu.high_performance
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-13
 **/
public class RealData implements Callable<String> {
    protected String data;
    public RealData(String data) {
        this.data = data;
    }
    @Override
    public String call() throws Exception {
        //利用sleep方法来表示真是业务是非常缓慢的
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return data;
    }
}