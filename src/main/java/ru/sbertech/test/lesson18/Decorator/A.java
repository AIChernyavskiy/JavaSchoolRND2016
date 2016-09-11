package ru.sbertech.test.lesson18.Decorator;


public class A implements Printer{
    String string;
    public A(String s) {
        this.string=s;
    }

    @Override
    public void print() {
        System.out.print("это пример декоратора");
    }
}
