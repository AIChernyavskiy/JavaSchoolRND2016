package JavaSchoolRND2016.ru.sbertech.test.lesson4;


public class A <T>{
    T param1;

    public A (T param) {
        this.param1 = param;
    }


    public T getParam1() {
        return param1;
    }

    public void setParam1(T param1) {
        this.param1 = param1;
    }


    public String getType() {
        return  param1.getClass().getTypeName();
    }
    public static Integer getInteger(){
        return new Integer(10);
    }
}
