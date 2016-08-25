package ru.sbertech.test.lesson11_4;


public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId());
    }
}
