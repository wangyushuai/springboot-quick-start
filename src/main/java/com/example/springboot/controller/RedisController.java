package com.example.springboot.controller;

import com.example.springboot.util.response.RestResponse;
import com.example.springboot.util.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
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
    public RestResponse getOptsForValue(String key) {
        return RestResponse.buildSuccess(redisClient.get(key));
    }

    @RequestMapping("/set_value")
    public RestResponse setOptsForValue(String key , String value) {
        return RestResponse.buildSuccess(redisClient.set(key,value));
    }


}
