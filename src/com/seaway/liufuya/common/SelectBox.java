package com.seaway.liufuya.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 自定义注解，标注 实体类字段，在页面显示时，是否显示成 下拉框
 * ComboBox
 * @author lililiu
 *
 */

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SelectBox {

}
