package JavaSchoolRND2016.ru.sbertech.test.lesson3.BeforeGenerics;


public class Apple {
    final Long id=counter++;
    static Long counter = new Long(0L);

    public Long getId() {
        return id;
    }
}
