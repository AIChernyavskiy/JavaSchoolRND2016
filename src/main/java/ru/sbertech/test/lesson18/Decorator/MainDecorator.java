package ru.sbertech.test.lesson18.Decorator;


public class MainDecorator {
    public static void main(String[] args) {
        Printer printer = new ThirdDecorator(new SecondDecorator(new FirstDecorator(new A("Это пример декоратора"))));
        printer.print();
    }
}
