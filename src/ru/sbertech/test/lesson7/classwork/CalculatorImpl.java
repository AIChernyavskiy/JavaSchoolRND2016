package ru.sbertech.test.lesson7.classwork;


public class CalculatorImpl implements Calculator {

    @Override
    public void calc() {
        System.out.println("Calc from System classLoader");
    }
}
