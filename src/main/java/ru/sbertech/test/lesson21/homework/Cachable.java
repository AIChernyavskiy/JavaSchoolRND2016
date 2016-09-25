package ru.sbertech.test.lesson21.homework;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Cachable {
    boolean persistent() default false;
}
