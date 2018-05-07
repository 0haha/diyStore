package com.graduation.design.ljx.service;

import com.graduation.design.ljx.domain.dto.DiyStoreDetailShipOrderDTO;
import com.graduation.design.ljx.domain.dto.DiyStoreMainShipOrderDTO;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
//import com.gradutation.design.ljx.domain.dataobject.DiyStoreMainShipOrderDO;
//import com.gradutation.design.ljx.domain.query.DiyStoreMainShipOrderQuery;
//import com.gradutation.design.ljx.service.DiyStoreBaseDaoService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by hehe on 18-3-27.
 */
public interface DiyStoreMainShipOrderDaoService {

    DiyStoreProcessorResult<List<DiyStoreMainShipOrderDTO>> queryByMainShipOrderId(Long mainShipOrderId, Long buyerId, Integer bizType);

    DiyStoreProcessorResult<List<DiyStoreMainShipOrderDTO>> queryAllByMainShipOrderId(Long mainShipOrderId,Long buyerId,Integer bizType);

    DiyStoreProcessorResult<Void> persistShipOrder(Set<DiyStoreMainShipOrderDTO> diyStoreMainShipOrderDTOSet,boolean bNewMSO);

    DiyStoreProcessorResult<Void> persistShipOrder(DiyStoreMainShipOrderDTO diyStoreMainShipOrderDTO,boolean bNewMSO);

    DiyStoreProcessorResult<Void> updateStatus(Map<DiyStoreMainShipOrderDTO,List<DiyStoreDetailShipOrderDTO>> diyStoreMainShipOrderDTOListMap);

    DiyStoreProcessorResult<Void> updateTradeSuccessTime(Date successTime,Long mainShipOrderId,Long buyerId,Integer bizType);

    DiyStoreProcessorResult<List<DiyStoreMainShipOrderDTO>> queryByBuyerIdAndStatus(Long buyerId,Integer status);

   DiyStoreProcessorResult<DiyStoreMainShipOrderDTO> deleteByMainShipOrderId(Long id);
}
