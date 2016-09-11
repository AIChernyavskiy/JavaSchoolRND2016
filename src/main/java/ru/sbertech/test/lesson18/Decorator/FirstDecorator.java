package ru.sbertech.test.lesson18.Decorator;


public class FirstDecorator extends Decorator {
    public FirstDecorator(Printer printer) {
        super(printer);
    }

    @Override
    public void print() {
        System.out.print("Элементарный, но ");
        super.print();
        System.out.print("!!!!");
    }
}
