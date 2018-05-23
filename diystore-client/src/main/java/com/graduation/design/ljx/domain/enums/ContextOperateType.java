package com.graduation.design.ljx.domain.enums;

/**
 * Created by hehe on 18-4-28.
 */
public enum ContextOperateType {

    CONSTRUCT_ORDER_ADD(1,"add_order"),
    CONSTRUCT_ORDER_RM(2,"rm_order");

    private Integer code;

    private String message;

    ContextOperateType(Integer code, String message) {
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
