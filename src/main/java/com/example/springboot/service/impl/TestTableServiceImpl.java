package com.example.springboot.service.impl;

import com.example.springboot.mapper.TestTableMappler;
import com.example.springboot.domain.TestTable;
import com.example.springboot.service.TestTableService;
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
    public boolean transationAddError(TestTable testTable) throws Exception {
        testTable.setName("服务异常，未使用事务");
        int result = testTableMappler.insert(testTable);
        //模拟服务异常的例子
        throw new Exception();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean transationAdd(TestTable testTable) throws Exception {
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
}
