package ru.sbertech.test.lesson11_4.Latch;


import static ru.sbertech.test.lesson11_4.Latch.P4_Main.endGate;
import static ru.sbertech.test.lesson11_4.Latch.P4_Main.startGate;

public class LatchExample implements Runnable {
    public void run() {
        try {
            System.out.println("before startGate.await()");
            startGate.await();
            System.out.println("after startGate.await()");
            try {
                System.out.println("Текущее состояние endGate.getCount(): "+ endGate.getCount());
            } finally {
                endGate.countDown();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

