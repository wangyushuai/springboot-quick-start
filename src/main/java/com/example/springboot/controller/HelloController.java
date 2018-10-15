package com.example.springboot.controller;

import com.example.springboot.Util.CustomerException;
import com.example.springboot.Util.FangResponse;
import com.example.springboot.Util.ServerConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @decription 测试Http请求
 * Created by wangyushuai@fang.com on 2018/9/26.
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public FangResponse hello() {
        List<String> list = new ArrayList<>();
        list.add("hello world");
        return new FangResponse(200,"success",list);
    }

    @GetMapping("/hello/{askId}")
    public String helloProduct(@PathVariable("askId") String askId) {
        return "askId:" + askId;
    }

    //TODO: 直接返回Map,集合等


}
