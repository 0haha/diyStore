package com.graduation.design.ljx.executor.impl.userLogin;

import com.graduation.design.ljx.domain.annotation.Executor;
import com.graduation.design.ljx.domain.context.BaseContext;
import com.graduation.design.ljx.domain.context.UserLoginContext;
import com.graduation.design.ljx.domain.dto.DiyStoreUserDTO;
import com.graduation.design.ljx.domain.enums.DiyStoreErrorCodeEnum;
import com.graduation.design.ljx.domain.enums.UserTypeEnum;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
import com.graduation.design.ljx.executor.BaseExecutor;
import com.graduation.design.ljx.service.DiyStoreUserDaoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hehe on 18-4-25.
 */
@Executor(name="UserLoginChecker",business = "UserLogin",priority = 1)
public class UserLoginChecker extends BaseExecutor<UserLoginContext> {

    @Resource
    private DiyStoreUserDaoService diyStoreUserDaoService;

    @Override
    public DiyStoreProcessorResult<Void> execute(UserLoginContext context) {
        DiyStoreProcessorResult<Void> res = new DiyStoreProcessorResult<>();
        DiyStoreProcessorResult<List<DiyStoreUserDTO>> diyStoreProcessorResult = new DiyStoreProcessorResult<>();
        if(context.getUserType() == UserTypeEnum.BUYER.getCode()){
            diyStoreProcessorResult  = diyStoreUserDaoService.queryByBuyerName(context.getUserName());
           if(!diyStoreProcessorResult.isSuccess()){
               res.fail(DiyStoreErrorCodeEnum.getEnumByErrorCode(diyStoreProcessorResult.getErrorCode()),diyStoreProcessorResult.getRestry());
               return res;
           }
        }
        else if(context.getUserType() == UserTypeEnum.SELLER.getCode()){
             diyStoreProcessorResult = diyStoreUserDaoService.queryBySellerName(context.getUserName());
            if(!diyStoreProcessorResult.isSuccess()){
                res.fail(DiyStoreErrorCodeEnum.getEnumByErrorCode(diyStoreProcessorResult.getErrorCode()),diyStoreProcessorResult.getRestry());
                return res;
            }
        }
        else{
            res.fail(DiyStoreErrorCodeEnum.DIY_STORE_PARAM_ERROR,false);
            return res;
        }
        List<DiyStoreUserDTO> diyStoreUserDTOS = diyStoreProcessorResult.getModel();
        res.setSuccess(true);
        if(diyStoreUserDTOS != null || diyStoreUserDTOS.size() != 0){
            context.setRegister(true);
            DiyStoreUserDTO diyStoreUserDTO = diyStoreUserDTOS.get(0);
            if(context.getPassword().equals(diyStoreUserDTO.getPassword())){
                context.setPasswordCorrect(true);
                context.setUserId(diyStoreUserDTO.getUserId());
            }
        }
        return res;
    }
}
