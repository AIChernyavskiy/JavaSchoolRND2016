package ru.sbertech.test.lesson1.homework.Task2002;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
Задано n целых чисел. Выведите их сумму.
Входные данные
В первой строке задано целое число n (1 ≤ n ≤ 10000). Вторая строка содержит n целых чисел, каждое от 1 до 10000, включительно.
Выходные данные
Выведите искомую сумму.
 */

public class Task2002 {
    public static void main(String[] args) {
        File file = new File("D:/JavaSchool/Task001/src/JavaSchoolRND2016/src/ru/sbertech/test/lesson1/homework/Task2002/input_2002.txt");
        if (!file.exists()) System.out.println("Не удалось найти файл");

        try {
            Scanner input = new Scanner(file);
            int n = input.nextInt();
            if (n>10000||n<1) {
                System.out.println("Длина массива должна быть от 1 до 10000");
                return;
            }
            int[] arr = new int[n];
            int sum = 0,i=0;
            PrintWriter output = new PrintWriter("D:/JavaSchool/Task001/src/JavaSchoolRND2016/src/ru/sbertech/test/lesson1/homework/Task2002/output_2002.txt");
            while (input.hasNext()) {
                if (n>10000||n<1) {
                    System.out.println("В файле находится числа не удовлетворяющие начальным условиям. Введите числа от 1 до 10000");
                    return;
                }
                arr[i] = input.nextInt();
                sum+=arr[i];
                i++;
            }
        output.println(sum);
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
