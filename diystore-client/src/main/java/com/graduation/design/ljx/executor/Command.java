package com.graduation.design.ljx.executor;

import com.graduation.design.ljx.domain.context.BaseContext;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;

/**
 * Created by hehe on 18-3-4.
 */
public interface Command <C extends BaseContext>{
    DiyStoreProcessorResult<Void> execute(C context);
}
