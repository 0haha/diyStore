package com.gradutation.design.ljx.service.impl;

import com.graduation.design.ljx.domain.dto.DiyStoreDetailShipOrderDTO;
import com.graduation.design.ljx.domain.dto.DiyStoreMainShipOrderDTO;
import com.graduation.design.ljx.domain.enums.DiyStoreErrorCodeEnum;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
import com.graduation.design.ljx.service.DiyStoreDetailShipOrderDaoService;
import com.graduation.design.ljx.service.DiyStoreMainShipOrderDaoService;
import com.gradutation.design.ljx.dao.DiyStoreBaseDao;
import com.gradutation.design.ljx.dao.DiyStoreDetailShipOrderDao;
import com.gradutation.design.ljx.dao.DiyStoreMainShipOrderDao;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreMainShipOrderDO;
import com.gradutation.design.ljx.domain.mapper.DiyStoreBaseMapper;
import com.gradutation.design.ljx.domain.mapper.DiyStoreMainShipOrderMapper;
import com.gradutation.design.ljx.domain.query.DiyStoreMainShipOrderQuery;
import com.gradutation.design.ljx.domain.query.PageQuery;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by hehe on 18-3-28.
 */
@Slf4j
public class DiyStoreMainShipOrderDaoServiceImpl extends DiyStoreBaseDaoServiceImpl<DiyStoreMainShipOrderDTO,DiyStoreMainShipOrderDO,DiyStoreMainShipOrderQuery> implements DiyStoreMainShipOrderDaoService {

    @Resource
    private DiyStoreMainShipOrderDao diyStoreMainShipOrderDao;

    @Resource
    private DiyStoreDetailShipOrderDaoService diyStoreDetailShipOrderDaoService;

    @Resource
    private TransactionTemplate orderTransactionTemplate;




    public DiyStoreBaseDao getDao(){return diyStoreMainShipOrderDao;}

    public DiyStoreBaseMapper getMapper(){return DiyStoreMainShipOrderMapper.INSTANCE;}

    @Override
    public DiyStoreProcessorResult<List<DiyStoreMainShipOrderDTO>> queryByBuyerIdAndStatus(Long buyerId, Integer status) {
        if(buyerId == null || status == null){
            DiyStoreProcessorResult<List<DiyStoreMainShipOrderDTO>> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
            log.error("query For List of DiyStoreMainShipOrderDTO Param error,buyerId:"+buyerId+" ,status:"+status);
        }
        DiyStoreMainShipOrderQuery diyStoreMainShipOrderQuery = new DiyStoreMainShipOrderQuery();
        diyStoreMainShipOrderQuery.setBuyerId(buyerId);
        diyStoreMainShipOrderQuery.setStatus(status);
        return this.queryForList(diyStoreMainShipOrderQuery, PageQuery.MAX_PAGE_SIZE);
    }

    public DiyStoreProcessorResult<List<DiyStoreMainShipOrderDTO>> queryByMainShipOrderId(Long mainShipOrderId, Long buyerId, Integer bizType) {
        if(isInValid(mainShipOrderId) || isInValid(buyerId) || isBizTypeValid(bizType)){
            DiyStoreProcessorResult<List<DiyStoreMainShipOrderDTO>> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
            log.error("query For List of DiyStoreMainShipOrderDTO Param error,mainShipOrderId:"+mainShipOrderId+" ,buyerId:"+buyerId+" ,bizType:"+bizType);
        }
        DiyStoreMainShipOrderQuery diyStoreMainShipOrderQuery = new DiyStoreMainShipOrderQuery();
        diyStoreMainShipOrderQuery.setBuyerId(buyerId);
        diyStoreMainShipOrderQuery.setBizType(bizType);
        diyStoreMainShipOrderQuery.setmainShipOrderId(mainShipOrderId);
        return this.queryForList(diyStoreMainShipOrderQuery, PageQuery.MAX_PAGE_SIZE);
    }

    public DiyStoreProcessorResult<List<DiyStoreMainShipOrderDTO>> queryAllByMainShipOrderId(Long mainShipOrderId, Long buyerId, Integer bizType) {
        return null;
    }

