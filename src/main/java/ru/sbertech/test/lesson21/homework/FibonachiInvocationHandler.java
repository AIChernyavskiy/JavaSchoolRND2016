package ru.sbertech.test.lesson21.homework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;




public class FibonachiInvocationHandler implements InvocationHandler {
    private final Object delegate;

    public FibonachiInvocationHandler(Object o) {
        delegate = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        Cachable cach = method.getAnnotation(Cachable.class);
        if (!cach.persistent()) {
            Method m = delegate.getClass().getMethod("calculate", int.class);
            result = m.invoke(delegate, args);
            System.out.println("Мы вызвали не кеширующий метод " + m.getName() + " с результатом: " + result);
        } else {
            method.invoke(delegate, args);
        }
        return result;
    }
}
