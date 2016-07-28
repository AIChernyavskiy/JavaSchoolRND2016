package ru.sbertech.test.lesson6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class InvocationHandlerImpl implements InvocationHandler {
    private final Object delegate;

    public InvocationHandlerImpl (Object delegate){
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Start " +method.getName());
        Object result = method.invoke(delegate,objects);
        System.out.println("Finish "+ method.getName());
        return result;
    }

}
