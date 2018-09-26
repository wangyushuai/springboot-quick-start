package com.example.springboot.Util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by wangyushuai@fang.com on 2018/9/26.
 */

@Component
@PropertySource({"classpath:/config/config.properties","classpath:/config/server.properties"})
@ConfigurationProperties(prefix = "ask")
public class ServerConstant {
    @Value("${ask.server}")
    private String serverUrl;
    private int port;
    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }




    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
