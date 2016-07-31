package ru.sbertech.test.lesson6.homework;


import java.lang.reflect.*;

/*
Вывести на консоль все методы класса, включая все родительские методы (включая приватные).
Вывести все геттеры класса.
Проверить что все String константы имеют значение = их имени
public static final String MONDAY = "MONDAY";
Реализовать кэширующий прокси.
 */
public class Main {
    public static void main(String[] args) {
        Myinterface m = new Myclass();
        Myinterface proxy = (Myinterface) Proxy.newProxyInstance(m.getClass().getClassLoader(),m.getClass().getInterfaces(),new MyInvocationHandler(m));
        proxy.getAllMethodsForClass(B.class);

    }


}
