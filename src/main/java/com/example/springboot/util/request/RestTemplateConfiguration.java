package com.example.springboot.util.request;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 自定义RestTemplate
 * @Configuration SpringBoot 将扫描含有该注解的类
 * @author wangyushuai2@jd.com
 * @date 2019/8/4
 */
@Configuration
public class RestTemplateConfiguration {
    /**
     * 定义Bean， 初始化RestTemplate将从这个方法中获取 RestTemplate 对象
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        // 默认
        return new RestTemplate();
    }


}
