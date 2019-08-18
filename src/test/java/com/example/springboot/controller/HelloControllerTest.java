package com.example.springboot.controller;

import com.example.springboot.domain.TestTable;
import com.example.springboot.service.TestTableService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import javax.validation.constraints.NotNull;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 控制器单元测试
 * @author wangyushuai2@jd.com
 * @date 2019/8/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TestTableService testTableService;

    @Before
    public void setUp() throws Exception {
        // mock 数据库查询
        TestTable mockTestTable = new TestTable();
        mockTestTable.setName("unitTest");
        BDDMockito.given(testTableService.selectOne(anyLong())).willReturn(mockTestTable);
    }

    @Test
    public void helloDetail() throws Exception {

        String testRequestPath = "/api/v1/hello/1";
        mockMvc.perform(get(testRequestPath)
                .contentType(MediaType.APPLICATION_JSON)// 设置ContentType
                //.header()
                .content("{}") // 设置Body
                .accept(MediaType.TEXT_PLAIN)
        ).andExpect(status().isOk()) // 断言请求状态
                .andExpect( c -> assertNotNull(c.getResponse().toString())) // 自定义ResultMatcher语法
                .andExpect(content().string("unitTest"))// 直接对结果进行比较
        ;
    }


}