package com.example.springboot.pojo;

import java.util.Date;

/**
 * Created by wangyushuai@fang.com on 2018/10/23.
 * _local_test test_table 表对应的实体集
 */
public class TestTable {
    private Long id;

    private String name;

    private String phone;

    private int age;
    
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}