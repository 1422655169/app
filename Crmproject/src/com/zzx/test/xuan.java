package com.zzx.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface xuan {
    //此处设置的是注解的参数
    //数据类型 参数名();
    int a ();
    //int a () default 1;
    String [] arr();



}
