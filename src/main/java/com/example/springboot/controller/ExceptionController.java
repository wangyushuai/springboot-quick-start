package com.example.springboot.controller;

import com.example.springboot.util.exception.CustomerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangyushuai@fang.com on 2018/10/15.
 * 异常处理Demo
 */

@RestController
public class ExceptionController {

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
