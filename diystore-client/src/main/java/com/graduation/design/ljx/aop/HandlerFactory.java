package com.graduation.design.ljx.aop;

import com.graduation.design.ljx.domain.annotation.Handler;
import com.graduation.design.ljx.handler.BaseHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hehe on 18-3-3.
 */
@Slf4j
public class HandlerFactory {

    private static Map<String,BaseHandler> handlerMap = new HashMap();

    public static void addHandler(Handler handlerAnnotation,String beanName,BaseHandler baseHanlder){
        handlerMap.put(beanName,baseHanlder);
    }

    public static Map<String,BaseHandler> getHandlerMap(){
        return handlerMap;
    }
}
