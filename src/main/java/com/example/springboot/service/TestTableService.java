package com.example.springboot.service;

import com.example.springboot.domain.TestTable;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * DB 操作场景
 * Created by wangyushuai@fang.com on 2018/10/23.
 */
public interface TestTableService {

    /**
     * 添加，未使用使用事务处理
     * @param testTable
     * @return
     */
    boolean transactionAddError(TestTable testTable) throws Exception;

    /**
     * 事务处理，事务添加
     * @param testTable
     * @return
     */
    boolean transactionAdd(TestTable testTable) throws Exception;

    /**
     * 新增数据
     * @param testTable
     * @return
     */
    boolean add(TestTable testTable);

    /**
     * 删除数据
     * @param id
     * @return
     */
    boolean delete(Long id);

    /**
     * 更新数据
     * @param testTable
     * @return
     */
    boolean update(TestTable testTable);

    /**
     * 查询数据
     * @return
     */
    List<TestTable> selectAll();

    /**
     * 查询打个数据
     * @return
     */
    TestTable selectOne(Long id);

    /**
     * 动态传递表名查询
     * @return
     */
    TestTable dynamicSelectOne(Long id,String tableName);


    /**
     *  分页查询
     *  基于 mybatis PageHelper
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<TestTable> selectByPage(int pageNum, int pageSize);

}
