package com.example.springboot.controller;

import com.example.springboot.util.response.RestResponse;
import com.example.springboot.domain.TestTable;
import com.example.springboot.service.TestTableService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangyushuai@fang.com on 2018/10/23.
 * 1. SpringBoot2.X 整合 Mybatis 3.x
 * 2. 事务处理
 * 3. demo: 增删查改（curd）及 事务处理
 */
@RestController
@RequestMapping("/mybatis/test_tables")
public class  MybatisController {

    @Autowired
    TestTableService service;


    @PostMapping("/trans_add_error")
    public RestResponse testTableTransAddError(TestTable testTable) throws Exception {
        testTable.setCreateTime(new Date());
        boolean result =  service.transationAddError(testTable);
        return RestResponse.buildSuccess(result);
    }

    @PostMapping("/trans_add")
    public RestResponse testTableTransAdd(@Valid TestTable testTable, BindingResult bindingResult) throws Exception {
        testTable.setCreateTime(new Date());

        //添加模型验证类
        if (bindingResult.hasErrors()){
            return new RestResponse(400,"error",bindingResult.getFieldError().getDefaultMessage());
        }

        boolean result =  service.transationAddError(testTable);
        return RestResponse.buildSuccess(result);
    }



    @PostMapping("/add")
    public RestResponse testTableAdd(@Valid TestTable testTable) {
        testTable.setCreateTime(new Date());
        boolean result =  service.add(testTable);
        return RestResponse.buildSuccess(result);
    }


    @Delete("/delete")
    public RestResponse testTableDelete(@RequestParam("id")  Long id) {
        return RestResponse.buildSuccess(service.delete(id));
    }

    @PutMapping("/update")
    public RestResponse testTableUpdate(TestTable testTable) {
        return RestResponse.buildSuccess(service.update(testTable));
    }



    @GetMapping("/select_one")
    public RestResponse testTableSelectOne(@RequestParam("id") Long id) {
        TestTable testTable = service.selectOne(id);
        return RestResponse.buildSuccess(testTable);
    }


    @GetMapping("/select_all")
    public RestResponse testTableSelectAll() {
        List<TestTable> list = service.selectAll();
        return RestResponse.buildSuccess(list);
    }

    @GetMapping("/dynamic_table")
    public RestResponse testDynamicTableSelectOne(@RequestParam("id") Long id) {
        TestTable one =service.dynamicSelectOne(id,"test_table");
        return RestResponse.buildSuccess(one);
    }


    @GetMapping("/select_all_page")
    public RestResponse testTableByPage(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                        @RequestParam(value = "pageSize",required = false,defaultValue = "2") int pageSize) {
        PageInfo<TestTable> pageInfo = service.selectByPage(pageNum,pageSize);
        Map<String,Object> result = new HashMap<>();
        result.put("list",pageInfo.getList());
        result.put("total",pageInfo.getTotal());
        return RestResponse.buildSuccess(result);
    }

}
