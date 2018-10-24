package com.example.springboot.service.impl;

import com.example.springboot.mapper.TestTableMappler;
import com.example.springboot.pojo.TestTable;
import com.example.springboot.service.TestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangyushuai@fang.com on 2018/10/23.
 * 对 TestTable 逻辑
 */

@Service
public class TestTableServiceImpl implements TestTableService {

    @Autowired
    TestTableMappler testTableMappler;

    @Override
    public int add(TestTable testTable) {
        int result =  testTableMappler.insert(testTable);
        return result;
    }
}
