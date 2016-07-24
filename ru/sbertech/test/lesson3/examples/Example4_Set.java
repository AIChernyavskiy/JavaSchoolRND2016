package JavaSchoolRND2016.ru.sbertech.test.lesson3.examples;

import JavaSchoolRND2016.ru.sbertech.test.lesson3.Person;
import JavaSchoolRND2016.ru.sbertech.test.lesson3.PersonFirstLoad;

import java.util.HashSet;
import java.util.Set;

public class Example4_Set {
    public static void main(String[] args) {
        Set<Person> persons = new HashSet<>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);

        System.out.println("size= "+ persons.size());
    }
}
