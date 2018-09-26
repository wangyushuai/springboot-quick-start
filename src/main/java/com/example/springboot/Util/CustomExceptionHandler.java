package com.example.springboot.Util;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by wangyushuai@fang.com on 2018/9/26.
 */
@RestControllerAdvice
public class CustomExceptionHandler {

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);
    //捕获全局异常，处理所有不可知的异常
    @ExceptionHandler(value = Exception.class)
    Object HanlderException(Exception ex, HttpServletRequest request) {
        LOG.error("url {},msg {}",request.getRequestURL(), ex.getMessage());
        Map<String,Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("msg", "error");
        map.put("status",ex.getMessage());
        map.put("path", request.getRequestURL());
        return map;
    }

    @ExceptionHandler(value = CustomerException.class)
    Object handlerCustomerException(Exception ex,HttpServletRequest request) {
        //此处可以添加判断请求是浏览器请求或客户端请求逻辑，可以根据不同情况返回不同内容
        ModelAndView mv = new ModelAndView("customerError.html");
        mv.addObject("title","error");
        return mv;//返回页面
    }
}
