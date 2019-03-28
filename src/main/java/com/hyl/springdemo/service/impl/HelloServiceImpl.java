package com.hyl.springdemo.service.impl;

import com.hyl.springdemo.domain.mysql.User;
import com.hyl.springdemo.domain.oracle.LDCode;
import com.hyl.springdemo.domain.sqlserver.Employee;
import com.hyl.springdemo.repository.mysql.UserRepository;
import com.hyl.springdemo.repository.oracle.LDCodeRepository;
import com.hyl.springdemo.repository.sqlserver.EmployeeRepository;
import com.hyl.springdemo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private UserRepository userRepository; //Mysql数据库中的表

    @Autowired
    private LDCodeRepository ldCodeRepository; //Orale数据库中的表

    @Autowired
    private EmployeeRepository employeeRepository; //Sql server数据库中的表

    public Boolean chkMysql(){
        User user = userRepository.findTop1();
        return user != null;
    }

    public Boolean chkOracle(){
        LDCode ldCode = ldCodeRepository.findTop1();
        return ldCode != null;
    }

    public Boolean chkSqlserver(){
        Employee employee = employeeRepository.findTop1();
        return employee != null;
    }
}
