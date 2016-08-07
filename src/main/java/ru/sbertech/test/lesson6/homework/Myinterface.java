package ru.sbertech.test.lesson6.homework;


import java.lang.reflect.Method;

public interface Myinterface {

    boolean isGetter(Method method);

    void getAllMethodsForClass(Class<?> clazz);
}
