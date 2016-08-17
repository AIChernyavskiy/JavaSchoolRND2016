package ru.sbertech.test.lesson11.homework;

class NewThread implements Runnable {

    public void run() {

        long num = 0;

        while(num < 999999999) {
            num++;
        }

        System.out.println("Результат работы счетчика: " + num);

    }
}

class OneThread {

    public OneThread() {

        System.out.println("Запускаемсчетчик.");

        Runnable r = new NewThread();
        Thread t = new Thread(r);
        t.start();

        System.out.println("Пока выполняется циклсчетчика – Выведем это сообщение.");
                System.out.println("Ну и наверно посчитаем значение Pi в квадрате: " +
                        Math.PI * Math.PI);
    }
}

public class Main {

    public static void main(String args[]) {
        OneThread ot = new OneThread();
    }
}