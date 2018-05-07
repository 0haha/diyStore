package com.graduation.design.ljx.aop;

import com.graduation.design.ljx.domain.annotation.Executor;
import com.graduation.design.ljx.domain.context.BaseContext;
import com.graduation.design.ljx.domain.exception.AnnotationException;
import com.graduation.design.ljx.executor.BaseExecutor;
import com.graduation.design.ljx.util.AnnotationUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by hehe on 18-3-4.
 */
@Slf4j
public class ExecutorAnnotationBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        return bean;
    }


    @SuppressWarnings("unchecked")
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!(bean instanceof BaseExecutor)) {
            //todo:remove
            System.out.println("PostProcess!");
            return bean;
        }

        try {
            //Class cl = Class.forName(beanName);
            Annotation annotation = AnnotationUtils.getAnnotation(bean.getClass(),Executor.class);
            if (annotation != null) {
                Executor executor = (Executor) annotation;
                BaseExecutor<? extends BaseContext> executorBean = (BaseExecutor<? extends BaseContext>)bean;
                String business = executor.business();
                ExecutorFactory.addExecutor(business,beanName, executorBean);
                //todo:remove
                System.out.println("PostProcess!");
            }
        }
    /*    catch(ClassNotFoundException classNotFoundException){
            log.info("ClassNotFoundException when cast class of executor of BaseHandler init.");
        }*/
        catch(AnnotationException annotationException){
            log.info("Annotation Exception When Init BaseHandler.");
        }

        return bean;
    }

}
