package JavaSchoolRND2016.ru.sbertech.test.lesson3.examples;

import JavaSchoolRND2016.ru.sbertech.test.lesson3.Person;
import JavaSchoolRND2016.ru.sbertech.test.lesson3.PersonFirstLoad;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Example4_TreeSet {
    public static void main(String[] args) {
        Set<Person> persons = new LinkedHashSet<>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);


        System.out.println("size= "+ persons.size());
    }
}
