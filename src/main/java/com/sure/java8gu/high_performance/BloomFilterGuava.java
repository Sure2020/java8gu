/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : BloomFilterGuava
 * Date Created : 2024-03-15
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-15       Admin     xxx
 * --------------------------------------------------------------------
 */

package com.sure.java8gu.high_performance;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * @program: com.sure.java8gu.high_performance
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-15
 **/
public class BloomFilterGuava {
    public static void main(String[] args) {
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()),100,0.01);
        bloomFilter.put("Hollis");
        bloomFilter.put("666");
        bloomFilter.put("八股文");
        System.out.println(bloomFilter.mightContain("Hollis"));
        System.out.println(bloomFilter.mightContain("wfs"));
    }
}