    public DiyStoreProcessorResult<Void> persistShipOrder(Set<DiyStoreMainShipOrderDTO> diyStoreMainShipOrderDTOSet, boolean bNewMSO) {
        if(diyStoreMainShipOrderDTOSet.size()<=0){
            DiyStoreProcessorResult<Void> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
            return diyStoreProcessorResult;
        }
        orderTransactionTemplate.setPropagationBehavior(TransactionTemplate.PROPAGATION_REQUIRED);

        DiyStoreProcessorResult<Void> diyStoreProcessorResult = (DiyStoreProcessorResult<Void>)orderTransactionTemplate.execute(
                (status)->{
                    DiyStoreProcessorResult<Void> diyStoreProcessorResult1 = new DiyStoreProcessorResult<>();
                    diyStoreProcessorResult1.setSuccess(true);
                    for(DiyStoreMainShipOrderDTO diyStoreMainShipOrderDTOTmp:diyStoreMainShipOrderDTOSet){
                        DiyStoreProcessorResult<Void> diyStoreProcessorResult2 = persistShipOrder(diyStoreMainShipOrderDTOTmp,bNewMSO);
                        if(!diyStoreProcessorResult2.isSuccess()){
                            status.setRollbackOnly();
                            diyStoreProcessorResult1.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,diyStoreProcessorResult2.getRestry());
                            log.error("Fail to persist the ship order:"+diyStoreMainShipOrderDTOTmp.toString());

                        }
                    }
                    return diyStoreProcessorResult1;
                }
        );
        return diyStoreProcessorResult;
    }

    public DiyStoreProcessorResult<Void> persistShipOrder(DiyStoreMainShipOrderDTO diyStoreMainShipOrderDTO, boolean bNewMSO) {
        if(diyStoreMainShipOrderDTO == null){
            DiyStoreProcessorResult<Void> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
        return diyStoreProcessorResult;
        }

        orderTransactionTemplate.setPropagationBehavior(TransactionTemplate.PROPAGATION_REQUIRED);

        DiyStoreProcessorResult<Void> diyStoreProcessorResult = (DiyStoreProcessorResult<Void>)orderTransactionTemplate.execute(
                (status)-> {
                    DiyStoreProcessorResult<Void> diyStoreProcessorResult1 = new DiyStoreProcessorResult<>();
                    diyStoreProcessorResult1.setSuccess(true);
                    DiyStoreProcessorResult<?> diyStoreProcessorResult2;
                    try {

                        if (bNewMSO)  diyStoreProcessorResult2=insert(diyStoreMainShipOrderDTO);
                        else diyStoreProcessorResult2=update(diyStoreMainShipOrderDTO);
                        if(!diyStoreProcessorResult2.isSuccess()){
                            status.setRollbackOnly();
                            diyStoreProcessorResult1.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,diyStoreProcessorResult2.getRestry());
                            log.error("Fail to persist the ship order:"+diyStoreMainShipOrderDTO.toString());
                        }

                    }
                    catch (Exception e){
                        status.setRollbackOnly();
                        diyStoreProcessorResult1.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
                        log.error("Fail to persist the ship order:"+diyStoreMainShipOrderDTO.toString());

                    }
                    return diyStoreProcessorResult1;
                    }
        );
        return diyStoreProcessorResult;
    }

    public DiyStoreProcessorResult<Void> updateStatus(Map<DiyStoreMainShipOrderDTO, List<DiyStoreDetailShipOrderDTO>> diyStoreMainShipOrderDTOListMap) {
        if(diyStoreMainShipOrderDTOListMap.size()<=0){
            DiyStoreProcessorResult<Void> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
            return diyStoreProcessorResult;
        }
        orderTransactionTemplate.setPropagationBehavior(TransactionTemplate.PROPAGATION_REQUIRED);
        DiyStoreProcessorResult<Void> diyStoreProcessorResult = orderTransactionTemplate.execute(
                (status)->{
                    DiyStoreProcessorResult<Void> diyStoreProcessorResult1 = new DiyStoreProcessorResult<>();
                    for(Map.Entry<DiyStoreMainShipOrderDTO,List<DiyStoreDetailShipOrderDTO>> entry:diyStoreMainShipOrderDTOListMap.entrySet()){
                        DiyStoreProcessorResult<Void> diyStoreProcessorResult2 = this.persistShipOrder(entry.getKey(),false);
                        if(!diyStoreProcessorResult2.isSuccess()){
                            status.setRollbackOnly();
                            diyStoreProcessorResult1.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,diyStoreProcessorResult2.getRestry());
                            return diyStoreProcessorResult1;
                        }
                        for(DiyStoreDetailShipOrderDTO diyStoreDetailShipOrderDTOTmp:entry.getValue()){
                            DiyStoreProcessorResult<Void> diyStoreProcessorResult3 = diyStoreDetailShipOrderDaoService.persistDetailShipOrder(diyStoreDetailShipOrderDTOTmp,false);
                            if(!diyStoreProcessorResult3.isSuccess()){
                                status.setRollbackOnly();
                                diyStoreProcessorResult1.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,diyStoreProcessorResult2.getRestry());
                                return diyStoreProcessorResult1;
                            }
                        }
                    }
                    diyStoreProcessorResult1.setSuccess(true);
                    return diyStoreProcessorResult1;
                }
        );
        return diyStoreProcessorResult;
    }

    public DiyStoreProcessorResult<Void> updateTradeSuccessTime(Date successTime, Long mainShipOrderId, Long buyerId, Integer bizType) {
        return null;
    }

    @Override
    public DiyStoreProcessorResult<DiyStoreMainShipOrderDTO> deleteByMainShipOrderId(Long id) {
        DiyStoreMainShipOrderQuery diyStoreMainShipOrderQuery = new DiyStoreMainShipOrderQuery();
        diyStoreMainShipOrderQuery.setmainShipOrderId(id);
        return super.deleteByQuery(diyStoreMainShipOrderQuery);
    }
}
