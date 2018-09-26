package com.example.springboot.controller;

import com.example.springboot.Util.CustomerException;
import com.example.springboot.Util.FangResponse;
import com.example.springboot.Util.ServerConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @decription 测试Http请求
 * Created by wangyushuai@fang.com on 2018/9/26.
 */

@RestController
@PropertySource({"classpath:/config/config.properties"})
public class HelloController {
//    @Value("${test.server}")
//    private String server;
//    @Value("${test.port}")
//    private String port;

    @Autowired
    ServerConstant serverConstant;

    @GetMapping("/hello")
    public FangResponse hello() {
        List<String> list = new ArrayList<>();
        list.add("hello world");
        return new FangResponse(200,"success",list);
    }


    @GetMapping("/test_config/")
    public Map<String,Object> testConfig(@RequestParam(value = "id") Integer testId) {
        Map<String,Object> map = new HashMap<>();
        map.put("test_id",testId);
        map.put("server",serverConstant.getServerUrl());
        map.put("port",serverConstant.getPort());
        map.put("searchUrl",serverConstant.getSearch());
        return map;
    }

    @GetMapping("/test_error")
    public void testError() {
        int a= 1;
        int b = 0;
        double c = a/b;
    }

    @GetMapping("/test_ex_hanlder")
    public void testExceptionHandler() throws CustomerException {
        throw new CustomerException();
    }
}
