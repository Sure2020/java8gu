/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : XXX
 * Module Name  : RedisLikeDemo
 * Date Created : 2024-03-25
 * Creator      : Admin
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2024-03-25       Admin     xxx
 * --------------------------------------------------------------------
 */

package com.sure.java8gu.scene;

/**
 * @program: com.sure.java8gu.scene
 * @description: xxx
 * @author: Admin
 * @create: 2024-03-25
 **/
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.ZParams;

    import java.util.List;
    import java.util.stream.Collectors;

/**
     * @author Hollis
     **/
    public class RedisLikeDemo {
        private static final String LIKE_PREFIX = "like:";
        private static final String USER_PREFIX = "user:";

        //点赞
        public static void likePost(String postId, String userId, Jedis jedis) {
            String key = LIKE_PREFIX + postId;
            Long now = System.currentTimeMillis();
            jedis.zadd(key, now.doubleValue(), userId);// 将用户ID及当前时间戳加入有序集合
        }

        //取消点赞
        public static void unlikePost(String postId, String userId, Jedis jedis) {
            String key = LIKE_PREFIX + postId;
            jedis.zrem(key, userId);// 将用户ID从有序集合中移除
        }

        //查看点赞列表
        public List<String> getLikes(String postId, Jedis jedis) {
            String key = LIKE_PREFIX + postId;
//            ZParams zParams = new ZParams().desc();
            ZParams zParams = new ZParams();
            return jedis.zrangeByScoreWithScores(key, "+inf", "-inf")
                    .stream()
                    .map(tuple -> {
                        String userId = tuple.getElement();
                        return userId;
                    }).collect(Collectors.toList());
        }
    }
