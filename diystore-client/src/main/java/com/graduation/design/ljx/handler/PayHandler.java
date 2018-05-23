package com.graduation.design.ljx.handler;

import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;

/**
 * Created by hehe on 18-5-1.
 */
public interface PayHandler {
   DiyStoreProcessorResult<Void> pay(String price,String itemName);
}
