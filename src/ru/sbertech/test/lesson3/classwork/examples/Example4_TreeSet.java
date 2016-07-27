package ru.sbertech.test.lesson3.classwork.examples;

import ru.sbertech.test.lesson3.classwork.Person;
import ru.sbertech.test.lesson3.classwork.PersonFirstLoad;

import java.util.LinkedHashSet;
import java.util.Set;

public class Example4_TreeSet {
    public static void main(String[] args) {
        Set<Person> persons = new LinkedHashSet<>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);


        System.out.println("size= "+ persons.size());
    }
}
