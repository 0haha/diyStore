package com.gradutation.design.ljx.domain.query;

/**
 * Created by hehe on 18-3-22.
 */
public class DiyStoreDetailShipOrderQuery extends PageQuery {

    private Long id;

    private Long detailShipOrderId;

    private Long mainShipOrderId;

    private Long buyerId;

    private Long sellerId;

    private Integer bizType;

    private Integer status;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getdetailShipOrderId() {
        return detailShipOrderId;
    }

    public void setdetailShipOrderId(Long mainShipOrderId) {
        this.detailShipOrderId = mainShipOrderId;
    }

    public Long getMainShipOrderId() {
        return mainShipOrderId;
    }

    public void setMainShipOrderId(Long detailShipOrderId) {
        this.mainShipOrderId = detailShipOrderId;
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

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
