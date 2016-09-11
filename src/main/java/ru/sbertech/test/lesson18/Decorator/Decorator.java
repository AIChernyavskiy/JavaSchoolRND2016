package ru.sbertech.test.lesson18.Decorator;


public abstract class Decorator implements Printer {
    public Decorator(Printer printer) {
        this.printer = printer;
    }

    Printer printer;

    @Override
    public void print() {
        printer.print();
    }
}
