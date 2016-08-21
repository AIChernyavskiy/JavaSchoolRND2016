package ru.sbertech.test.lesson11_2.classwork;


public class Main {

    public static void main(String[] args) {
       /* Account account = new Account(100);
        int x=3;

        for (int i = 0; i < x; i++) {
            new Thread(account).start();
        }
        */

       /* Sqare sqare = new Sqare(2,3,4);
        Thread t1 = new Thread(sqare);
        Thread t2 = new Thread(sqare);

        t1.start();
        t2.start();
        */
        /*Test t = new Test();

        Thread t1 = new Thread(t);
        t1.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.end();
        System.out.println("End of main");
        */
       /* Date dat1 = new Date();
        System.out.println(dat1);
        Man ivan = new Man("Ivan",dat1);
        System.out.println(ivan.getDate());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ivan.getDate().setTime(new Date().getTime());
        dat1.setTime(new Date().getTime());
        System.out.println(ivan.getDate());
        ivan.getDate().setTime(0);
        */

        /*
        Test t = new Test();
        Thread tr = new Thread(t);
        tr.start();
        tr.interrupt();
        */

        MonitorExample monitorExample = new MonitorExample();

        Thread tr = new Thread(monitorExample);
        tr.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        monitorExample.sendMessage("Hello!!!!");

    }
}
