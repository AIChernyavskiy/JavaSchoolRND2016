package ru.sbertech.test.lesson11_2.homework;


import java.util.concurrent.Callable;

public class Message implements Callable<String> {
    private int count;
    Message(int count) {
        this.count = count;
    }
    @Override
    public String call() throws Exception {
        return "Messsage № " + count;
    }
}
