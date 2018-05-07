package com.gradutation.design.ljx.domain.query;

/**
 * Created by hehe on 18-2-5.
 */
public class DiyStoreMainShipOrderQuery extends PageQuery{

    private static final long serialVersionUID = -2201823189517463283L;

    private Long id;

    private Long mainShipOrderId;

    private Long buyerId;

    private Long sellerId;

    private Integer status;

    private Long lbxNo;

    private Integer bizType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getmainShipOrderId() {
        return mainShipOrderId;
    }

    public void setmainShipOrderId(Long mainShipOrderId) {
        this.mainShipOrderId = mainShipOrderId;
    }

    public Long getLbxNo() {
        return lbxNo;
    }

    public void setLbxNo(Long lbxNo) {
        this.lbxNo = lbxNo;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }
}
