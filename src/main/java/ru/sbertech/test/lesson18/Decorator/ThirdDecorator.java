package ru.sbertech.test.lesson18.Decorator;


public class ThirdDecorator extends Decorator {
    public ThirdDecorator(Printer printer) {
        super(printer);
    }

    @Override
    public void print() {
        System.out.print("[");
        super.print();
    }
}
