package ru.sbertech.test.lesson19.homework.Strategy;


public class Client  {
    Sorting strategy;
    public void setStrategy(Sorting strategy) {
        this.strategy=strategy;
    }
    public void runStrategy(int[] Array) {
        strategy.sort(Array);
    }
}
