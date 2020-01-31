package com.example.springboot.service;

/**
 * 聚合服务场景
 * 此Service 中含有DB操作，请求API操作，以及复合操作
 * 我们的单元测试将覆盖以上几种常见的工作场景
 * @author wangyushuai2@jd.com
 * @date 2019/8/5
 */
public interface TestManagerService {
    /**
     * 假设聚合方法
     * 方法逻辑如下：
     * 拿id 读取数据查询，获取到name之后，拿name 调HelloDetail 方法。
     * @param id testTable -> id
     * @return
     */
    boolean fun(Long id);
}
