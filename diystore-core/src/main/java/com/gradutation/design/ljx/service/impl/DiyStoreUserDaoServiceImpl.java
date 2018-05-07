package com.gradutation.design.ljx.service.impl;

import com.graduation.design.ljx.domain.dto.DiyStoreBaseDTO;
import com.graduation.design.ljx.domain.dto.DiyStoreMainShipOrderDTO;
import com.graduation.design.ljx.domain.dto.DiyStoreUserDTO;
import com.graduation.design.ljx.domain.enums.DiyStoreErrorCodeEnum;
import com.graduation.design.ljx.domain.enums.UserTypeEnum;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
import com.graduation.design.ljx.service.DiyStoreMainShipOrderDaoService;
import com.graduation.design.ljx.service.DiyStoreUserDaoService;
import com.gradutation.design.ljx.dao.DiyStoreBaseDao;
import com.gradutation.design.ljx.dao.DiyStoreUserDao;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreMainShipOrderDO;
import com.gradutation.design.ljx.domain.dataobject.DiyStoreUserDO;
import com.gradutation.design.ljx.domain.mapper.DiyStoreBaseMapper;
import com.gradutation.design.ljx.domain.mapper.DiyStoreMainShipOrderMapper;
import com.gradutation.design.ljx.domain.mapper.DiyStoreUserMapper;
import com.gradutation.design.ljx.domain.query.DiyStoreMainShipOrderQuery;
import com.gradutation.design.ljx.domain.query.DiyStoreUserQuery;
import com.gradutation.design.ljx.domain.query.PageQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hehe on 18-4-6.
 */
@Slf4j
public class DiyStoreUserDaoServiceImpl extends DiyStoreBaseDaoServiceImpl<DiyStoreUserDTO,DiyStoreUserDO,DiyStoreUserQuery> implements DiyStoreUserDaoService{

    @Resource
    private DiyStoreUserDao diyStoreUserDao;

    @Resource
    private TransactionTemplate orderTransactionTemplate;

    public DiyStoreBaseDao getDao(){return diyStoreUserDao;}

    public DiyStoreBaseMapper getMapper(){return DiyStoreUserMapper.INSTANCE;}

    @Override
    public DiyStoreProcessorResult<List<DiyStoreUserDTO>> queryByBuyerName(String userName) {
        if(userName == null){
            DiyStoreProcessorResult<List<DiyStoreUserDTO>> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
            log.error("query For List of DiyStoreMainShipOrderDTO Param error,userName:"+userName);
        }
        DiyStoreUserQuery diyStoreUserQuery = new DiyStoreUserQuery();
        diyStoreUserQuery.setBuyerNick(userName);
        diyStoreUserQuery.setUserType(UserTypeEnum.BUYER.getCode());

        return this.queryForList(diyStoreUserQuery, PageQuery.MAX_PAGE_SIZE);
    }

    @Override
    public DiyStoreProcessorResult<List<DiyStoreUserDTO>> queryBySellerName(String sellerName) {
        if(sellerName == null){
            DiyStoreProcessorResult<List<DiyStoreUserDTO>> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
            log.error("query For List of DiyStoreMainShipOrderDTO Param error,userName:"+sellerName);
        }
        DiyStoreUserQuery diyStoreUserQuery = new DiyStoreUserQuery();
        diyStoreUserQuery.setSellerNick(sellerName);
        diyStoreUserQuery.setUserType(UserTypeEnum.SELLER.getCode());

        return this.queryForList(diyStoreUserQuery, PageQuery.MAX_PAGE_SIZE);

    }

    @Override
    public DiyStoreProcessorResult<Void> persistUser(DiyStoreUserDTO diyStoreUserDTO, boolean bNewUO) {
        if(diyStoreUserDTO == null){
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

                        if (bNewUO)  diyStoreProcessorResult2=insert(diyStoreUserDTO);
                        else diyStoreProcessorResult2=update(diyStoreUserDTO);
                        if(!diyStoreProcessorResult2.isSuccess()){
                            status.setRollbackOnly();
                            diyStoreProcessorResult1.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,diyStoreProcessorResult2.getRestry());
                            log.error("Fail to persist the ship order:"+diyStoreUserDTO.toString());
                        }

                    }
                    catch (Exception e){
                        status.setRollbackOnly();
                        diyStoreProcessorResult1.fail(DiyStoreErrorCodeEnum.DIY_STORE_DB_ERROR,true);
                        log.error("Fail to persist the ship order:"+diyStoreUserDTO.toString());

                    }
                    return diyStoreProcessorResult1;
                }
        );
        return diyStoreProcessorResult;
    }

    @Override
    public DiyStoreProcessorResult<List<DiyStoreUserDTO>> queryByUserId(Long userId) {
        if(isInValid(userId)){
            DiyStoreProcessorResult<List<DiyStoreUserDTO>> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
            log.error("query For List of DiyStoreMainShipOrderDTO Param error,mainShipOrderId:"+userId);
        }
        DiyStoreUserQuery diyStoreUserQuery = new DiyStoreUserQuery();
        diyStoreUserQuery.setUserId(userId);

        return this.queryForList(diyStoreUserQuery, PageQuery.MAX_PAGE_SIZE);

    }
}

