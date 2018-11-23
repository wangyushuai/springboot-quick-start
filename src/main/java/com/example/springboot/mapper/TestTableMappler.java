package com.example.springboot.mapper;

import com.example.springboot.domain.TestTable;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wangyushuai@fang.com on 2018/10/23.
 * Mybatis3.x 对 _local_test test_table 表的操作
 * Mybatis 语法介绍： http://www.mybatis.org/mybatis-3/zh/java-api.html
 */

@Component
public interface TestTableMappler {

    @Insert("insert into test_table(`name`,`phone`,`create_time`,`age`) values(#{name},#{phone},#{createTime},#{age})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")// key Property: 程序字段名称， KeyColumn: 数据库字段
    int insert(TestTable testTable);


    @Delete("DELETE FROM test_table WHERE id = #{id}")
    int delete(Long id);


    @Select("SELECT id,name,phone,create_time FROM test_table")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    List<TestTable> selectAll();


    @Select("SELECT id,name,phone,create_time FROM test_table WHERE id = #{id}")
    @Results({
            @Result(column = "create_time",property = "createTime")
    })
    TestTable selectOne(Long id);

    @Update("UPDATE test_table SET name = #{name} WHERE id = #{id}")
    int update(TestTable testTable);


}
