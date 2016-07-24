package JavaSchoolRND2016.ru.sbertech.test.lesson3.examples;

import JavaSchoolRND2016.ru.sbertech.test.lesson3.Person;
import JavaSchoolRND2016.ru.sbertech.test.lesson3.PersonFirstLoad;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Example2_LinkedList {
    public static void main(String[] args) {
        List<Person> persons = new LinkedList<>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);
        System.out.println(persons.get(10));

        System.out.println("--------------");

    }
}
