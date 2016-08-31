package ru.sbertech.test.lesson11_4.classwork.FutureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


public class MyFutureRunnable extends FutureTask {
    @Override
    public void run() {
        super.run();
        System.out.println("Post Method");
    }

    public MyFutureRunnable (Callable callable) {
        super(callable);
    }
}
