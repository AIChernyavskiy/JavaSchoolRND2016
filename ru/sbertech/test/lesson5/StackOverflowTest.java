package JavaSchoolRND2016.ru.sbertech.test.lesson5;

public class StackOverflowTest {
    static int count=0;
    public static void main(String[] args) {
        System.out.println(count++);
        main(args);
    }
}
