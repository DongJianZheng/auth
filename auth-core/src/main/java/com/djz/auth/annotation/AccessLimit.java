package com.djz.auth.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;


/**
 * @author djz
 */
@Target( { ElementType.METHOD } )
@Retention( RetentionPolicy.RUNTIME )
@Documented
public @interface AccessLimit {

    /**
     * 每秒向桶中放入令牌的数量   默认最大即不做限流
     * @return double
     */
    double perSecond() default Double.MAX_VALUE;

    /**
     * 获取令牌的等待时间  默认0
     * @return int
     */
    int timeOut() default 0;

    /**
     * 超时时间单位
     * @return TimeUnit
     */
    TimeUnit timeOutUnit() default TimeUnit.MILLISECONDS;
}
