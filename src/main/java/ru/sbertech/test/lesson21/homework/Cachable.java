package ru.sbertech.test.lesson21.homework;


public @interface Cachable {
    boolean persistent() default false;
}
