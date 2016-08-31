package ru.sbertech.test.lesson11_4.classwork.FutureTask;


import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        return String.valueOf(Thread.currentThread().getId());
    }
}
