package com.gradutation.design.ljx.service.impl;

import com.graduation.design.ljx.domain.dto.DiyStoreAddressDTO;
import com.graduation.design.ljx.domain.dto.DiyStoreDetailShipOrderDTO;
import com.graduation.design.ljx.domain.dto.DiyStoreMainShipOrderDTO;
import com.graduation.design.ljx.domain.enums.DiyStoreErrorCodeEnum;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
import com.graduation.design.ljx.service.DiyStoreAddressDaoService;
import com.gradutation.design.ljx.dao.DiyStoreAddressDao;
import com.gradutation.design.ljx.dao.DiyStoreBaseDao;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreAddressDO;
import com.gradutation.design.ljx.domain.mapper.DiyStoreAddressMapper;
import com.gradutation.design.ljx.domain.mapper.DiyStoreBaseMapper;
import com.gradutation.design.ljx.domain.query.DiyStoreAddressQuery;
import com.gradutation.design.ljx.domain.query.DiyStoreDetailShipOrderQuery;
import com.gradutation.design.ljx.domain.query.PageQuery;
import com.gradutation.design.ljx.service.DiyStoreBaseDaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hehe on 18-4-8.
 */
@Slf4j
public class DiyStoreAddressDaoServiceImpl extends DiyStoreBaseDaoServiceImpl<DiyStoreAddressDTO,DiyStoreAddressDO,DiyStoreAddressQuery> implements DiyStoreAddressDaoService{

    @Resource
    private DiyStoreAddressDao diyStoreAddressDao;

    @Resource
    private TransactionTemplate orderTransactionTemplate;

    public DiyStoreBaseDao<DiyStoreAddressDO, DiyStoreAddressQuery> getDao(){return this.diyStoreAddressDao;}

    public DiyStoreBaseMapper<DiyStoreAddressDTO,DiyStoreAddressDO> getMapper(){return DiyStoreAddressMapper.INSTANCE;}

    @Override
    public DiyStoreProcessorResult<Void> persistAddress(DiyStoreAddressDTO diyStoreAddressDTO, boolean bNewAO) {
        if(diyStoreAddressDTO == null){
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

                        if (bNewAO)  diyStoreProcessorResult2=insert(diyStoreAddressDTO);
                        else diyStoreProcessorResult2=update(diyStoreAddressDTO);
                        if(!diyStoreProcessorResult2.isSuccess()){
                            status.setRollbackOnly();
                            diyStoreProcessorResult1.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,diyStoreProcessorResult2.getRestry());
                            log.error("Fail to persist the ship order:"+diyStoreAddressDTO.toString());
                        }

                    }
                    catch (Exception e){
                        status.setRollbackOnly();
                        diyStoreProcessorResult1.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
                        log.error("Fail to persist the ship order:"+diyStoreAddressDTO.toString());

                    }
                    return diyStoreProcessorResult1;
                }
        );
        return diyStoreProcessorResult;

    }

    @Override
    public DiyStoreProcessorResult<List<DiyStoreAddressDTO>> queryByAddressId(Long addressId) {
        if(isInValid(addressId)){
            DiyStoreProcessorResult<List<DiyStoreAddressDTO>> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
            log.error("ScmDetailShipOrderDaoServiceImpl.queryByMainShipOrderId param is error. mainShipOrderId:"+addressId);
            return diyStoreProcessorResult;
        }

        DiyStoreAddressQuery diyStoreAddressQuery = new DiyStoreAddressQuery();
        diyStoreAddressQuery.setAddressId(addressId);

        return this.queryForList(diyStoreAddressQuery, PageQuery.MAX_PAGE_SIZE);

    }

    @Override
    public DiyStoreProcessorResult<List<DiyStoreAddressDTO>> queryByUserId(Long userId) {
        if(isInValid(userId)){
            DiyStoreProcessorResult<List<DiyStoreAddressDTO>> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
            log.error("ScmDetailShipOrderDaoServiceImpl.queryByMainShipOrderId param is error. mainShipOrderId:"+userId);
            return diyStoreProcessorResult;
        }

        DiyStoreAddressQuery diyStoreAddressQuery = new DiyStoreAddressQuery();
        diyStoreAddressQuery.setUserId(userId);

        return this.queryForList(diyStoreAddressQuery, PageQuery.MAX_PAGE_SIZE);

    }
}
