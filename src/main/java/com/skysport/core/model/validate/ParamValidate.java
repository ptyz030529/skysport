package com.skysport.core.model.validate;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
public @interface ParamValidate {

    String name();

    String regex() default "";

    boolean required() default false;

    String errorMsg() default "";
}
