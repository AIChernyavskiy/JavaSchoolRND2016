package ru.sbertech.test.lesson3.classwork.examples;

import ru.sbertech.test.lesson3.classwork.Person;
import ru.sbertech.test.lesson3.classwork.PersonFirstLoad;

import java.util.LinkedList;
import java.util.List;


public class Example2_LinkedList {
    public static void main(String[] args) {
        List<Person> persons = new LinkedList<>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);
        System.out.println(persons.get(10));

        System.out.println("--------------");

    }
}
