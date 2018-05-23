package com.graduation.design.ljx.aop;

import com.graduation.design.ljx.domain.annotation.Executor;
import com.graduation.design.ljx.domain.annotation.Handler;
import com.graduation.design.ljx.domain.context.BaseContext;
import com.graduation.design.ljx.domain.exception.AnnotationException;
import com.graduation.design.ljx.executor.BaseExecutor;
import com.graduation.design.ljx.handler.BaseHandler;
import com.graduation.design.ljx.util.AnnotationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.annotation.Annotation;

/**
 * Created by hehe on 18-4-26.
 */
@Slf4j
public class HandlerAnnotationBeanPostProcessor  implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        return bean;
    }


    @SuppressWarnings("unchecked")
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!(bean instanceof BaseHandler)) {
            //todo:remove
            System.out.println("PostProcess!");
            return bean;
        }

        try {
//            Class cl = Class.forName(beanName);
            Annotation annotation = AnnotationUtils.getAnnotation(bean.getClass(),Handler.class);
            if (annotation != null) {
                Handler handler = (Handler) annotation;
                BaseHandler<? extends BaseContext> handlerBean = (BaseHandler<? extends BaseContext>)bean;
                HandlerFactory.addHandler(handler,beanName,handlerBean);
                }
        }
     /*   catch(ClassNotFoundException classNotFoundException){
            log.info("ClassNotFoundException when cast class of handler of BaseHandler init.");
        }*/
        catch(AnnotationException annotationException){
            log.info("Annotation Exception When Init BaseHandler.");
        }

        return bean;
    }

}
