package JavaSchoolRND2016.ru.sbertech.test.lesson3.BeforeGenerics;

import JavaSchoolRND2016.ru.sbertech.test.lesson3.Person;

import java.util.Collection;
import java.util.List;

public class PersonFirstLoad {
    public static Collection<Person> init(Collection<Person> person){
        person.add(new Person(1l,"Байда ИльяВдадимирович","988827277"));

    }
}
