package com.hyl.springdemo.repository.sqlserver;

import com.hyl.springdemo.domain.sqlserver.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select top 1 clientid,employeeid,birthdate as birthday,EmpMemberName as empName from employee "
        ,nativeQuery = true)
    Employee findTop1();
}
