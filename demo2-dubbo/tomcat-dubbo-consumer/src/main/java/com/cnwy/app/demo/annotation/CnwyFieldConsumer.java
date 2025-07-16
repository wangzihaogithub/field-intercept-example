package com.cnwy.app.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 字段拦截赋值
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@com.github.fieldintercept.annotation.FieldConsumer.Extends
public @interface CnwyFieldConsumer {

    /**
     * 类型 [SYS_USER,CORP]
     */
    String value() default "";

    /**
     * 通常用于告知aop. id字段,或者key字段
     *
     * @return 字段名称
     */
    String[] keyField();

    /**
     * 通常用于告知aop. id字段,或者key字段
     * 支持占位符 （与spring的yaml相同， 支持spring的所有占位符表达式）， 比如 ‘${talentId} ${talentName} ${ig.env} ${random.int[25000,65000]}’
     *
     * @return 字段名称
     */
    String[] valueField() default {};

    /**
     * 多个拼接间隔符
     *
     * @return
     */
    String joinDelimiter() default ",";

    /**
     * 分类, 用于字段的路由
     *
     * @return
     */
    String type() default ",";

}
