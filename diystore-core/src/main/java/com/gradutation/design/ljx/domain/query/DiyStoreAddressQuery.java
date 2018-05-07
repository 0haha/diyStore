package com.gradutation.design.ljx.domain.query;



/**
 * Created by hehe on 18-4-8.
 */
public class DiyStoreAddressQuery extends PageQuery{
   private Long id;
   private Long addressId;
   private Integer status;
   private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
