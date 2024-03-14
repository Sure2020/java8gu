/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : NioTest
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: com.sure.java8gu.high_performance
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-14
 **/
public class NioTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("d:\\temp\\temp.txt");
        //获取通道
        FileChannel fc = fin.getChannel();
        //创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //读取数据到缓冲区
        fc.read(buffer);
        buffer.flip();
        while(buffer.remaining()>0){
            byte b = buffer.get();
            System.out.println((char) b);
        }
        fin.close();
    }
}