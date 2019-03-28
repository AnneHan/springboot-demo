package com.hyl.springdemo.domain.oracle;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "LDCODE")
@IdClass(LDCodeKey.class)
public class LDCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String codeType;
    @Id
    private String code;
    private String codeName;
    private String codeAlias;
    private String comCode;
    private String otherSign;
    private String eCodeName;

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
    public String getCodeName() {
        return codeName;
    }
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
    public String getCodeAlias() {
        return codeAlias;
    }
    public void setCodeAlias(String codeAlias) {
        this.codeAlias = codeAlias;
    }
    public String getComCode() {
        return comCode;
    }
    public void setComCode(String comCode) {
        this.comCode = comCode;
    }
    public String getOtherSign() {
        return otherSign;
    }
    public void setOtherSign(String otherSign) {
        this.otherSign = otherSign;
    }
    public String geteCodeName() {
        return eCodeName;
    }
    public void seteCodeName(String eCodeName) {
        this.eCodeName = eCodeName;
    }

}
