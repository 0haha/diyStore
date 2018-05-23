package com.graduation.design.ljx.domain.context;

import com.graduation.design.ljx.domain.dto.DiyStoreDetailShipOrderDTO;
import com.graduation.design.ljx.domain.dto.DiyStoreMainShipOrderDTO;

import java.util.Map;
import java.util.Set;

/**
 * Created by hehe on 18-4-27.
 */
public class ConstructOrderContext extends BaseContext{

    private Integer operateType;

    private boolean isDetailShipOrderConstruct = false;

    private Map<String,String> attr;

    private Long currentItemId;

    private Long buyerId;

    private DiyStoreMainShipOrderDTO diyStoreMainShipOrderDTO;

    private DiyStoreDetailShipOrderDTO currentDiyStoreDetailShipOrderDTO;

    private Set<DiyStoreDetailShipOrderDTO> diyStoreDetailShipOrderDTOSet;

    public DiyStoreDetailShipOrderDTO getCurrentDiyStoreDetailShipOrderDTO() {
        return currentDiyStoreDetailShipOrderDTO;
    }

    public void setCurrentDiyStoreDetailShipOrderDTO(DiyStoreDetailShipOrderDTO currentDiyStoreDetailShipOrderDTO) {
        this.currentDiyStoreDetailShipOrderDTO = currentDiyStoreDetailShipOrderDTO;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public boolean isDetailShipOrderConstruct() {
        return isDetailShipOrderConstruct;
    }

    public void setDetailShipOrderConstruct(boolean detailShipOrderConstruct) {
        isDetailShipOrderConstruct = detailShipOrderConstruct;
    }

    public Map<String, String> getAttr() {
        return attr;
    }

    public void setAttr(Map<String, String> attr) {
        this.attr = attr;
    }

    public Long getCurrentItemId() {
        return currentItemId;
    }

    public void setCurrentItemId(Long currentItemId) {
        this.currentItemId = currentItemId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public DiyStoreMainShipOrderDTO getDiyStoreMainShipOrderDTO() {
        return diyStoreMainShipOrderDTO;
    }

    public void setDiyStoreMainShipOrderDTO(DiyStoreMainShipOrderDTO diyStoreMainShipOrderDTO) {
        this.diyStoreMainShipOrderDTO = diyStoreMainShipOrderDTO;
    }

    public Set<DiyStoreDetailShipOrderDTO> getDiyStoreDetailShipOrderDTOSet() {
        return diyStoreDetailShipOrderDTOSet;
    }

    public void setDiyStoreDetailShipOrderDTOSet(Set<DiyStoreDetailShipOrderDTO> diyStoreDetailShipOrderDTOSet) {
        this.diyStoreDetailShipOrderDTOSet = diyStoreDetailShipOrderDTOSet;
    }
}
