package ru.sbertech.test.lesson7.homework1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class PluginManager extends ClassLoader {
    
    private final String pluginRootDirectory;
    public HashMap hashMap;

    public PluginManager(String pluginRootDirectory,HashMap hashMap) {
        this.pluginRootDirectory = pluginRootDirectory;
        this.hashMap = hashMap;
    }

    public Class<?> load(String pluginName, String pluginClassName) throws ClassNotFoundException {
        try {
            String nameOfPluginAndClass =  pluginName + "\\" + pluginClassName+".class";
            String fullNameOfPlugin = this.pluginRootDirectory  + nameOfPluginAndClass;
            if (hashMap.size() != 0) {
                if (hashMap.containsKey(nameOfPluginAndClass)) {
                    System.out.println("Такой класс уже загружен");
                    return  null;
                } else
                    hashMap.put(nameOfPluginAndClass, fullNameOfPlugin);
            } else hashMap.put(nameOfPluginAndClass, fullNameOfPlugin);
            String file = (String) hashMap.get(nameOfPluginAndClass);

            FileInputStream fileInputStream = new FileInputStream(file);

            byte[] arraybyte = new byte[(int) (new File(file).length())];

            fileInputStream.read(arraybyte);

            fileInputStream.close();


            return defineClass(arraybyte, 0, arraybyte.length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

