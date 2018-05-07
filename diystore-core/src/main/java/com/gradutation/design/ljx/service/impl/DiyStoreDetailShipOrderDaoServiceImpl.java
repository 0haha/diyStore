package com.gradutation.design.ljx.service.impl;

import com.graduation.design.ljx.domain.dto.DiyStoreDetailShipOrderDTO;
import com.graduation.design.ljx.domain.enums.DiyStoreErrorCodeEnum;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
import com.graduation.design.ljx.service.DiyStoreDetailShipOrderDaoService;
import com.gradutation.design.ljx.dao.DiyStoreBaseDao;
import com.gradutation.design.ljx.dao.DiyStoreDetailShipOrderDao;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreDetailShipOrderDO;
import com.gradutation.design.ljx.domain.mapper.DiyStoreBaseMapper;
import com.gradutation.design.ljx.domain.mapper.DiyStoreDetailShipOrderMapper;
import com.gradutation.design.ljx.domain.query.DiyStoreDetailShipOrderQuery;
import com.gradutation.design.ljx.domain.query.PageQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hehe on 18-3-28.
 */
@Slf4j
public class DiyStoreDetailShipOrderDaoServiceImpl extends DiyStoreBaseDaoServiceImpl<DiyStoreDetailShipOrderDTO,DiyStoreDetailShipOrderDO,DiyStoreDetailShipOrderQuery> implements DiyStoreDetailShipOrderDaoService{

    @Resource
    private DiyStoreDetailShipOrderDao diyStoreDetailShipOrderDao;

    @Resource
    private TransactionTemplate orderTransactionTemplate;


    public DiyStoreBaseMapper<DiyStoreDetailShipOrderDTO,DiyStoreDetailShipOrderDO> getMapper(){return DiyStoreDetailShipOrderMapper.INSTANCE;}

    public DiyStoreBaseDao<DiyStoreDetailShipOrderDO,DiyStoreDetailShipOrderQuery> getDao(){return diyStoreDetailShipOrderDao;}

    public DiyStoreProcessorResult<List<DiyStoreDetailShipOrderDTO>> queryByMainShipOrderId(Long mainShipOrderId) {

        if(isInValid(mainShipOrderId)){
            DiyStoreProcessorResult<List<DiyStoreDetailShipOrderDTO>> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
            log.error("ScmDetailShipOrderDaoServiceImpl.queryByMainShipOrderId param is error. mainShipOrderId:"+mainShipOrderId);
            return diyStoreProcessorResult;
        }

        DiyStoreDetailShipOrderQuery diyStoreDetailShipOrderQuery = new DiyStoreDetailShipOrderQuery();
        diyStoreDetailShipOrderQuery.setMainShipOrderId(mainShipOrderId);

        return this.queryForList(diyStoreDetailShipOrderQuery, PageQuery.MAX_PAGE_SIZE);
    }

    public DiyStoreProcessorResult<Void> persistDetailShipOrder(DiyStoreDetailShipOrderDTO diyStoreDetailShipOrderDTO,boolean bNewMSO){
        if(diyStoreDetailShipOrderDTO == null){
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

                        if (bNewMSO)  diyStoreProcessorResult2=insert(diyStoreDetailShipOrderDTO);
                        else diyStoreProcessorResult2=update(diyStoreDetailShipOrderDTO);
                        if(!diyStoreProcessorResult2.isSuccess()){
                            status.setRollbackOnly();
                            diyStoreProcessorResult1.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,diyStoreProcessorResult2.getRestry());
                            log.error("Fail to persist the ship order:"+diyStoreDetailShipOrderDTO.toString());
                        }

                    }
                    catch (Exception e){
                        status.setRollbackOnly();
                        diyStoreProcessorResult1.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
                        log.error("Fail to persist the ship order:"+diyStoreDetailShipOrderDTO.toString());

                    }
                    return diyStoreProcessorResult1;
                }
        );
        return diyStoreProcessorResult;
    }

    @Override
    public DiyStoreProcessorResult<DiyStoreDetailShipOrderDTO> deleteByDetailShipOrderId(Long id) {
        DiyStoreDetailShipOrderQuery diyStoreDetailShipOrderQuery = new DiyStoreDetailShipOrderQuery();
        diyStoreDetailShipOrderQuery.setdetailShipOrderId(id);
        return super.deleteByQuery(diyStoreDetailShipOrderQuery);
    }
}
