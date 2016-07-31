package ru.sbertech.test.lesson6.homework;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/*
Вывести на консоль все методы класса, включая все родительские методы (включая приватные).
Вывести все геттеры класса.
Проверить что все String константы имеют значение = их имени
public static final String MONDAY = "MONDAY";
Реализовать кэширующий прокси.
 */
public class Myclass implements Myinterface  {


    public void getAllMethodsForClass(Class<?> clazz) {

        List pb = new ArrayList();
        List pr = new ArrayList();
        Object value = null;
        Class c = null;
        Object obj = null;
        Class<?> cl = clazz;

        //Получаем все геттеры класса
        Method[] arr = clazz.getDeclaredMethods();
        for (int i=0; i<arr.length;i++)
            if (isGetter(arr[i]))  pb.add(arr[i]);

        System.out.println("Геттеры класса "+cl.getSimpleName());
        for (Object m:pb) {
            System.out.println(m);
        }
        pb.clear();
        System.out.println();
        //Получаем все методы включая родительские в том числе приватные
        while (clazz != null) {
            Method[] arrMetods = clazz.getDeclaredMethods();
            for (int i=0; i<arrMetods.length; i++) {
                if (arrMetods[i].getModifiers() == Modifier.PUBLIC) {
                    pb.add(arrMetods[i]);
                }
                else pr.add(arrMetods[i]);
            }
            try {
                c = Class.forName(clazz.getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                obj = c.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            //Проверяем значения констант
            Field[] fil = clazz.getDeclaredFields();
            for (int i=0; i<fil.length; i++) {
                fil[i].setAccessible(true);
                try {
                    value =  (fil[i].get(obj));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                if (Modifier.isFinal(fil[i].getModifiers())  ) {
                    if (fil[i].getType().getSimpleName().equals("String")) {
                        if (fil[i].getName() != value.toString()) {
                            System.out.println("Поле константы "+fil[i].getName()+" имеет значение "+value.toString());
                        }
                    }
                }
                System.out.println();
            }
            clazz = clazz.getSuperclass();
        }
        System.out.println("Список публичных методов для класса  "+cl.getSimpleName()+ " и его предков");
        for (Object m:pb) {
            System.out.println(m);
        }
        System.out.println();
        System.out.println("Список не публичных методов для класса "+cl.getSimpleName()+ " и его предков");
        for (Object m:pr) {
            System.out.println(m);
        }
    }


    @Override
    public  boolean isGetter(Method method){
        return method.getName().startsWith("get");
        //if(method.getParameterTypes().length != 0)   return false;
        //if(void.class.equals(method.getReturnType())) return false;

    }
}
