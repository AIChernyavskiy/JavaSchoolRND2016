package JavaSchoolRND2016.ru.sbertech.test.lesson3.examples;

import JavaSchoolRND2016.ru.sbertech.test.lesson3.Person;
import JavaSchoolRND2016.ru.sbertech.test.lesson3.PersonFirstLoad;

import java.util.*;
import java.util.Map;

/**
 * Created by Student on 18.07.2016.
 */
public class Example5_Map {
    public static void main(String[] args) {
        Map<String,Person> persons = new HashMap<String,Person>();
        PersonFirstLoad.init(persons);
        PersonFirstLoad.print(persons);


        System.out.println("size= "+ persons.size());

        System.out.println(persons.get("16"));
    }
}
