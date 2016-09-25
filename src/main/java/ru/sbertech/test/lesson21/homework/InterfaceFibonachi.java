package ru.sbertech.test.lesson21.homework;



public interface InterfaceFibonachi {
    @Cachable(persistent = true)
    void fibonachi(int n);
    int calculate(int n);
}
