/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : InternDemo
 * Date Created : 2024-01-10
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-01-10       Admin     xxx
 * --------------------------------------------------------------------
 */

package com.sure.java8gu.javabasic;

import java.util.Random;

/**
 * @program: com.sure.java8gu.javabasic
 * @description: xxx
 * @author: Admin
 * @create: 2024-01-10
 **/
public class InternDemo {
    public static void main(String[] args) {

        // https://www.yuque.com/hollis666/bh8k7o/yr32wu44yxt5l8nh
        // #########################################################################
        /*String s1 = new String("a");
        s1.intern();
        String s2 = "a";
        System.out.println(s1 == s2); // false
        System.out.println(s1.intern() == s2); // true

        String s3 = new String("a") + new String("a");
        s3.intern();
        String s4 = "aa";
        System.out.println(s3 == s4);// true*/

        /*String s = "aa";// ①
        String s3 = new String("a") + new String("a");// ②
        s3.intern();// ③
        String s4 = "aa";
        System.out.println(s3 == s4);// ④*/

        /*String s3 = new String("1") + new String("1");// ①
        s3.intern();// ②
        String s4 = "11";
        System.out.println(s3 == s4);// ③*/

        /*String s3 = new String("3") + new String("3");// ①
        s3.intern();// ②
        String s4 = "33";
        System.out.println(s3 == s4);// ③*/

        // https://blog.csdn.net/SEU_Calvin/article/details/52291082
        /*String str1 = new String("SEU")+ new String("Calvin");
        System.out.println(str1.intern() == str1);//true
        System.out.println(str1 == "SEUCalvin");//true*/

        /*String str2 = "SEUCalvin";//新加的一行代码，其余不变
        String str1 = new String("SEU")+ new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");*/

        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

    // https://blog.csdn.net/SEU_Calvin/article/details/52291082
    /*static final int MAX = 100000;
    static final String[] arr = new String[MAX];

    public static void main(String[] args) throws Exception {
        //为长度为10的Integer数组随机赋值
        Integer[] sample = new Integer[10];
        Random random = new Random(1000);
        for (int i = 0; i < sample.length; i++) {
            sample[i] = random.nextInt();
        }
        //记录程序开始时间
        long t = System.currentTimeMillis();
        //使用/不使用intern方法为10万个String赋值，值来自于Integer数组的10个数
        for (int i = 0; i < MAX; i++) {
            //arr[i] = new String(String.valueOf(sample[i % sample.length]));
            arr[i] = new String(String.valueOf(sample[i % sample.length])).intern();
        }
        System.out.println((System.currentTimeMillis() - t) + "ms");
        System.gc();
    }*/
}