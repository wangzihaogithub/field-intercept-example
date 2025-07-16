package com.cnwy.app.demo.annotation;

import com.cnwy.app.demo.enums.SysDictTypeEnum;
import com.github.fieldintercept.CField;
import com.github.fieldintercept.annotation.EnumDBFieldConsumer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.stream.Stream;

/**
 * 枚举字段消费
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@com.github.fieldintercept.annotation.EnumDBFieldConsumer.Extends
public @interface CnwyEnumFieldConsumer {

    /**
     * 枚举组
     *
     * @return
     */
    SysDictTypeEnum[] enumGroup();

    /**
     * value解析
     *
     * @return value解析
     */
    Class<? extends EnumDBFieldConsumer.ValueParser> valueParser() default BaseEnumGroupEnumParser.class;

    /**
     * 通常用于告知aop. id字段,或者key字段
     *
     * @return 字段名称
     */
    String[] keyField();

    /**
     * 多个拼接间隔符
     *
     * @return
     */
    String joinDelimiter() default ",";

    class BaseEnumGroupEnumParser implements EnumDBFieldConsumer.ValueParser {
        @Override
        public String[] apply(CField cField) {
            CnwyEnumFieldConsumer annotation = (CnwyEnumFieldConsumer) cField.getAnnotation();
            return Stream.of(annotation.enumGroup()).map(SysDictTypeEnum::getGroup).toArray(String[]::new);
        }
    }
}
