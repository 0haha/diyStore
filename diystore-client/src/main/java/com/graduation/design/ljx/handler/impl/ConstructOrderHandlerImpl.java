package com.graduation.design.ljx.handler.impl;

import com.graduation.design.ljx.domain.annotation.Handler;
import com.graduation.design.ljx.domain.context.ConstructOrderContext;
import com.graduation.design.ljx.domain.dto.DiyStoreDetailShipOrderDTO;
import com.graduation.design.ljx.domain.dto.DiyStoreMainShipOrderDTO;
import com.graduation.design.ljx.domain.enums.ContextOperateType;
import com.graduation.design.ljx.domain.enums.DiyStoreErrorCodeEnum;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
import com.graduation.design.ljx.handler.BaseHandler;
import com.graduation.design.ljx.handler.ConstructOrderHandler;
import com.graduation.design.ljx.service.DiyStoreDetailShipOrderDaoService;
import com.graduation.design.ljx.service.DiyStoreMainShipOrderDaoService;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

/**
 * Created by hehe on 18-4-27.
 */
@Handler(name = "ConstructOrderHandlerImpl",business = "ConstructOrder")
public class ConstructOrderHandlerImpl extends BaseHandler<ConstructOrderContext> implements ConstructOrderHandler{

    @Resource
    private DiyStoreMainShipOrderDaoService diyStoreMainShipOrderDaoService;

    @Resource
    private DiyStoreDetailShipOrderDaoService diyStoreDetailShipOrderDaoService;

    @Override
    public DiyStoreProcessorResult<ConstructOrderContext> addToShoppingCart(Long itemId, Long buyerId, Map<String,String> attr) {
        DiyStoreProcessorResult<ConstructOrderContext> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
        diyStoreProcessorResult.setSuccess(true);

       if(itemId == null || buyerId == null || attr == null){
           diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
           return diyStoreProcessorResult;
       }
        ConstructOrderContext constructOrderContext = new ConstructOrderContext();
        constructOrderContext.setCurrentItemId(itemId);
        constructOrderContext.setBuyerId(buyerId);
        constructOrderContext.setAttr(attr);
        constructOrderContext.setOperateType(ContextOperateType.CONSTRUCT_ORDER_ADD.getCode());


        DiyStoreProcessorResult<Void> res = super.handle(constructOrderContext);
        if(!res.isSuccess()){
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_SCM_ERROR,true);
            return diyStoreProcessorResult;
        }
        diyStoreProcessorResult.succ(constructOrderContext);
        return diyStoreProcessorResult;
    }

    @Override
    public DiyStoreProcessorResult<ConstructOrderContext> removeFromShoppingCart(Long itemId, Long buyerId) {
        DiyStoreProcessorResult<ConstructOrderContext> diyStoreProcessorResult = new DiyStoreProcessorResult<>();

        if(itemId == null || buyerId == null ){
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
            return diyStoreProcessorResult;
        }
        ConstructOrderContext constructOrderContext = new ConstructOrderContext();
        constructOrderContext.setCurrentItemId(itemId);
        constructOrderContext.setBuyerId(buyerId);
        constructOrderContext.setOperateType(ContextOperateType.CONSTRUCT_ORDER_RM.getCode());

        DiyStoreProcessorResult<Void> res = super.handle(constructOrderContext);
        if(!res.isSuccess()){
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_SCM_ERROR,true);
            return diyStoreProcessorResult;
        }
        diyStoreProcessorResult.succ(constructOrderContext);
        return diyStoreProcessorResult;
    }
}
