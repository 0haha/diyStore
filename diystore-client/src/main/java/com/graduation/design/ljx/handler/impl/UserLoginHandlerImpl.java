package com.graduation.design.ljx.handler.impl;

import com.graduation.design.ljx.domain.annotation.Handler;
import com.graduation.design.ljx.domain.context.UserLoginContext;
import com.graduation.design.ljx.domain.enums.DiyStoreErrorCodeEnum;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
import com.graduation.design.ljx.handler.BaseHandler;
import com.graduation.design.ljx.handler.UserLoginHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by hehe on 18-4-25.
 */
@Slf4j
@Handler(name = "UserLoginHandlerImpl",business = "UserLogin")
public class UserLoginHandlerImpl extends BaseHandler implements UserLoginHandler {

    @Override
    public DiyStoreProcessorResult<UserLoginContext> checkUserLogin(String username, String password, Integer type) {

        UserLoginContext userLoginContext = new UserLoginContext();
        userLoginContext.setUserName(username);
        userLoginContext.setPassword(password);
        userLoginContext.setUserType(type);
        userLoginContext.setBizType("UserLogin");
        DiyStoreProcessorResult<UserLoginContext> diyStoreProcessorResult = super.handle(userLoginContext);
        diyStoreProcessorResult.setModel(userLoginContext);
        if(!diyStoreProcessorResult.isSuccess())
            diyStoreProcessorResult.fail(DiyStoreErrorCodeEnum.DIY_STORE_SCM_ERROR,true);
        else
            diyStoreProcessorResult.setSuccess(true);
        return diyStoreProcessorResult;
    }
}
