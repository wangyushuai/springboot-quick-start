package com.example.springboot.service.impl;

import com.example.springboot.domain.TestTable;
import com.example.springboot.mapper.TestTableMappler;
import com.example.springboot.service.TestTableService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangyushuai@fang.com on 2018/10/23.
 * 对 TestTable 逻辑
 */

@Service
public class TestTableServiceImpl implements TestTableService {

    @Autowired
    TestTableMappler testTableMappler;

    @Override
    public boolean transactionAddError(TestTable testTable) throws Exception {
        testTable.setName("服务异常，未使用事务");
        int result = testTableMappler.insert(testTable);
        //模拟服务异常的例子
        throw new Exception();
    }

    /**
     * 模拟异常的情况，查看回滚状况
     * propagation: 事务隔离策略（级别），模式使用数据库默认，如Mysql为 可重复读
     * rollbackFor: 规定什么情况下回滚
     * @param testTable
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public boolean transactionAdd(TestTable testTable) throws Exception {
        testTable.setName("服务异常,使用事务");
        testTableMappler.insert(testTable);
        throw  new Exception(); //模拟服务异常
    }

    @Override
    public boolean add(TestTable testTable) {
        int result =  testTableMappler.insert(testTable);
        return result > 0;
    }

    @Override
    public boolean delete(Long id) {
        return testTableMappler.delete(id) > 0;
    }

    @Override
    public boolean update(TestTable testTable) {
        return testTableMappler.update(testTable) > 0;
    }

    @Override
    public List<TestTable> selectAll() {
        return testTableMappler.selectAll();
    }

    @Override
    public TestTable selectOne(Long id) {
        return testTableMappler.selectOne(id);
    }

    @Override
    public TestTable dynamicSelectOne(Long id, String tableName) {
        return testTableMappler.dynamicSelectOne(id,tableName);
    }

    /**
     * 分页查询
     * 基于 mybatis PageHelper
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<TestTable> selectByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<TestTable>  pageInfo = new PageInfo<>(testTableMappler.selectAll());
        return pageInfo;
    }
}
