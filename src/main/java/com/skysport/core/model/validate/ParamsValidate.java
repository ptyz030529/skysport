package com.skysport.core.model.validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类说明:
 * Created by zhangjh on 2015/7/13.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ParamsValidate {

    ParamValidate[] value();

    /**
     * 是否验证图片验证码
     */
    boolean iCode() default false;

    /**
     * 是否验证重复提交
     */
    boolean postToken() default false;
}
