package com.pch.common.anno;

import java.lang.annotation.*;

/**
 * @author 潘朝辉
 * @version 1.0
 * @since 2017/1/9
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Index {
    int value() default 0;
}
