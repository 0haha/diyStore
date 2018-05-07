package com.graduation.design.ljx.service;

import com.graduation.design.ljx.domain.dto.DiyStoreDetailShipOrderDTO;
import com.graduation.design.ljx.domain.dto.DiyStoreMainShipOrderDTO;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
//import com.gradutation.design.ljx.domain.dataobject.DiyStoreDetailShipOrderDO;
//import com.gradutation.design.ljx.domain.query.DiyStoreDetailShipOrderQuery;
//import com.gradutation.design.ljx.service.DiyStoreBaseDaoService;

import java.util.List;

/**
 * Created by hehe on 18-3-27.
 */
public interface DiyStoreDetailShipOrderDaoService  {
  DiyStoreProcessorResult<List<DiyStoreDetailShipOrderDTO>> queryByMainShipOrderId(Long mainShipOrderId);

  DiyStoreProcessorResult<Void> persistDetailShipOrder(DiyStoreDetailShipOrderDTO diyStoreDetailShipOrderDTO,boolean bNewMSO);

  DiyStoreProcessorResult<DiyStoreDetailShipOrderDTO> deleteByDetailShipOrderId(Long id);
}
