package com.hyl.springdemo.controller;

import com.hyl.springdemo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @programName: HelloController.java
 * @programFunction: for test
 * @createDate: 2019/01/25
 * @author: AnneHan
 * @version:
 * xx.   yyyy/mm/dd   ver    author    comments
 * 01.   2019/01/25   1.00   AnneHan   New Create
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    private String index(){
        //return "Hello Spring Boot!";

        Boolean bMysql = helloService.chkMysql();
        Boolean bOracle = helloService.chkOracle();
        Boolean bSqlserver = helloService.chkSqlserver();

        return "Mysql查询出数据：" + bMysql + " <br> " + "Oracle查询出数据：" + bOracle + " <br> " + "Sql server查询出数据：" + bSqlserver;
    }


}
