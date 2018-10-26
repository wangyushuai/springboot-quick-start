package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangyushuai@fang.com on 2018/10/26.
 * SpringBoot2.x 整合 Thymeleaf 框架 ( 7-4 )
 * 1. 增加依赖
 * 2. 增加配置
 * 3. 返回页面
 */

@Controller
public class ThymeleafController {

    @GetMapping("/hello_page")
    public Object helloPage() {
        return "/templates/customerError";
    }

    @GetMapping("/hello_data_page")
    public Object helloPage(ModelMap modelMap) {
        modelMap.addAttribute("hello","hello SpringBoot2.x !");
        return "tl/hello_data_page";
    }

}
