package ru.sbertech.test.lesson11.homework;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
Два файла в ОС, один файл со словами (куча слов), распарсиваем их в массив, второй файл с размером пула.
Надо загрузить в List первый файл, посчитать количество букв, в многопоточном режиме (размер пула ограничен настройкой из файла 2).
*/


class ThreadPool implements Runnable {
    List<String> stringList;
    int firstIndex;
    int lastIndex;
    public int sumCharElement = 0;

    ThreadPool(List<String> stringList, int firstIndex, int lastIndex) {
        this.stringList = stringList;
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
    }

    @Override
    public void run() {
            for (int i = firstIndex; i < lastIndex; i++) {
                sumCharElement += stringList.get(i).replaceAll("[^a-zA-Z]", "").length();

            }
        System.out.println("Часть с " + firstIndex + " по " + lastIndex + " мы посчитали с помощью потока " + Thread.currentThread().getName());

    }
}


public class MyThreadPool {
    private static String readFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }


    public static void main(String[] args) throws IOException {
        List<Thread> threadList = new ArrayList<>();
        List<ThreadPool> threadPools = new ArrayList<>();
        String fileCount = "d:\\JavaSchool\\Task001\\src\\JavaSchoolRND2016\\src\\main\\java\\ru\\sbertech\\test\\lesson11\\homework\\CountThread.txt";
        String string = readFile(fileCount);
        int countThread = 2;
        try {
            int count = Integer.valueOf(string);
            if (count == 0)
                System.out.println("Вы ввели количество потоков равное 0, программа будет запущена по умолчанию с " + countThread + " потоками.");
            else
                countThread = count;
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не корректное число потоков");
        }

        String fileName = "d:\\JavaSchool\\Task001\\src\\JavaSchoolRND2016\\src\\main\\java\\ru\\sbertech\\test\\lesson11\\homework\\Text.txt";
        String contents = readFile(fileName);

        String[] strings = contents.split(" ");
        List<String> list = new ArrayList(Arrays.asList(strings));
        int length = list.size();
        int partSize = length / countThread;
        int firstIndex = 0;
        int lastIndex = partSize;
        if (partSize == 0) {
            threadPools.add(new ThreadPool(list, firstIndex, length));
            threadList.add(new Thread(threadPools.get(0)));
            threadList.get(0).start();
        } else {
            for (int i = 0; i < countThread; i++) {
                if (i == countThread - 1) {
                    threadPools.add(new ThreadPool(list, firstIndex, length));
                    threadList.add(new Thread(threadPools.get(i)));
                    threadList.get(i).start();
                } else {
                    threadPools.add(new ThreadPool(list, firstIndex, lastIndex));
                    threadList.add(new Thread(threadPools.get(i)));
                    threadList.get(i).start();
                    firstIndex = lastIndex;
                    lastIndex += partSize;
                }
            }
        }
        //даем всем потокам возможность закончить выполнение
        for (Thread th : threadList) {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int sumChar = 0;
        for (ThreadPool tp : threadPools) {
            sumChar += tp.sumCharElement;
        }
        System.out.println("--------------------------------");
        System.out.println("Количество букв в файле " + sumChar);

        String str = contents.replaceAll("[^a-zA-Z]", "");
        System.out.println(str);
        System.out.println(str.length());

    }
}
