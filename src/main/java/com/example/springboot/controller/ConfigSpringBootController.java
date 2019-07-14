package com.example.springboot.controller;

import com.example.springboot.util.response.RestResponse;
import com.example.springboot.util.config.ServerSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyushuai@fang.com on 2018/10/22.
 * SpringBoot 多环境配置2 之 SpringBoot 多环境配置
 * 读取 application.properties 测试，测试F5直接启动是否生效
 */
@RestController
public class ConfigSpringBootController {

    @Autowired
    ServerSettings serverSetting;

    @Value("${server.domain}")
    private String appServer;

    /**
     * 读取配置文件指定字段
     * @return
     */
    @GetMapping("/config_app")
    public Object getAppConfig() {
        return RestResponse.buildSuccess(appServer);
    }

    /**
     * 测试配置文件自动映射实体集
     * @return
     */
    @GetMapping("/config_bean")
    public Map<String,Object> testConfig() {
        Map<String,Object> map = new HashMap<>();
        map.put("domain", serverSetting.getDomain());
        map.put("port", serverSetting.getPort());
        map.put("local", serverSetting.getLocal());
        map.put("evn_config", serverSetting.getEvnConfig());
        return map;
    }
}
