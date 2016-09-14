package ru.sbertech.test.lesson19.homework.State;


public class Work implements Activity {
    @Override
    public void doSomething(Human context)  {
        System.out.println("Работаем!!!!");
        context.setState(new Weekend());
    }
}
