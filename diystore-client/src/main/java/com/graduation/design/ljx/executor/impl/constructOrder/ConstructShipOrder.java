package com.graduation.design.ljx.executor.impl.constructOrder;

import com.graduation.design.ljx.domain.annotation.Executor;
import com.graduation.design.ljx.domain.context.ConstructOrderContext;
import com.graduation.design.ljx.domain.dto.DiyStoreDetailShipOrderDTO;
import com.graduation.design.ljx.domain.dto.DiyStoreItemDTO;
import com.graduation.design.ljx.domain.dto.DiyStoreMainShipOrderDTO;
import com.graduation.design.ljx.domain.enums.ContextOperateType;
import com.graduation.design.ljx.domain.enums.DiyStoreErrorCodeEnum;
import com.graduation.design.ljx.domain.enums.DiyStoreOrderStatus;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
import com.graduation.design.ljx.executor.BaseExecutor;
import com.graduation.design.ljx.service.DiyStoreDetailShipOrderDaoService;
import com.graduation.design.ljx.service.DiyStoreItemDaoService;
import com.graduation.design.ljx.service.DiyStoreMainShipOrderDaoService;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by hehe on 18-4-27.
 */
@Slf4j
@Executor(name="ConstructShipOrder",business = "ConstructOrder",priority = 2)
public class ConstructShipOrder extends BaseExecutor<ConstructOrderContext>{

    @Resource
    private DiyStoreItemDaoService diyStoreItemDaoService;

    @Resource
    private DiyStoreDetailShipOrderDaoService diyStoreDetailShipOrderDaoService;

    @Resource
    private DiyStoreMainShipOrderDaoService diyStoreMainShipOrderDaoService;

    @Override
    public DiyStoreProcessorResult<Void> execute(ConstructOrderContext context) {

        DiyStoreProcessorResult<Void> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
        diyStoreProcessorResult.setSuccess(true);

        Long buyerId = context.getBuyerId();
        Long itemId = context.getCurrentItemId();

        DiyStoreProcessorResult<List<DiyStoreMainShipOrderDTO>> res1 = diyStoreMainShipOrderDaoService.queryByBuyerIdAndStatus(buyerId, DiyStoreOrderStatus.UNPAY.getCode());
        if(!res1.isSuccess()){
            res1.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
        }
        List<DiyStoreMainShipOrderDTO> diyStoreMainShipOrderDTOList = res1.getModel();
        Long mainShipOrderId = new Date().getTime();

        DiyStoreMainShipOrderDTO diyStoreMainShipOrderDTO = new DiyStoreMainShipOrderDTO();

        if(diyStoreMainShipOrderDTOList == null || diyStoreMainShipOrderDTOList.size()<=0){

           diyStoreMainShipOrderDTO.setMainShipOrderId(mainShipOrderId);
           diyStoreMainShipOrderDTO.setBuyerId(buyerId);
           diyStoreMainShipOrderDTO.setStatus(DiyStoreOrderStatus.UNPAY.getCode());
            diyStoreMainShipOrderDaoService.persistShipOrder(diyStoreMainShipOrderDTO,true);
        }
        else {
            diyStoreMainShipOrderDTO = diyStoreMainShipOrderDTOList.get(0);

            mainShipOrderId = diyStoreMainShipOrderDTO.getMainShipOrderId();
        }
        context.setDiyStoreMainShipOrderDTO(diyStoreMainShipOrderDTO);

        if(context.getOperateType() == ContextOperateType.CONSTRUCT_ORDER_ADD.getCode()) {
            if (context.isDetailShipOrderConstruct()) return diyStoreProcessorResult;

            DiyStoreProcessorResult<List<DiyStoreItemDTO>> res = diyStoreItemDaoService.getDiyStoreItemDTOByItemId(itemId);
            if (!res.isSuccess()) {
                res.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR, true);
            }
            List<DiyStoreItemDTO> diyStoreItemDTOList = res.getModel();
            if (diyStoreItemDTOList.size() <= 0) {
                diyStoreProcessorResult.setModel(null);
                log.info("Could found the item by the itemId");
                return diyStoreProcessorResult;
            }
            DiyStoreItemDTO diyStoreItemDTO = diyStoreItemDTOList.get(0);

            DiyStoreDetailShipOrderDTO diyStoreDetailShipOrderDTO = new DiyStoreDetailShipOrderDTO();
            diyStoreDetailShipOrderDTO.setBuyerId(buyerId);
            diyStoreDetailShipOrderDTO.setDetailShipOrderId(new Date().getTime());
            diyStoreDetailShipOrderDTO.setMainShipOrderId(mainShipOrderId);
            diyStoreDetailShipOrderDTO.setItemId(itemId);
            diyStoreDetailShipOrderDTO.setItemName(diyStoreItemDTO.getItemName());
            diyStoreDetailShipOrderDTO.setItemPrice(diyStoreItemDTO.getItemPrice());
            diyStoreDetailShipOrderDTO.setAttribute(context.getAttr().toString());
            diyStoreDetailShipOrderDTO.setSellerId(201430620084L);

            DiyStoreProcessorResult<Void> res4 = diyStoreDetailShipOrderDaoService.persistDetailShipOrder(diyStoreDetailShipOrderDTO, true);
            if(!res4.isSuccess()){
                //todo rollback
                res4.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
            }
            context.setCurrentDiyStoreDetailShipOrderDTO(diyStoreDetailShipOrderDTO);
            return diyStoreProcessorResult;
        }
        else{
            if (!context.isDetailShipOrderConstruct()) return diyStoreProcessorResult;
            DiyStoreProcessorResult<DiyStoreDetailShipOrderDTO> resa = diyStoreDetailShipOrderDaoService.deleteByDetailShipOrderId(context.getCurrentDiyStoreDetailShipOrderDTO().getDetailShipOrderId());
            if(!resa.isSuccess()){
                diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
            }
            DiyStoreProcessorResult<List<DiyStoreDetailShipOrderDTO>> resb = diyStoreDetailShipOrderDaoService.queryByMainShipOrderId(context.getDiyStoreMainShipOrderDTO().getMainShipOrderId());
            if(!resb.isSuccess()){
                diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
            }
            List<DiyStoreDetailShipOrderDTO> diyStoreDetailShipOrderDTOS = resb.getModel();
            if(diyStoreDetailShipOrderDTOS.size()==0){
                DiyStoreProcessorResult<DiyStoreMainShipOrderDTO> resc =
                diyStoreMainShipOrderDaoService.deleteByMainShipOrderId(context.getDiyStoreMainShipOrderDTO().getMainShipOrderId());
                //todo : if delete error you need to rollback
                if(!resc.isSuccess()){
                    diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
                }

            }
            return diyStoreProcessorResult;
        }
    }
}
