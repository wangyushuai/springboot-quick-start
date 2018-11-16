package com.example.springboot.controller;

import com.example.springboot.Util.FangResponse;
import com.example.springboot.Util.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangyushuai@fang.com on 2018/10/31.
 * SpringBoot2.x 整合Redis 4.x
 * 1. 增加依赖
 * 2. 增加配置
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    RedisClient redisClient;

    @RequestMapping("/get_value")
    public FangResponse  getOptsForValue(String key) {
        return FangResponse.buildSuccess(redisClient.get(key));
    }

    @RequestMapping("/set_value")
    public FangResponse setOptsForValue(String key ,String value) {
        return FangResponse.buildSuccess(redisClient.set(key,value));
    }


}
