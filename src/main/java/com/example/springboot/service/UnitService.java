package com.example.springboot.service;

import com.example.springboot.domain.TestTable;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 模拟一些单元测试场景
 * 如：请求API, 查询数据库
 * @author wangyushuai2@jd.com
 * @date 2019/8/4
 */
public interface UnitService {
    /**
     * 分页查询数据
     * @param pageNum 分页号
     * @param pageSize 分页容量
     * @return
     */
    PageInfo<TestTable> listTestData(int pageNum, int pageSize);



}
