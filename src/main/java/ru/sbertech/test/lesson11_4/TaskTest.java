package ru.sbertech.test.lesson11_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TaskTest {
    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread().getId());
        Runnable task = new Task();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(task);
        executorService.shutdown();
    }
}
