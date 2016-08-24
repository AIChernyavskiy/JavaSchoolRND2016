package ru.sbertech.test.lesson11_3.homework;


import static ru.sbertech.test.lesson11_3.homework.Factorial.last;
import static ru.sbertech.test.lesson11_3.homework.Factorial.table;

public class Task {
    Factorial callable;
    static RuntimeException runtimeException;
    long result;

    public Task(Factorial callable) {
        this.callable = callable;
    }

    public long get() {
        if (runtimeException != null) {
            System.out.println("Произошла исключительная ситуация, на вход были переданы некорректные данные!");
            throw runtimeException;
        }
            if ((callable.k>last) || (callable.k<0)) {
                synchronized (callable) {
                    try {
                        callable.call();
                    } catch (Exception e) {
                        this.runtimeException = new RuntimeException(e);
                        throw runtimeException;
                    }
                }
            }
                return table[callable.k];
    }
}
