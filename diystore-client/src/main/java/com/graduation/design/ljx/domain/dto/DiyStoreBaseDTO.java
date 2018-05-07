package com.graduation.design.ljx.domain.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by hehe on 18-3-28.
 */
public class DiyStoreBaseDTO implements Serializable{

    private static final long serialVersionUID = 1672020890572704366L;

    private Long id;
    private Date gmtCreate;
    private Date gmtModified;
//    private Integer rowStatus;
    private Integer rowVersion;
    private String attribute;
    private Map<String, String> attributeMap;

//    public Integer getRowStatus() {
//        return rowStatus;
//    }

//    public void setRowStatus(Integer rowStatus) {
//        this.rowStatus = rowStatus;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }


    public Integer getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(Integer rowVersion) {
        this.rowVersion = rowVersion;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Map<String, String> getAttributeMap() {
        return attributeMap;
    }

    public void setAttributeMap(Map<String, String> attributeMap) {
        this.attributeMap = attributeMap;
    }

    //todo : add some methods for the attribute if you need to put or get the key-value
}
