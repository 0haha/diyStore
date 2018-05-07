package com.graduation.design.ljx.util;


import com.graduation.design.ljx.domain.exception.AnnotationException;

import java.lang.annotation.Annotation;

/**
 * Created by hehe on 18-3-3.
 */
public class AnnotationUtils {
    public static <A extends Annotation> A getAnnotation(Class cl,Class annotationCl) throws AnnotationException{
       if(cl.getAnnotation(annotationCl)!=null)return(A)cl.getAnnotation(annotationCl) ;
       else
           throw new AnnotationException("Null Annotation Exception When call the getAnnotation of "+cl.getName());
    }
}
