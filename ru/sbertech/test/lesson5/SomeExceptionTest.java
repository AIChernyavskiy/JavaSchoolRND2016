package JavaSchoolRND2016.ru.sbertech.test.lesson5;


import java.io.IOException;
import java.net.URL;

public class SomeExceptionTest {
    public static void main(String[] args) {
        try {
            //Integer.parseInt("I'm not number");
            if (false) {
                new URL("this is not url");
            }
            if (false) {
                new URL("www.goole.com").getContent();
            }
                int a=1/0;
        } catch (NumberFormatException e) {
            System.out.println(e.toString());
        } catch (IOException | ArithmeticException e){
            System.out.println(e.toString());
        }
    }
}
