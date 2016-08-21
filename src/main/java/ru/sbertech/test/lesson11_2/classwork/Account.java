package ru.sbertech.test.lesson11_2.classwork;


public class Account implements  Runnable {


    private  final Object myLock = new Object();


    public int getSaldo() {
        return saldo;
    }

    private  int saldo;

    public Account(int saldo) {
        this.saldo = saldo;
    }

    public  void decreaseSaldo(int sum) {
        System.out.println("try decsrease saldo!");


        synchronized (myLock) {
            if (saldo - sum < 0) {
                System.out.println("Overdraft not avialable!");

            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                saldo -= sum;
            }
        }
    }
    @Override
    public void run() {
        int x=12;
        for (int i = 0; i < x; i++) {
            decreaseSaldo(10);

            if (getSaldo()<0) {
                throw  new RuntimeException("current account overdraft!!!!");
            }

        }
    }
}
