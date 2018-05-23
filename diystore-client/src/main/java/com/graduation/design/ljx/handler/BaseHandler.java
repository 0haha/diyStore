package com.graduation.design.ljx.handler;

import com.graduation.design.ljx.aop.ExecutorFactory;
import com.graduation.design.ljx.domain.annotation.Executor;
import com.graduation.design.ljx.domain.annotation.Handler;
import com.graduation.design.ljx.domain.context.BaseContext;
import com.graduation.design.ljx.domain.enums.DiyStoreErrorCodeEnum;
import com.graduation.design.ljx.domain.exception.AnnotationException;
import com.graduation.design.ljx.domain.processorResult.DiyStoreProcessorResult;
import com.graduation.design.ljx.executor.BaseExecutor;
import com.graduation.design.ljx.util.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.TreeMap;


/**
 * Created by hehe on 18-3-3.
 */

import lombok.extern.slf4j.Slf4j;

@Slf4j
public  class BaseHandler<C extends BaseContext> {

    protected Map<Integer,BaseExecutor> commands = new TreeMap<Integer, BaseExecutor>();

    protected  String[] executors;

    protected boolean isInit = false;

    public String[] getExecutors() {
        return executors;
    }

    public void setExecutors(String[] executors) {
        this.executors = executors;
    }

    synchronized protected void init(){
        if(isInit)return;
        try {
            Handler handler = AnnotationUtils.getAnnotation(this.getClass(),Handler.class);
            String business = handler.business();
            for(String executor:executors){
               BaseExecutor baseExecutor = ExecutorFactory.getExecutorByBusinessAndBeanName(business,executor);
//               Class cl = Class.forName(executor);
               Annotation annotation = AnnotationUtils.getAnnotation(baseExecutor.getClass(),Executor.class);
               Integer priority = ((Executor) annotation).priority();
               this.addCommand(priority,baseExecutor);

            }
            isInit=true;
        }
        catch(AnnotationException annotationException){
            log.info("Annotation Exception When Init BaseHandler.");
        }
       /* catch (ClassNotFoundException classNotFoundExeception){
            log.info("ClassNotFoundException when cast class of executor of BaseHandler init.");
        }*/
    }

    protected void addCommand(Integer priority,BaseExecutor baseExecutor){
         commands.put(priority,baseExecutor);
    }

    protected DiyStoreProcessorResult<Void> handle(C context){
        int n = commands.size();
        DiyStoreProcessorResult<?> diyStoreProcessorResult = null;
        DiyStoreProcessorResult<Void> result = new DiyStoreProcessorResult<>();
        result.setSuccess(true);
        for(int i = 1;i<=n;i++){
            BaseExecutor<C> baseExecutor = commands.get(i);
            diyStoreProcessorResult = baseExecutor.execute(context);
            if(diyStoreProcessorResult == null || !diyStoreProcessorResult.isSuccess()){
                result.fail(DiyStoreErrorCodeEnum.DIY_STORE_SCM_ERROR,true);
                log.error("Handle error when call the execute of "+baseExecutor.getClass().getAnnotation(Executor.class).name());
                break;
            }
        }
        return result;
    }
}
