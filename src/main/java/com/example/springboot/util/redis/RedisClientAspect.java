package com.example.springboot.util.redis;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description  AOP: 面向RedisClient 功能切面, 实现功能 1. 完成redis key 增加前缀
 * @author wangyushuai@fang.com
 * @date 2018/11/16
 * @helpDoc : Spring AOP https://blog.csdn.net/weixin_40315550/article/details/78941291
 */
@Aspect
@Component
public class RedisClientAspect {
    /**
     * 切入点 && ,直接写入字符串的形式，IDEA会有智能提示，故屏蔽此处代码
     */
    //private static final String POINT_CUT = "execution(* com.example.springboot.util.redis.RedisClient.*(..))";

    @Value("${com.example.springboot.redis.pre-name}")
    private String preRedisPreName;

    /**
     * @description: 定义切点-切点 为RedisClient全部方法
     * execution 参数介绍：
     * 1. public * *(..) ——  第一个* 表示任意返回值，前面可能有public, 一般省略
     * 2. * *.*(..) —— 第二个 * 表示任意包
     * 3. * *.*(..) —— 第三个 *  表示任意方法
     * 4. * *.*(..) —— (..) 表示任意参数
     * 5. 参考文档： https://blog.csdn.net/weixin_40315550/article/details/78941291
     */
    @Pointcut("execution(* com.example.springboot.util.redis.RedisClient.*(..))")
    public void pointCutAllMethod() {}

    /**
     * @description 切入 Redis工具类方法，给Key增加前缀
     * 只有环绕通知中，可以修改参数
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("pointCutAllMethod()")
    public Object addKeyPrevStr(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        args[0] =   preRedisPreName + ":" + args[0];
        Object result = proceedingJoinPoint.proceed(args);
        return result;
    }












}
