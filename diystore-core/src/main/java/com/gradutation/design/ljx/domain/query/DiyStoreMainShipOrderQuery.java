package com.gradutation.design.ljx.domain.query;

/**
 * Created by hehe on 18-2-5.
 */
public class DiyStoreMainShipOrderQuery extends PageQuery{

    private static final long serialVersionUID = -2201823189517463283L;

    private Long id;

    private Long buyerId;

    private Long sellerId;

    private Integer status;

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
}
