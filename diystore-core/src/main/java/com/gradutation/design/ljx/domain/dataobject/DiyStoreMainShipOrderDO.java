package com.gradutation.design.ljx.domain.dataobject;

import java.util.Date;

/**
 * Created by hehe on 18-2-5.
 */
public class DiyStoreMainShipOrderDO extends DiyStoreBaseDO{

    private static final long serialVersionUID = -2373059571241335447L;

    private Long mainShipOrderId;
    private Long buyerId;
    private String buyerNick;
    private Long sellerId;
    private String sellerNick;
    private String consignee;
    private String postCode;
    private String phone;
    private String mobilePhone;
    private String country;
    private String prov;
    private String city;
    private String area;
    private String town;
    private String address;
    private Date deliveryConfirmTime;
    private Double shipFormFee;
    private Double discountFee;
    private Long storeHouseCode;
    private String storeHouseName;
    private Long lbxNo;
    private String cancelDeliveryReason;
    private Integer shipType;
    private Integer bizType;
    private Integer status;
    private String buyerMessage;
    private Integer payType;
    private Integer skuAmount;
    private String sellerMessage;
    private Date approveTime;
    private Date fetchTime;
    private String errorCode;
    private String errorMessage;
    private Date payTime;
    private Date tradeSuccessTime;



    public Long getmainShipOrderId() {
        return mainShipOrderId;
    }

    public void setmainShipOrderId(Long mainShipOrderId) {
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

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDeliveryConfirmTime() {
        return deliveryConfirmTime;
    }

    public void setDeliveryConfirmTime(Date deliveryConfirmTime) {
        this.deliveryConfirmTime = deliveryConfirmTime;
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

    public Long getStoreHouseCode() {
        return storeHouseCode;
    }

    public void setStoreHouseCode(Long storeHouseCode) {
        this.storeHouseCode = storeHouseCode;
    }

    public String getStoreHouseName() {
        return storeHouseName;
    }

    public void setStoreHouseName(String storeHouseName) {
        this.storeHouseName = storeHouseName;
    }

    public Long getLbxNo() {
        return lbxNo;
    }

    public void setLbxNo(Long lbxNo) {
        this.lbxNo = lbxNo;
    }

    public String getCancelDeliveryReason() {
        return cancelDeliveryReason;
    }

    public void setCancelDeliveryReason(String cancelDeliveryReason) {
        this.cancelDeliveryReason = cancelDeliveryReason;
    }

    public Integer getShipType() {
        return shipType;
    }

    public void setShipType(Integer shipType) {
        this.shipType = shipType;
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


    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getSkuAmount() {
        return skuAmount;
    }

    public void setSkuAmount(Integer skuAmount) {
        this.skuAmount = skuAmount;
    }

    public String getSellerMessage() {
        return sellerMessage;
    }

    public void setSellerMessage(String sellerMessage) {
        this.sellerMessage = sellerMessage;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public Date getFetchTime() {
        return fetchTime;
    }

    public void setFetchTime(Date fetchTime) {
        this.fetchTime = fetchTime;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getTradeSuccessTime() {
        return tradeSuccessTime;
    }

    public void setTradeSuccessTime(Date tradeSuccessTime) {
        this.tradeSuccessTime = tradeSuccessTime;
    }
}
