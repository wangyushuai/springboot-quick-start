package com.example.springboot.controller;

import com.example.springboot.Util.FangResponse;
import com.example.springboot.Util.ServerSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by wangyushuai@fang.com on 2018/10/9.
 * 测试多环境配置2 之  Maven Profiles
 * 需要先package打包后， 才能F5启动运行
 */
@RestController
@PropertySource({"classpath:/config/api.properties"})
public class ConfigMavenProfileController {
//    defaul.domain = www.fang.com
//    default.port = 8080
//    default.local = 127.0.0.1

    //读取api.config 文件
    @Value("${agent.product.detail.domain}")
    private String detailDomain;

    /**
     *  测试读取 api.properties
     * @return
     */
    @GetMapping("/config_api_get")
    public Object get() {
        Map<Object,Object>  hashMap = new HashMap<>();
        hashMap.put("detailDomain", detailDomain);
        return FangResponse.buildSuccess(hashMap);
    }



}
