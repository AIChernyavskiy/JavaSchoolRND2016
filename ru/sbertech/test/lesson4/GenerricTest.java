package JavaSchoolRND2016.ru.sbertech.test.lesson4;


import java.util.ArrayList;
import java.util.List;

public class GenerricTest {
    public static void main(String[] args) {
        A <? extends B> a = new A<>(new B());
        //A aa = a.getParam1();
        System.out.println(a.getType());
        List <? super Number> list = new ArrayList<>();
        list.add(new Integer(10));
        list.add(new Double(11));
        list.add(new Integer(12));
        list.add(new Double(13));

        list.forEach(System.out::println);
        Object i  = list.get(0);
    }
}
