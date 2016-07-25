package JavaSchoolRND2016.ru.sbertech.test.lesson5;


class  SBTEmployee {

    public SBTEmployee(int grade){
        if ((grade<0) ||(grade>16)){
            throw  new IllegalArgumentException();
        }
    }
}
//Второй сотрудник был создан не правильно.
public class IAETest {
    public static void main(String[] args) {
        SBTEmployee sbtEmployee1 = new SBTEmployee(2);
        SBTEmployee sbtEmployee2 = new SBTEmployee(20);
    }
}
