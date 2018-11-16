package com.example.springboot.Util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description Redis 切面，增加Key前缀
 * @author wangyushuai@fang.com
 * @date 2018/11/16
 * @helpDoc : Spring AOP https://blog.csdn.net/weixin_40315550/article/details/78941291
 */
@Aspect
@Component
public class RedisAspect {
    /**
     * 切入点 && ,直接写入字符串的形式，IDEA会有只能提示，故屏蔽此处代码
     */
    //private static final String POINT_CUT = "execution(* com.example.springboot.Util.RedisClient.*(..))";

    @Value("${com.example.springboot.redis.pre-name}")
    private String preRedisPreName;

//    切入点，由于直接在注解中添加了切入点，故此处写的切入点可以不用了
//    @Pointcut(POINT_CUT)
//    public void getAndSet() {}


    /**
     * 切入 Redis工具类方法，给Key增加前缀
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.example.springboot.Util.RedisClient.*(..))")
    public Object addKeyPrevStr(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        args[0] =   preRedisPreName + ":" + args[0];
        Object result = proceedingJoinPoint.proceed(args);
        return result;
    }







}
