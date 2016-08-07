package ru.sbertech.test.lesson1.homework.Task2051;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2051 {

    static class BracerAndIndex {
        String bracer;
        int index;
        BracerAndIndex(String bracer, int index) {
            this.bracer = bracer;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        File file = new File("D:/JavaSchool/Task001/src/JavaSchoolRND2016/src/main/java/ru/sbertech/test/lesson1/homework/Task2051/input_2051.txt");

        //Проверяем есть ли файл
        if (!file.exists()) {
            System.out.println("Не удалось найти файл");
            return;
        }

        //Инициализируем необходимые переменные
        String slovo;
        int line = 0;
        int count;
        int i;
        int n,j;
        char symbol;

        try {
            Scanner potok = new Scanner(file);
            PrintWriter output = new PrintWriter("d:\\JavaSchool\\Task001\\src\\JavaSchoolRND2016\\src\\main\\java\\ru\\sbertech\\test\\lesson1\\homework\\Task2051\\output_2051.txt");
            slovo = potok.nextLine();
            String[] brackets = slovo.split("");
            ArrayList<BracerAndIndex> ArrL = new ArrayList();
            for (i=0; i<brackets.length;i++)
                ArrL.add(new BracerAndIndex(brackets[i],i+1));
            for (i=0; i<ArrL.size()-1;i++) {
                if ((ArrL.get(i).bracer.equals("(")) && (ArrL.get(i + 1).bracer.equals(")"))) {
                    output.println(ArrL.get(i).index + " " + ArrL.get(i + 1).index);
                }

            }
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}