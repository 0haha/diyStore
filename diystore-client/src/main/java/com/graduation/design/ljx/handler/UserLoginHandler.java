package com.graduation.design.ljx.handler;

import com.graduation.design.ljx.domain.context.UserLoginContext;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;

/**
 * Created by hehe on 18-4-25.
 */
public interface UserLoginHandler {

    /**
     *
     * @param username
     * @param password
     * @param type
     * @return
     */
    DiyStoreProcessorResult<UserLoginContext> checkUserLogin(String username,String password,Integer type);

}
