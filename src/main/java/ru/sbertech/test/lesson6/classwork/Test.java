package ru.sbertech.test.lesson6.classwork;


import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> loggerList = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(),list.getClass().getInterfaces(),new InvocationHandlerImpl(list));
        loggerList.add("first");
        System.out.println(loggerList.get(0));
        System.out.println(loggerList.remove(0));

    }
}
