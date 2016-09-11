package ru.sbertech.test.lesson18.Decorator;


public class SecondDecorator extends Decorator {
    public SecondDecorator(Printer printer) {
        super(printer);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("]");
    }
}
