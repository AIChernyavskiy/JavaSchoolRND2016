package ru.sbertech.test.lesson11_2.homework;


import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MessageSystem {



    public static ArrayList addFuture() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            results.add(executorService.submit(new Message(i)));

        }
        for (Future<String> fs:results) {
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                System.out.println(e);
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                executorService.shutdown();
            }
        }
        return results;
    }

    public static void main(String[] args) {
            ArrayList arrayList = addFuture();
    }
}
