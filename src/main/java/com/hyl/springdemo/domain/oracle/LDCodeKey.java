package com.hyl.springdemo.domain.oracle;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class LDCodeKey implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codeType;
    private String code;

    public String getCodeType() {
        return codeType;
    }
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

}