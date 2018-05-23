package com.graduation.design.ljx.executor.impl.constructOrder;

import com.graduation.design.ljx.domain.annotation.Executor;
import com.graduation.design.ljx.domain.context.ConstructOrderContext;
import com.graduation.design.ljx.domain.dto.DiyStoreDetailShipOrderDTO;
import com.graduation.design.ljx.domain.dto.DiyStoreMainShipOrderDTO;
import com.graduation.design.ljx.domain.enums.DiyStoreOrderStatus;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
import com.graduation.design.ljx.executor.BaseExecutor;
import com.graduation.design.ljx.service.DiyStoreDetailShipOrderDaoService;
import com.graduation.design.ljx.service.DiyStoreMainShipOrderDaoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hehe on 18-4-28.
 */
@Executor(name="ConstructShipOrder",business = "ConstructOrder",priority = 1)
public class CheckShipOrder extends BaseExecutor<ConstructOrderContext> {

    @Resource
    private DiyStoreDetailShipOrderDaoService diyStoreDetailShipOrderDaoService;

    @Resource
    private DiyStoreMainShipOrderDaoService diyStoreMainShipOrderDaoService;

    @Override
    public DiyStoreProcessorResult<Void> execute(ConstructOrderContext context) {

        DiyStoreProcessorResult<Void> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
        diyStoreProcessorResult.setSuccess(true);

        DiyStoreProcessorResult<List<DiyStoreMainShipOrderDTO>> res =diyStoreMainShipOrderDaoService.queryByBuyerIdAndStatus(context.getBuyerId(), DiyStoreOrderStatus.UNPAY.getCode());
        List<DiyStoreMainShipOrderDTO> diyStoreMainShipOrderDTOList = res.getModel();
        if(diyStoreMainShipOrderDTOList == null || diyStoreMainShipOrderDTOList.size()==0){
            return diyStoreProcessorResult;
        }
        DiyStoreMainShipOrderDTO diyStoreMainShipOrderDTO = diyStoreMainShipOrderDTOList.get(0);
        Long diyStoreMainShipOrderId = diyStoreMainShipOrderDTO.getMainShipOrderId();

        DiyStoreProcessorResult<List<DiyStoreDetailShipOrderDTO>> res1 = diyStoreDetailShipOrderDaoService.queryByMainShipOrderId(diyStoreMainShipOrderId);
        List<DiyStoreDetailShipOrderDTO> diyStoreDetailShipOrderDTOS = res1.getModel();
        if(diyStoreDetailShipOrderDTOS == null || diyStoreMainShipOrderDTOList.size()==0){
            return diyStoreProcessorResult;
        }
        diyStoreDetailShipOrderDTOS.forEach(n->{if(n.getItemId().equals(context.getCurrentItemId())){context.setDetailShipOrderConstruct(true);context.setCurrentDiyStoreDetailShipOrderDTO(n);}});

        return diyStoreProcessorResult;
    }
}
