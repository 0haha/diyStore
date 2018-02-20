package com.gradutation.design.ljx.domain.dataobject;

/**
 * Created by hehe on 18-2-5.
 */
public class DiyStoreMainShipOrderDO extends DiyStoreBaseDO{

    private static final long serialVersionUID = -2373059571241335447L;
    /**
     * 买家id
     */
    private Long buyerId;
    /**
     * 买家昵称
     */
    private String buyerNick;
    /**
     * 卖家id
     */
    private Long sellerId;
    /**
     * 卖家昵称
     */
    private String sellerNick;
    /**
     * 邮编
     */
    private String postCode;
    /**
     * 座机
     */
    private String phone;
    /**
     * 手机
     */
    private String mobilePhone;

    /**
     * 国家
     */
    private String country;

    /**
     * 省
     */
    private String prov;

    /**
     * 市
     */
    private String city;

    /**
     * 区县
     */
    private String area;

    /**
     * 镇
     */
    private String town;
    /**
     * 街道地址
     */
    private String address;
    /**
     * 买家留言信息
     */
    private String buyerMessage;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 付款方式
     */
    private Integer payType;

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

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }
}
