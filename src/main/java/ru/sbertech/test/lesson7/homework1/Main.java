package ru.sbertech.test.lesson7.homework1;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        HashMap hashMap = new HashMap();
        PluginManager pluginManager = new PluginManager("D:\\JavaSchool\\Task001\\out\\production\\" +
                "JavaSchool\\ru\\sbertech\\test\\lesson7\\",hashMap);
        Class clas  = pluginManager.load("homework1","PluginClassForClassLoader");
        System.out.println("class was loaded");
    }
}
