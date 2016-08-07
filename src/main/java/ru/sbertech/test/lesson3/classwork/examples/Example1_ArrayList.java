package ru.sbertech.test.lesson3.classwork.examples;


import ru.sbertech.test.lesson3.classwork.Person;
import ru.sbertech.test.lesson3.classwork.PersonFirstLoad;

import java.util.ArrayList;
import java.util.List;

public class Example1_ArrayList {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);
        System.out.println(persons.get(10));

        System.out.println("--------------");

    }
}
