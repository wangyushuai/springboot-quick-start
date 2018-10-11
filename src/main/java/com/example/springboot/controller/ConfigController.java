package com.example.springboot.controller;

import com.example.springboot.Util.FangResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by wangyushuai@fang.com on 2018/10/9.
 * 测试多环境配置
 */
@RestController
@RequestMapping("/config")
@PropertySource("classpath:application.properties")
public class ConfigController {

    @Value("${server.domain}")
    private String value;

    /**
     *  测试多环境配置方法
     * @return
     */
    @RequestMapping("/get")
    public Object get() {
        return FangResponse.buildSuccess(value);
    }
}
