package JavaSchoolRND2016.ru.sbertech.test.lesson5;

import java.io.FileNotFoundException;
import java.io.IOException;

class  Parent {
    /**
     *
     * @throws FileNotFoundException 12121212
     */
    public void method() throws IOException {

    }
}

public class Child extends Parent {
    @Override
    public void method() throws IOException {


    }

    public void test (Parent a) throws IOException {
        a.method();
    }

    public static void main(String[] args) {
        Parent a = new Parent();
        Child b = new Child();

        Child ch = new Child();
       // ch.test(a);
       // ch.test(b);
    }
}
