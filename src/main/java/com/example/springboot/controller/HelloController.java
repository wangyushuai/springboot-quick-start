package com.example.springboot.controller;

import com.example.springboot.service.TestTableService;
import com.example.springboot.util.response.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @decription 测试Http请求,API 开发 DEMO
 * Created by wangyushuai@fang.com on 2018/9/26.
 * 参考博客： https://blog.csdn.net/qq_31001665/article/details/71075743
 */

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @Autowired
    TestTableService testTableService;

    /**
     * 欢迎页，路由支持多个参数
     * @return
     */
    @GetMapping(value = {"/","/hello"})
    public RestResponse hello() {
        List<String> list = new ArrayList<>();
        list.add("hello world");
        return new RestResponse(200,"success",list);
    }

    /**
     * Restful API 接口
     */
    @GetMapping("/hello/{id}")
    public String helloDetail(@PathVariable("id") String id) {
        return "id:" + id;
    }

    @GetMapping("/welcome/{user_name}")
    public RestResponse helloUser(@PathVariable("user_name") String userName) {
        return RestResponse.buildSuccess("Welcome " + userName);
    }


    @GetMapping("/hello/request")
    public Object helloRequest(HttpServletRequest request) {
        int askId = Integer.parseInt(request.getParameter("id"));
        return RestResponse.buildSuccess(askId);
    }



    //TODO: 多种返回值类型， 如： 直接返回Map,集合等
    //TODO: 多种参数类型，如：Map 接受参数，接收参数名 和 方法参数名不一致情况
    //TODO: 实体集接收参数
    //TODO: 模型验证


}
