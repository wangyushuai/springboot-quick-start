package com.example.springboot.util.mybatis;

import com.example.springboot.util.json.JsonUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * mybatis拦截器
 * 1. 业务场景：，记录用户敏感操作，记录新增，删除，更新操作
 * 2. 原理： 基于 mybatis plugins(mybatis 拦截器,org.apache.ibatis.plugin.Interceptor)实现
 * @author wangyushuai2@jd.com
 * @date 2019/2/18
 */

@Intercepts({@Signature(method = "update", type = Executor.class, args = {MappedStatement.class, Object.class})})
public class UpdateLogInterceptor implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        if (args.length > 1) {
            Object obj = args[1];
            if (obj instanceof Log) {
                return invocation.proceed();
            }
            // 业务逻辑执行方法
            exampleTodo(args[0], obj);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }


    /**
     * 业务逻辑类
     * @param arg
     * @param obj
     */
    private void exampleTodo(Object arg, Object obj) {
        MappedStatement mappedStatement = (MappedStatement) arg;
        // 执行的方法名(update,insert,delete)
        String name = mappedStatement.getSqlCommandType().name();
        // 更新内容
        String change = JsonUtils.obj2String(obj);

        System.out.println("==============================");
        System.out.println("sqlCommand: " + name);
        System.out.println("change content: " + change );
    }
}
