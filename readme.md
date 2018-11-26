# SpringBoox2.x 快速入门文档 及 常见业务场景整合

      # 一、 内容目录如下：
      
        1. java环境搭建（初识java）,
        
        2. springboot2.x快速入门（搭建、开发、部署，从0-1），
        
        3. springboot2.x整合常用业务场景（API开发、数据持久化、nosql、日志、异常、多环境配置等场景）
        
      # 二、 程序目录（常用业务场景）
      
        1.  HelloController： API编写 及 常用注解
        
        2.  ConfigXXXController: 多环境配置 及 读取配置
        
        3.  ExceptionController： 异常处理（自定义异常及异常捕获）
        
        4.  LogController:  SpringBoot2.x 整合Logback框架（日志处理）
        
        5.  MybatisController:  SpringBoot2.x 整合Mybatis 3.X（数据持久化）
        
        5.1  MybatisController:  SpringBoot2.x 整合Mybatis 事务处理
        
        6.  ThyemeleafControoler: SpringBoot2.x 整合 Thymeleaf（模板引擎）
      
        7.  RedisController : SpringBoot2.x 整合 Redis4.X (分布式缓存)
        
        7.1  RedisClient （Redis工具类） RedisAspect（Spring AOP 增加项目前缀）
        
        8 TimeTakesAspect: 利用AOP 在controller api中添加程序运行耗时
      # 三、 其他Java 基础学习文档
      
         博客地址：  https://blog.csdn.net/shuai_wy/article/category/7388774

# 更新日志
1. 新增节点： 新增AOP记录controller api 耗时        
     

# 1. 快速创建SpringBoot项目

官方文档（十五分钟快速入门SpringBoot）：https://spring.io/guides/gs/spring-boot/

## 1.1 Java Dev Enviroment
 
（JDK + IDEA + maven + tomcat）

与C#环境对比如下：

- JDK：jre( ≈ .net CLR，java运行环境，包含了常用的基本的类库（net,util，sql,io,javax.servlet）+ jvm)  + java工具（javac编译，jar打包,javadoc文档,java运行编译后的代码）
- IDEA: ≈ Visual studio
- maven : ≈ nuget
- tomcat or resin or Jetty: IIS

*补充：java语法与C#非常相近，转换成本较低，C#语法基本上就是在java语法的基础上包了一层层语法糖*

*补充（java编译器和java解释器、JVM）：*

