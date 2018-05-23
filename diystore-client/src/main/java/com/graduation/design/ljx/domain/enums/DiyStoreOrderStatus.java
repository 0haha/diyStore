package com.graduation.design.ljx.domain.enums;

/**
 * Created by hehe on 18-4-27.
 */
public enum DiyStoreOrderStatus {

    UNPAY(1,"not_pay"),
    PAY(2,"pay"),
    CACEL(3,"cancel"),
    ABANDON(4,"abandon");

    private Integer code;

    private String message;

    DiyStoreOrderStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
