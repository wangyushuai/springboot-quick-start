package com.example.springboot.service.impl;

import com.example.springboot.domain.TestTable;
import com.example.springboot.service.TestTableService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * 读写数据库单元测试场景
 * 由于我们的TestTableService 直接调用了Mapper,故此处我们直接基于Service 进行单元测试
 * 这个场景需要保证数据正常连接（否则数据库连接池无法完成初始化）
 * @author wangyushuai2@jd.com
 * @date 2019/8/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTableServiceImplTest {

    @Autowired
    TestTableService testTableService;

    /**
     * 测试写入的参数
     */
    private TestTable testTable;

    /**
     * 每个测试方法执行前，将执行此方法
     */
    @Before
    public void setUp() {
        // 完成对测试参数的初始化
        testTable = new TestTable();
        testTable.setName("unit_test");
        testTable.setAge(18);
        testTable.setPhone("1234567890");
        testTable.setCreateTime(new Date());
    }

    /**
     * 对数据库的添加操作进行单元测试
     * 测试逻辑如下：
     * 调用Add方法，写入一条数据
     * 调用查询方法，判断是否写入成功
     * 注解@Transactional作用为： 单元测试方法体结束后，将进行数据回滚，不会产生脏数据（数据库写入单元测试的必备良选）
     */
    @Transactional
    @Test
    public void add() {
        // 写入,写入成功后，主键Id将对testTable 赋值
        testTableService.add(testTable);
        // 读取（此处应该基于selectOne正确情况下）
        TestTable writeResult = testTableService.selectOne(testTable.getId());
        Assert.assertNotNull("写入操作是否成功",writeResult);
        Assert.assertEquals("写入操作是否成功",testTable.getName(),writeResult.getName());
    }
}