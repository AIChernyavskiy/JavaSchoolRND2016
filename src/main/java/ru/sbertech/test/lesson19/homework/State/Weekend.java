package ru.sbertech.test.lesson19.homework.State;


public class Weekend implements Activity {
    private int count = 0;

    @Override
    public void doSomething(Human context) {
        if (count < 3) {
            System.out.println("Отдыхаем");
            count++;
        } else {
            context.setState(new Work());
        }
    }
}
