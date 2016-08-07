package ru.sbertech.test.lesson7.homework;



import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.HashMap;



/**

 * Класс-загрузчик

 */

public class XLoader extends ClassLoader

{

    // карта отображения имен классов на файлы .class, где хранятся их определения

    HashMap mappings;



    public XLoader(HashMap mappings)

    {

        this.mappings = mappings;

    }



    public synchronized Class loadClass(String name) throws ClassNotFoundException

    {

        try

        {

            System.out.println("loadClass (" + name + ")");



            // важно!

            // приоритет отдан именно загрузке с помощью встроенного загрузчика

            if (!mappings.containsKey(name))

            {

                return super.findSystemClass(name);

            }



            String fileName = (String) mappings.get(name);

            FileInputStream fin = new FileInputStream(fileName);

            byte[] bbuf = new byte[(int)(new File(fileName).length())];

            fin.read(bbuf);

            fin.close();



            return defineClass(name, bbuf, 0, bbuf.length);

        }

        catch (IOException e)

        {

            e.printStackTrace();

            throw new ClassNotFoundException(e.getMessage(), e);

        }

    }

}