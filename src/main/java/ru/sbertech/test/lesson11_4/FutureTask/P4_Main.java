package ru.sbertech.test.lesson11_4.FutureTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class P4_Main {
    public static void main(String[] args) throws ExecutionException,InterruptedException {
        MyFutureRunnable futureTask = new MyFutureRunnable(new MyCallable());
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(futureTask);

        if (!futureTask.isDone()) {
            System.out.println(futureTask.get());
        }
        executorService.shutdown();
    }
}
