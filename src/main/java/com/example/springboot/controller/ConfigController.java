package com.example.springboot.controller;

import com.example.springboot.Util.FangResponse;
import com.example.springboot.Util.ServerConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by wangyushuai@fang.com on 2018/10/9.
 * 测试多环境配置
 */
@RestController
public class ConfigController {
//    defaul.domain = www.fang.com
//    default.port = 8080
//    default.local = 127.0.0.1

    @Autowired
    ServerConstant serverConstant;

    /**
     *  测试多环境配置方法
     * @return
     */
//    @GetMapping("/config_app")
//    public Object get() {
//        Map<Object,Object>  hashMap = new HashMap<>();
//        hashMap.put("domain", domain);
//        hashMap.put("common",configValue);
//        hashMap.put("evn",evnConfig);
//        return FangResponse.buildSuccess(hashMap);
//    }



    @GetMapping("/config_bean")
    public Map<String,Object> testConfig() {
        Map<String,Object> map = new HashMap<>();
        map.put("domain",serverConstant.getDomain());
        map.put("port",serverConstant.getPort());
        map.put("local",serverConstant.getLocal());
        return map;
    }
}
