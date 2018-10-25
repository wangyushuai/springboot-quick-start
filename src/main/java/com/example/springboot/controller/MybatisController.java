package com.example.springboot.controller;

import com.example.springboot.Util.FangResponse;
import com.example.springboot.pojo.TestTable;
import com.example.springboot.service.TestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by wangyushuai@fang.com on 2018/10/23.
 * SpringBoot2.X 整合 Mybatis 3.x
 * 事务处理
 */
@RestController
public class MybatisController {

    @Autowired
    TestTableService service;

    @PostMapping("/test_table_add")
    public Object testTableAdd(@Valid TestTable testTable) {
       testTable.setCreateTime(new Date());
       int result =  service.add(testTable);
       return FangResponse.buildSuccess(result);
    }



}
