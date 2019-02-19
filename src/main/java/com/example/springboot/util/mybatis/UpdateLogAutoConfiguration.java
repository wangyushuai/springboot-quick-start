package com.example.springboot.util.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 *  自动配置 updateLog（记录更新日志）
 *   配置 Mybatis Plugin，
 *   将自定义的过滤器 添加至 sqlSessionFactory
 * @author wangyushuai2@jd.com
 * @date 2019/2/18
 */
@Configuration
@AutoConfigureAfter(MybatisAutoConfiguration.class)
public class UpdateLogAutoConfiguration {

    @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;


    @PostConstruct
    public void addPageInterceptor() {
        UpdateLogInterceptor interceptor = new UpdateLogInterceptor();
        for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
            sqlSessionFactory.getConfiguration().addInterceptor(interceptor);
        }
    }

}
