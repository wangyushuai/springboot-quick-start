package com.example.springboot.controller;

import com.example.springboot.util.response.FangResponse;
import com.example.springboot.domain.TestTable;
import com.example.springboot.service.TestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by wangyushuai@fang.com on 2018/10/23.
 * 1. SpringBoot2.X 整合 Mybatis 3.x
 * 2. 事务处理
 * 3. demo: 增删查改（curd）及 事务处理
 */
@RestController
@RequestMapping("/mybatis/test_table")
public class  MybatisController {

    @Autowired
    TestTableService service;


    @PostMapping("/trans_add_error")
    public FangResponse testTableTransAddError(TestTable testTable) throws Exception {
        testTable.setCreateTime(new Date());
        boolean result =  service.transationAddError(testTable);
        return FangResponse.buildSuccess(result);
    }

    @PostMapping("/trans_add")
    public FangResponse testTableTransAdd(@Valid TestTable testTable, BindingResult bindingResult) throws Exception {
        testTable.setCreateTime(new Date());

        //添加模型验证类
        if (bindingResult.hasErrors()){
            return new FangResponse(400,"error",bindingResult.getFieldError().getDefaultMessage());
        }

        boolean result =  service.transationAddError(testTable);
        return FangResponse.buildSuccess(result);
    }



    @PostMapping("/add")
    public FangResponse testTableAdd(@Valid TestTable testTable) {
        testTable.setCreateTime(new Date());
        boolean result =  service.add(testTable);
        return FangResponse.buildSuccess(result);
    }


    @PostMapping("/delete")
    public FangResponse testTableDelete(@RequestParam("id")  Long id) {
        return FangResponse.buildSuccess(service.delete(id));
    }

    @PostMapping("/update")
    public FangResponse testTableUpdate(TestTable testTable) {
        return FangResponse.buildSuccess(service.update(testTable));
    }



    @GetMapping("/select_one")
    public FangResponse testTableSelectOne(@RequestParam("id") Long id) {
        TestTable testTable = service.selectOne(id);
        return FangResponse.buildSuccess(testTable);
    }


    @GetMapping("/select_all")
    public FangResponse testTableSelectAll() {
        List<TestTable> list = service.selectAll();
        return FangResponse.buildSuccess(list);
    }

    @GetMapping("/dynamic_table")
    public FangResponse testDynamicTableSelectOne(@RequestParam("id") Long id) {
        TestTable one =service.dynamicSelectOne(id,"test_table");
        return FangResponse.buildSuccess(one);
    }
}
