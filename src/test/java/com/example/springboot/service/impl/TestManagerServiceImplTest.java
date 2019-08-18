package com.example.springboot.service.impl;

import com.example.springboot.domain.TestTable;
import com.example.springboot.service.TestRequestApiService;
import com.example.springboot.service.TestTableService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;

/**
 * 测试聚合服务的场景
 * @author wangyushuai2@jd.com
 * @date 2019/8/5
 */
@RunWith(SpringRunner.class)
public class TestManagerServiceImplTest {
    /**
     * Mock TestTable Service 服务
     */
    @Mock
    TestTableService testTableService;

    /**
     * Mock TestRequestApiService
     */
    @Mock
    TestRequestApiService testRequestApiService;

    /**
     * 将Mock 注入我们要测试的服务
     * 注意： @InjectMocks 要使用非抽象方法
     */
    @InjectMocks
    TestManagerServiceImpl testManagerService;

    @Test
    public void fun() {
        TestTable obj = new TestTable();
        obj.setName("unit_test");
        given(testTableService.selectOne(anyLong())).willReturn(obj);
        given(testRequestApiService.getHelloDetail(anyString())).willReturn("Welcome unit_test");
        // 上面我们对Manager依赖的服务，进行了Mock， 在此种条件下，我们测试的方法应该返回 true
        // 故我们断言如下
        Assert.assertTrue("聚合服务fun方法正常情况",testManagerService.fun(1L));
        //TODO: 其他错误或异常情况，读者可以自行扩展，在此不展开，欢迎大家提问交流
    }
}