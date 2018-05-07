package com.graduation.design.ljx.domain.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by hehe on 18-3-3.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Handler {
    /**
     * Handler的名称
     */
    String name();

    /**
     * Handler business type
     */
    String business();

    /**
     * Handler的描述
     */
    String desc() default "";

}

