package ru.sbertech.test.lesson11.classwork;


public class SomeTask implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "(" + i + ")");
        }

    }

    //
    public static void main(String[] args) {
        SomeTask st = new SomeTask();
        /*for (int i=0;i<4;i++) {
            new Thread(st).start();
        }
        */
        Thread t = new Thread(st);

        //t.setDaemon(true);

        t.start();
        System.out.println(t.isAlive());
       /* try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        //Создали поток
        //Thread t = new Thread(st);
        //В старте, создается новый объект поток, у Runnable выполняется run
        //t.start();

        System.out.println("End of main programm");
        //t.run();
    }

}
