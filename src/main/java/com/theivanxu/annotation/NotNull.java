package com.theivanxu.annotation;

import java.lang.annotation.*;

/**
 * Created by xushaonan on 2018/1/10.
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface NotNull {

}
