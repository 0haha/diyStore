package com.graduation.design.ljx.domain.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hehe on 18-3-27.
 */
public enum DiyStoreErrorCodeEnum {

    DIY_STORE_SUCCESS(Long.valueOf(0L),"DIY_STORE_SUCCESS","无错误"),

    DIY_STORE_DB_QUERY_EXCEED_MAX_RANGE(Long.valueOf(10007L), "SCM_DB_QUERY_EXCEED_MAX_RANGE", "数据库查询超过最大容许范围"),

    DIY_STORE_DB_ERROR(Long.valueOf(10007L),"DIY_STORE_DB_ERROR","数据库操作失败"),

    DIY_STORE_PARAM_ERROR(Long.valueOf(10008L),"DIY_STORE_PARAM_ERROR","输入参数非法"),

    DIY_STORE_SCM_ERROR(Long.valueOf(20000L),"DIY_STORE_SCM_ERROR","业务处理非法");

    private Long code;

    private String errorCode;

    private String errorMessage;

    static Map<String,DiyStoreErrorCodeEnum> diyStoreErrorCodeEnumMap = new HashMap<String, DiyStoreErrorCodeEnum>();

    private DiyStoreErrorCodeEnum(Long code,String errorCode,String errorMessage){
        this.code = code;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Long getCode() {
        return code;
    }

    private static void ininMap(){
        DiyStoreErrorCodeEnum[] enums = values();
        for(DiyStoreErrorCodeEnum e:enums){
            diyStoreErrorCodeEnumMap.put(e.errorCode,e);
        }
    }

    public static DiyStoreErrorCodeEnum getEnumByErrorCode(String errorCode){
        if(diyStoreErrorCodeEnumMap.size()<=0){
            ininMap();
        }

            return diyStoreErrorCodeEnumMap.get(errorCode);

    }
}
