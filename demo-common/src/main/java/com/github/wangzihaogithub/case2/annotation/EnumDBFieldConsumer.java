package com.github.wangzihaogithub.case2.annotation;

import com.github.wangzihaogithub.case2.enumer.BizEnumGroupEnum;
import com.github.wangzihaogithub.case2.po.BizEnumPO;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 枚举字段消费
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@com.github.fieldintercept.annotation.EnumDBFieldConsumer.Extends
public @interface EnumDBFieldConsumer {

    /**
     * 枚举组
     *
     * @return
     */
    BizEnumGroupEnum[] enumGroup();

    /**
     * 通常用于告知aop. id字段,或者key字段
     *
     * @return 字段名称
     */
    String[] keyField();

    /**
     * 通常用于告知aop. id字段,或者key字段
     * 支持占位符 （与spring的yaml相同， 支持spring的所有占位符表达式）， 比如 ‘${talentId} ${talentName} ${ig.env} ${random.int[25000,65000]}’
     * <p>
     * 例: 输入 "姓名${username}/部门${deptName}", 输出 "姓名xxx/部门xxx"
     * 例： valueField = { "${username}" }
     *
     * @return 字段名称
     * @see BizEnumPO#getValue() 因为BizEnumPO#getValue(), 所以这里写 {"${value}"};
     */
    String[] valueField() default {"${value}"};

    /**
     * 多个拼接间隔符
     *
     * @return
     */
    String joinDelimiter() default ",";

}