package com.gradutation.design.ljx.domain.dataobject;

import com.gradutation.design.ljx.util.AttributeUtils;
import com.gradutation.design.ljx.util.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hehe on 18-2-5.
 */
public class DiyStoreBaseDO implements Serializable {

    private static final long serialVersionUID = -2788791957520608500L;
    private Long id;
    private Date gmtCreate;
    private Date gmtModified;
    private Integer rowStatus;
    private Integer rowVersion;
    private String attribute;
    private Map<String, String> attributeMap;

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

    public Integer getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(Integer rowStatus) {
        this.rowStatus = rowStatus;
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

    public void putAttribute(String key,String value){
       if(StringUtils.isNotBlank(attribute)){
           attributeMap = AttributeUtils.parseAttributeByStr(attribute);
       }
       else{
           attributeMap = new HashMap<String, String>();
       }
       attributeMap.put(key,value);
       this.setAttribute(AttributeUtils.toAttributeStr(attributeMap));
    }

    public String takeAttribute(String key){
        if(StringUtils.isNotBlank(attribute)){
           attributeMap = AttributeUtils.parseAttributeByStr(attribute);
           return attributeMap.get(key);
        }
        return null;
    }

}
