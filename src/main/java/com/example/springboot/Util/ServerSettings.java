package com.example.springboot.Util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by wangyushuai@fang.com on 2018/9/26.
 * 1. Component Spring自动扫描，加入声明周期；PropertySource 规定来源； ConfigurationProperties 规定前缀
 * 2. 属性名和配置名对应，则自动映射
 * 3. 若属性名和配置字段名不一致，请使用@Value注解帮助映射， 如： evn.config
 */

@Component
@PropertySource({"classpath:application.properties"})
@ConfigurationProperties(prefix = "default")
public class ServerSettings {
//    defaul.domain = www.fang.com
//    default.port = 8080
//    default.local = 127.0.0.1

    private String domain;
    private int port;
    private String local;

    @Value("${evn.config}")
    private String evnConfig;

    public String getEvnConfig() {
        return evnConfig;
    }

    public void setEvnConfig(String evnConfig) {
        this.evnConfig = evnConfig;
    }



    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
