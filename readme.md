# 1. 快速创建SpringBoot项目

官方文档（十五分钟快速入门SpringBoot）：https://spring.io/guides/gs/spring-boot/

## 1.1 Java Dev Enviroment
 
（JDK + IDEA + maven + tomcat）

与C#环境对比如下：

- JDK：jre(=C# CLR，java运行环境，包含了常用的、基本的类库) + jvm
- IDEA:Visual studio
- maven : nuget
- tomcat or resin or netty: IIS

*补充：java语法与C#非常相近，转换成本较低，C#语法基本上就是在java语法的基础上包了一层层语法糖*



## 1.2 Learn what you can do with Spring Boot

Spring Boot 轻量级框架，相对于SpringMVC,仅需要较少的配置，并升级了常用的API（更加轻便），通过SpringBoot 我们可以更加专注于业务，而不是架构（适合微服务）。



## 1.3 Create SpringBoot（快速创建项目）

1. 使用官网构建工具自动创建web应用（快速创建）

    https://spring.io/projects/spring-boot

2. 使用 IDEA 创建（手动创建）
3. 目录文件结构讲解
4. 
```
src/main/java：存放代码
src/main/resources
    static: 存放静态文件，比如 css、js、image, （访问方式 http://localhost:8080/js/main.js）
    templates:存放静态页面jsp,html,tpl
    config:存放配置文件,application.properties
    resources:
```



4. HelloWorld Develop

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


# 2 DevTool热部署和配置文件自动注入

## 2.1 DevTool热部署
引入jar包后，不用重新启动，IDEA环境下rebuild则可以启动生效

## 2.2 读取配置文件
### 2.2.1 方式一
1. Controller上面配置 
```
@PropertySource({"classpath":resource.property})
```
2. 增加属性

```
@Value("{xxxx}")
private String xx;
```

### 2.2.2 配置文件自动映射成实体集
1. 配置实体集ServerSettings 需添加注解


```

@Component
@PropertySource({"classpath:/config/config.properties","classpath:/config/server.properties"})
@ConfigurationProperties(prefix = "ask")
```

1. @Component：会扫描到它
2. @PropertySource：注入来源，之所以用大括号，是因为数组形式，可以注入多个文件
3. @ConfigurationProperties： 添加前缀，注意添加前缀之后，注入bean的方式，属性名称和配置文件里面的key一一对应，就用加@Value 这个注解，如果不一样，就要加 @value("${XXX}"，xxx表示全名比如： ask.search)




