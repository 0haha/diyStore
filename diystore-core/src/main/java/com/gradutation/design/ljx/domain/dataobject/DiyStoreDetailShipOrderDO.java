package com.gradutation.design.ljx.domain.dataobject;

import java.util.Date;

/**
 * Created by hehe on 18-3-22.
 */
public class DiyStoreDetailShipOrderDO extends DiyStoreBaseDO {


    private Long detailShipOrderId;
    private Long mainShipOrderId;
    private Long buyerId;
    private String buyerNick;
    private Long sellerId;
    private String sellerNick;
    private Long itemId;
    private Long scItemId;
    private Long skuId;
    private Integer purchaseOrderNo;
    private Date dueDate;
    private Integer storeManagementType;
    private Integer goodsDeliveryAmount;
    private String itemName;
    private Double itemPrice;
    private Long brandId;
    private String brandName;
    private Long supplierId;
    private String supplierName;
    private String measureUnit;
    private Double shipFormFee;
    private Double discountFee;
    private Double invoiceFee;
    private Integer bizType;
    private Integer status;
    private Integer lackQty;
    private String lackReason;

    public Long getDetailShipOrderId() {
        return detailShipOrderId;
    }

    public void setDetailShipOrderId(Long detailShipOrderId) {
        this.detailShipOrderId = detailShipOrderId;
    }

    public Long getMainShipOrderId() {
        return mainShipOrderId;
    }

    public void setMainShipOrderId(Long mainShipOrderId) {
        this.mainShipOrderId = mainShipOrderId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerNick() {
        return sellerNick;
    }

    public void setSellerNick(String sellerNick) {
        this.sellerNick = sellerNick;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getScItemId() {
        return scItemId;
    }

    public void setScItemId(Long scItemId) {
        this.scItemId = scItemId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Integer getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(Integer purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getStoreManagementType() {
        return storeManagementType;
    }

    public void setStoreManagementType(Integer storeManagementType) {
        this.storeManagementType = storeManagementType;
    }

    public Integer getGoodsDeliveryAmount() {
        return goodsDeliveryAmount;
    }

    public void setGoodsDeliveryAmount(Integer goodsDeliveryAmount) {
        this.goodsDeliveryAmount = goodsDeliveryAmount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public Double getShipFormFee() {
        return shipFormFee;
    }

    public void setShipFormFee(Double shipFormFee) {
        this.shipFormFee = shipFormFee;
    }

    public Double getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(Double discountFee) {
        this.discountFee = discountFee;
    }

    public Double getInvoiceFee() {
        return invoiceFee;
    }

    public void setInvoiceFee(Double invoiceFee) {
        this.invoiceFee = invoiceFee;
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

    public Integer getLackQty() {
        return lackQty;
    }

    public void setLackQty(Integer lackQty) {
        this.lackQty = lackQty;
    }

    public String getLackReason() {
        return lackReason;
    }

    public void setLackReason(String lackReason) {
        this.lackReason = lackReason;
    }
}
