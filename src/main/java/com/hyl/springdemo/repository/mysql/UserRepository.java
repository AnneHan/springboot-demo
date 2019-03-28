package com.hyl.springdemo.repository.mysql;

import com.hyl.springdemo.domain.mysql.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from user limit 0,1 ", nativeQuery = true)
    User findTop1();
}
