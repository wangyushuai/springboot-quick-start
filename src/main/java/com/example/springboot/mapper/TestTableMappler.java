package com.example.springboot.mapper;

import com.example.springboot.pojo.TestTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * Created by wangyushuai@fang.com on 2018/10/23.
 * Mybatis3.x 对 _local_test test_table 表的操作
 * Mybatis 语法介绍： http://www.mybatis.org/mybatis-3/zh/java-api.html
 */
public interface TestTableMappler {

    @Insert("insert into test_table(`name`,`phone`,`create_time`,`age`) values(#{name},#{phone},#{createTime},#{age})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(TestTable testTable);
}
