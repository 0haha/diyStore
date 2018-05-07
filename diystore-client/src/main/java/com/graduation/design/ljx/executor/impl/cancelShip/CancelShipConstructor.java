package com.graduation.design.ljx.executor.impl.cancelShip;

import com.graduation.design.ljx.domain.annotation.Executor;
import com.graduation.design.ljx.domain.context.BaseContext;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
import com.graduation.design.ljx.executor.BaseExecutor;

/**
 * Created by hehe on 18-3-5.
 */
@Executor(name="CancelShipConstructor",business = "CancelShip",priority = 1)
public class CancelShipConstructor extends BaseExecutor<BaseContext>{

  public DiyStoreProcessorResult execute(BaseContext context){
      DiyStoreProcessorResult diyStoreProcessorResult = new DiyStoreProcessorResult();
      return diyStoreProcessorResult;
  }

}
