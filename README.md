# springboot-demo
Spring boot项目，用于新人学习，后续会随着博文的更新，而继续完善，希望能够为学习Spring boot的同学带来一些帮助。

# 关于我
***
Author  | AnneHan
--      | --
E-mail  | lilyhyl@163.com
Blog    | https://www.cnblogs.com/AnneHan/
***

# 项目架构说明：

本项目采用spring boot构建开发，数据库是mysql、Oracle、Sql server。  

controller：控制层  
domain：实体类，与数据库表对应，所有表都要有主键  
repository：持久层使用JPA  
service：业务逻辑接口层  
service.impl：业务逻辑实现层  
dto：数据传输对象  
vo：视图包装对象  
utils：常用工具类  
exception：自定义的异常，建议使用@ControllerAdvice和@ExceptionHandler进行全局异常处理

# 系列博文
* [Spring Boot系列学习文章(一) -- Intellij IDEA 搭建Spring Boot项目](https://www.cnblogs.com/AnneHan/p/10318343.html)
* [Spring Boot系列学习文章(二) -- 配置多数据源](https://www.cnblogs.com/AnneHan/p/10532066.html)
