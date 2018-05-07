package com.gradutation.design.ljx.domain.dataobject;

import java.util.Date;

/**
 * Created by hehe on 18-3-22.
 */
public class DiyStoreItemDO extends DiyStoreBaseDO {

    private Long itemId;
    private Long sellerId;
    private String sellerNick;
    private Long scItemId;
    private Long skuId;
    private Date dueDate;
    private Integer storeManagementType;
    private String itemName;
    private Double itemPrice;
    private Double itemActualPrice;
    private Long brandId;
    private String brandName;
    private Long supplierId;
    private String supplierName;
    private Double shipFormFee;
    private Double discountFee;
    private Double invoiceFee;
    private Integer bizType;
    private Integer status;
    private String purpose;
    private String producePlace;
    private Integer lackQty;
    private String lackReason;
    private String picture;
    private String quality;
    private String size;
    private String material;
    private Date onSaleTime;
    private String version;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getProducePlace() {
        return producePlace;
    }

    public void setProducePlace(String producePlace) {
        this.producePlace = producePlace;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Date getOnSaleTime() {
        return onSaleTime;
    }

    public void setOnSaleTime(Date onSaleTime) {
        this.onSaleTime = onSaleTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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

    public Double getItemActualPrice() {
        return itemActualPrice;
    }

    public void setItemActualPrice(Double itemActualPrice) {
        this.itemActualPrice = itemActualPrice;
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
}
