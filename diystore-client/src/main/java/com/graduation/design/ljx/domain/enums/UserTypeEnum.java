package com.graduation.design.ljx.domain.enums;

/**
 * Created by hehe on 18-4-25.
 */
public enum UserTypeEnum {

    BUYER(1,"buyer"),

    SELLER(2,"seller");

    private Integer code;

    private String message;

    UserTypeEnum(Integer code,String message){this.code = code;this.message = message;}

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
