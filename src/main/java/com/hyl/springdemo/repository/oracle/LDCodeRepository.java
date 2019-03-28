package com.hyl.springdemo.repository.oracle;

import com.hyl.springdemo.domain.oracle.LDCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LDCodeRepository extends JpaRepository<LDCode, Long> {

    @Query(value = "select * from ldcode where rownum <= 1 ", nativeQuery = true)
    LDCode findTop1();
}
