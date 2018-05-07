package com.graduation.design.ljx.handler;


import com.graduation.design.ljx.aop.HandlerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Map;

/**
 * Created by hehe on 18-3-3.
 */
public class HandlerLoader implements ApplicationListener<ContextRefreshedEvent>{

    @SuppressWarnings("rawtypes")
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //todo:remove
        System.out.println("ApplicationListener!");
        Map<String, BaseHandler>  handlerMap = HandlerFactory.getHandlerMap();

        for (String name : handlerMap.keySet()) {
            BaseHandler handler = handlerMap.get(name);
            handler.init();
        }
    }

}
