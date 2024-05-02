/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : RedisGeoDemo
 * Date Created : 2024-04-03
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-04-03       Admin     xxx
 * --------------------------------------------------------------------
 */

package com.sure.java8gu.redis;

/**
 * @program: redis
 * @description: xxx
 * @author: Admin
 * @create: 2024-04-03
 **/

import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.stream.Collectors;

public class RedisGeoDemo {

    private static final String USER_LOCATION_KEY = "user_location";

    // 存储用户经纬度信息
    public static void saveUserLocation(String userId, double longitude, double latitude, Jedis jedis) {
        jedis.geoadd(USER_LOCATION_KEY, longitude, latitude, userId);
    }

    // 查询附近的人
    public static List<String> getNearbyUsers(double longitude, double latitude, double radius, Jedis jedis) {
        List<GeoRadiusResponse> responses = jedis.georadius(USER_LOCATION_KEY, longitude, latitude, radius, GeoUnit.KM);
        return responses.stream().map(GeoRadiusResponse::getMemberByString).collect(Collectors.toList());
    }
}