![image](https://images2015.cnblogs.com/blog/1014269/201703/1014269-20170318215404807-1296928137.png)

参考博客： https://www.cnblogs.com/chengdabelief/p/6576320.html

JVM：JVM有自己完善的硬件架构，如处理器、堆栈（Stack）、寄存器等，还具有相应的指令系统（字节码就是一种指令格式）。JVM屏蔽了与具体操作系统平台相关的信息，使得Java程序只需要生成在Java虚拟机上运行的目标代码（字节码），就可以在多种平台上不加修改地运行。JVM是Java平台无关的基础。JVM负责运行字节码：JVM把每一条要执行的字节码交给解释器，翻译成对应的机器码，然后由解释器执行。JVM解释执行字节码文件就是JVM操作Java解释器进行解释执行字节码文件的过程。



## 1.2 Learn what you can do with Spring Boot

SpringBoot 轻量级框架，相对于SpringMVC,仅需要较少的配置，并升级了常用的注解（更加轻便），通过SpringBoot 我们可以更加专注于业务，而不是架构。



## 1.3 Create SpringBoot（快速创建项目）

1. 使用官网构建工具自动创建web应用（快速创建）

    https://spring.io/projects/spring-boot

2. 使用 IDEA 创建（手动创建）
3. 目录文件结构讲解
```
src/main/java：存放代码
src/main/resources
    static: 存放静态文件，比如 css、js、image, （访问方式 http://localhost:8080/js/main.js）
    templates:存放静态页面jsp,html,tpl
    config:存放配置文件,application.properties
    resources:
```



4. 开发 "SpringBoot HelloWorld" (编写API常用注解介绍)

## 1.4 Run  （SpringBoot启动方式和部署war项目到tomcat）

1. IDEA RUN （F5, IDEA 可以直接将使用Vs快捷键）
2. jar启动方式（用的较少，一般spirng boot是使用war进行部署的）
 - mvn install 生成jar包
 - java -jar xxx.jar (jar包方式)

3. war包方式启动
 
- 修改porm.xml，改成war方式
- 修改启动类，extends SpringBootServletInitializer,并override方法
- mvn clean && mvn install 打包
- 将war包放至 tomcat webapps下
- tomcat/bin startup.bat, 
- 访问localhost:8080/**项目名/**路径
（注意项目名，tomcat下可以部署多个项目的）


# 2 DevTool热部署

引入jar包后，不用重新启动，IDEA环境下rebuild则可以启动生效

# 3 SpringBoot 配置文件
## 3.1 读取配置文件
### 3.1.1 注解读取
1. Controller上面配置 
```
@PropertySource({"classpath":resource.property})
```
2. 增加属性

```
@Value("{xxxx}")
private String xx;
```

### 3.1.2 配置文件自动映射成实体集
1. 配置实体集ServerSettings 需添加注解


```

@Component
@PropertySource({"classpath:/config/config.properties","classpath:/config/server.properties"})
@ConfigurationProperties(prefix = "ask")
```


1. @Component：会扫描到它
2. @PropertySource：注入来源，之所以用大括号，是因为数组形式，可以注入多个文件
3. @ConfigurationProperties： 添加前缀，注意添加前缀之后，注入bean的方式，属性名称和配置文件里面的key一一对应，就不用加@Value 这个注解； 如果不一样，就要加 @value("${XXX}"，xxx表示全名比如： ask.search)


## 3.2 springboot多环境配置
### 3.2.1 方式一：spring.profiles.active

- resource
    - applicaition.properties
    - applicaiton-dev.properties
    - applicaiton-pro.properties

在 applicaiton.properties 选择要激活的文件，如：使用测试配置文件


```
// 激活测试配置
spring.profiles.active=dev 
```
所以， 需要区分环境的配置，可以防止 application-{}.properties中，通用配置可以放到 applicaition.properties中。


### 3.2.2 方式二： 通过maven构建多环境配置






# 4. 异常处理
## 4.1 SpringBoot2.X服务端异常讲解和配置全局异常

1. 增加异常处理类 ExceptionHandler

添加 @RestControllerAdvice 注解 或 ControllerAdvice注解

2. 在异常处理类中，增加异常处理方法

在方法上添加 @ExceptionHandler(value=CustomerException.class)注解
详见 CustomerExceptionHandler类及自定义CustomerException类（继承Excption,扔出异常时使用）



# 5. 日志处理
## 5.1. SpringBoot整合LogBack日志框架

1. 常用处理java的日志组件 slf4j,log4j,logback,common-logging 等

2. logback介绍：基于Log4j基础上大量改良，不能单独使用，推荐配合日志框架SLF4J来使用
		logback当前分成三个模块：logback-core,logback-classic和logback-access;
		logback-core是其它两个模块的基础模块
3. 官网介绍：https://docs.spring.io/spring-boot/docs/2.1.0.BUILD-SNAPSHOT/reference/htmlsingle/#boot-features-logging

    各个组件案例：https://logback.qos.ch/manual/index.html
    
4. 配置文件：classpath:logback-spring.xml
5. 调用语法
```
 private Logger logger  = LoggerFactory.getLogger(this.getClass());
 logger.error("this is a error");
```

6. logback-spring.xml 支持多环境配置
参考博文： https://blog.csdn.net/qianyiyiding/article/details/76565810
```
 <springProfile name="production">
        <root level="DEBUG">
            <!--<appender-ref ref="FILEERROR"/>-->
            <!--<appender-ref ref="FILEWARN"/>-->
            <!--<appender-ref ref="FILEINFO"/>-->
            <!--<appender-ref ref="DBAPPENDER"/>-->
            <appender-ref ref="STDOUT"/>

        </root>
    </springProfile>


    <springProfile name="dev">
        <root level="DEBUG">
            <!--<appender-ref ref="FILEERROR"/>-->
            <!--<appender-ref ref="FILEWARN"/>-->
            <!--<appender-ref ref="FILEINFO"/>-->
            <!--<appender-ref ref="DBAPPENDER"/>-->
            <appender-ref ref="CONSOLE"/>

        </root>
    </springProfile>
```

# 6. SpringBoot2.x 整合 Mybatis 3.X

TODO:

# 7. SpringBoot2.x 整合 Thymeleaf

# 8. SpringBoot2.x 整合 分布式缓存 Redis
## 8.1 Redis工具类
## 8.2 Spring AOP 给Redis key 统一增加前缀 


