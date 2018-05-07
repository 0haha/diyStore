package com.gradutation.design.ljx.domain.query;

/**
 * Created by hehe on 18-3-22.
 */
public class DiyStoreItemQuery extends PageQuery{

    private Long id;

    private Long itemId;

    private Long sellerId;

    private String keyWords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
