package com.hyl.springdemo.domain.mysql;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String uid;
    private String username;
    private String password;
    @Column(name = "client_no")
    private String clientNo;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "business_type")
    private String businessType;
    @Column(name = "user_type")
    private String userType;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "create_by")
    private String createBy;
    @Column(name = "modify_date")
    private Date modifyDate;
    @Column(name = "modify_by")
    private String modifyBy;
    @Column(name = "is_del")
    private String isDel;

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientNo() { return clientNo; }
    public void setClientNo(String clientNo) { this.clientNo = clientNo; }

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }

    public String getBusinessType() { return businessType; }
    public void setBusinessType(String businessType) { this.businessType = businessType; }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", clientNo='" + clientNo + '\'' +
                ", empName='" + empName + '\'' +
                ", businessType='" + businessType + '\'' +
                ", userType='" + userType + '\'' +
                ", createDate=" + createDate +
                ", createBy='" + createBy + '\'' +
                ", modifyDate=" + modifyDate +
                ", modifyBy='" + modifyBy + '\'' +
                ", isDel='" + isDel + '\'' +
                '}';
    }
}
