package com.example.springboot.controller;

import com.example.springboot.Util.FangResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by wangyushuai@fang.com on 2018/10/9.
 * 测试多环境配置
 */
@RestController
@PropertySource("classpath:application.properties")
public class ConfigController {

    @Value("${server.domain}")
    private String value;

    @Value("${common.config}")
    private String configValue;

    /**
     *  测试多环境配置方法
     * @return
     */
    @GetMapping("config_get")
    public Object get() {
        Map<Object,Object>  hashMap = new HashMap<>();
        hashMap.put("environment",value);
        hashMap.put("common",configValue);
        return FangResponse.buildSuccess(hashMap);
    }
}
