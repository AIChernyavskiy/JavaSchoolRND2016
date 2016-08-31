package ru.sbertech.test.lesson11_4.classwork;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ReminderMessenger {
    private static ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        Task task = new Task();
        service.scheduleAtFixedRate(task,0,5, TimeUnit.SECONDS);
       // service.shutdown();

    }
}
