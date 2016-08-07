package ru.sbertech.test.lesson7.classwork;

/**
 * Created by Student on 01.08.2016.
 */
public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void info() {
        System.out.println("Hello from Person");
    }

    public void setName(String name) {
        this.name = name;
    }
}
