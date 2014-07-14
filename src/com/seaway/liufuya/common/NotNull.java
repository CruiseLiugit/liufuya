package com.seaway.liufuya.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义一个非空注解，用于给表单中文本框加必须输入的 * 
 * @author lililiu
 *
 */

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNull {

}
