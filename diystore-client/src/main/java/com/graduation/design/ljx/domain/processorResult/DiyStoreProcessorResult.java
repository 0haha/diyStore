package com.graduation.design.ljx.domain.processorResult;

import com.graduation.design.ljx.domain.enums.DiyStoreErrorCodeEnum;

import java.io.Serializable;

/**
 * Created by hehe on 18-3-4.
 */
public class DiyStoreProcessorResult<T> implements Serializable {

    private static final long serialVersionUID = -873368751732421392L;

    private boolean success = false;

    private String errorMessage;

    private String errorCode;

    private Long code;

    private boolean isRestry;

    private T model;

    public boolean isSuccess(){
        return this.success;
    }

    public void setSuccess(boolean success){
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Boolean getRestry() {
        return isRestry;
    }

    public void setRestry(boolean restry) {
        isRestry = restry;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public DiyStoreProcessorResult(){
        this.errorCode = DiyStoreErrorCodeEnum.DIY_STORE_SUCCESS.getErrorCode();
        this.isRestry = false;
    }

    public DiyStoreProcessorResult<T> fail(T model,DiyStoreErrorCodeEnum e,boolean isRestry){
        this.isRestry = isRestry;
        this.errorCode = e.getErrorCode();
        this.success = false;
        this.code = e.getCode();
        this.errorMessage = e.getErrorMessage();
        this.model = model;
        return this;
    }

    public DiyStoreProcessorResult<T> fail(DiyStoreErrorCodeEnum e,boolean isRestry){
        this.isRestry = isRestry;
        this.errorCode = e.getErrorCode();
        this.success = false;
        this.code = e.getCode();
        this.errorMessage = e.getErrorMessage();
        this.model = null;
        return this;
    }

    public DiyStoreProcessorResult<T> succ(T model){
        this.isRestry = false;
        this.model = model;
        this.success = true;
        return this;
    }


}
