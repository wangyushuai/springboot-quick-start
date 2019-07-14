package com.example.springboot.controller;

import com.example.springboot.util.response.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangyushuai@fang.com on 2018/10/12.
 * SpringBoot整合常见业务场景 —— Logback 日志处理
 */

@RestController
@RequestMapping("/log/")
public class LogController {

    private Logger logger  = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/print")
    private Object consolePrint() {
        logger.debug("this is a debug");
        logger.info("this is a info");
        logger.warn("this is a warn");
        logger.error("this is a error");
        return RestResponse.buildSuccess(null);
    }
}
