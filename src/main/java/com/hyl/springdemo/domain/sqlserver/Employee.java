package com.hyl.springdemo.domain.sqlserver;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    private String clientid;
    private String employeeid;
    private String birthday;
    private String empName;

    public String getClientid() { return clientid; }
    public void setClientid(String clientid) { this.clientid = clientid; }

    public String getEmployeeid() { return employeeid; }
    public void setEmployeeid(String employeeid) { this.employeeid = employeeid; }

    public String getBirthday() { return birthday; }
    public void setBirthday(String birthday) { this.birthday = birthday; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    @Override
    public String toString() {
        return "Employee{" +
                "clientid=" + clientid +
                ", employeeid='" + employeeid + '\'' +
                ", birthday='" + birthday + '\'' +
                ", empName='" + empName + '\'' +
                '}';
    }
}
