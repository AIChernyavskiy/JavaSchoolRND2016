package ru.sbertech.test.lesson5;


class MyException extends Exception{

}

public class MyExceptionTest {
    public static void main(String[] args) throws MyException {
        try {
            throw new MyException();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
