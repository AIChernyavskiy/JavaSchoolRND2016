package ru.sbertech.test.lesson7.homework.Load;

import ru.sbertech.test.lesson7.homework.ISexyInterface;
import ru.sbertech.test.lesson7.homework.*;

import java.util.HashMap;



public class Loader

{

    public static void main(String[] args) throws Exception

    {



        HashMap mappings = new HashMap();

        mappings.put("ru.sbertech.test.lesson7.homework.SexyClassForLoader", "D:\\JavaSchool\\Task001\\out\\production\\JavaSchool\\ru\\sbertech\\test\\lesson7\\homework\\SexyClassForLoader.class");



        // Если убрать комментарий - будет больно

        /*

            mappings.put("sexypackage.ISexyInterface",

            "путь\\classes\\sexypackage\\ISexyInterface.class");

        */



        XLoader xloa = new XLoader(mappings);

        Class sexy_cla = xloa.loadClass("ru.sbertech.test.lesson7.homework.SexyClassForLoader");
        //Class sexy_cla1 = xloa.loadClass("ru.sbertech.test.lesson7.homework.SexyClassForLoader");

        System.out.println("class was loaded");

        System.out.println("begin object creation");



        Object sexy_ob = sexy_cla.newInstance();

        System.out.println("object was created");

        System.out.println("invoke: getFoo" + sexy_cla.getMethod("getSimpleFoo").invoke(sexy_ob));

        System.out.println("get: stat_foo" + sexy_cla.getField("stat_foo").get(sexy_ob));



        ISexyInterface local_sexy = (ISexyInterface) sexy_ob;

        local_sexy.makeBar();

    }

}