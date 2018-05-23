package com.graduation.design.ljx.handler;

import com.graduation.design.ljx.domain.context.ConstructOrderContext;
import com.graduation.design.ljx.domain.dto.DiyStoreDetailShipOrderDTO;
import com.graduation.design.ljx.domain.dto.DiyStoreMainShipOrderDTO;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;

import java.util.Map;
import java.util.Set;

/**
 * Created by hehe on 18-4-27.
 */
public interface ConstructOrderHandler {

    DiyStoreProcessorResult<ConstructOrderContext> addToShoppingCart(Long itemId,Long buyerId,Map<String,String> attr);

    DiyStoreProcessorResult<ConstructOrderContext> removeFromShoppingCart(Long itemId,Long buyerId);

    /**
     * The method can be used for updating the num of shopping and add the address for mainShipOrder
     * @param
     * @param
     * @return
     */
  //  DiyStoreProcessorResult<ConstructOrderContext> upadteForShoppingCart(Set<DiyStoreDetailShipOrderDTO> diyStoreDetailShipOrderDTOS, DiyStoreMainShipOrderDTO diyStoreMainShipOrderDTO);
}
