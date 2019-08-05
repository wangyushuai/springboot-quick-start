package com.example.springboot.service.impl;

import com.example.springboot.service.TestRequestApiService;
import com.example.springboot.util.response.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 远程请求API场景
 * @author wangyushuai2@jd.com
 * @date 2019/8/4
 */
@Service
public class TestRequestApiServiceImpl implements TestRequestApiService {

    @Autowired
    RestTemplate restTemplate;
    /**
     * 请求本地HelloController的 helloDetail /hello/id 方法
     *
     * @param userName
     * @return
     */
    @Override
    public String getHelloDetail(String userName) {
        restTemplate.getForObject(TestRequestApiService.URL_HELLO_DETAIL.replace("{user_name}",userName),
                RestResponse.class);
        return null;
    }
}
