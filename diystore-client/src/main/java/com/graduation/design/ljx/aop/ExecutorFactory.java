package com.graduation.design.ljx.aop;

import com.graduation.design.ljx.domain.annotation.Executor;
import com.graduation.design.ljx.executor.BaseExecutor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hehe on 18-3-3.
 */
@Slf4j
public class ExecutorFactory {

    private static Map<String,Map<String,BaseExecutor>> executorMap = new HashMap();

    private static Map<String,BaseExecutor> beanExecutorMap = new HashMap();


    public static void addExecutor(String business,String beanName,BaseExecutor executor){
        beanExecutorMap.put(beanName,executor);
        executorMap.put(business,beanExecutorMap);
    }

    public static BaseExecutor getExecutorByBusinessAndBeanName(String business,String beanName){
        return executorMap.get(business).get(beanName);
    }

}
