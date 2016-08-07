package ru.sbertech.test.lesson1.homework.Task2012;

import java.io.*;
import java.util.Scanner;

/*
Верно ли, что два заданных прямоугольника a1 x b1 и a2 x b2 были получены разрезанием некоторого квадрата одним прямолинейным разрезом?
Напишите программу, которая выведет YES или NO.

Входные данные
В первой строке заданы числа целые a1, b1 (1 ≤ a1,b1 ≤ 1000), во второй — числа целые a2, b2 (1 ≤ a2,b2 ≤ 1000).
Числа в строках заданы через пробел.

Выходные данные
Выведите YES или NO.
 */

public class Task2012 {

    public static void main(String[] args) {
        File file = new File("D:/JavaSchool/Task001/src/JavaSchoolRND2016/src/ru/sbertech/test/lesson1/homework/Task2012/input_2012.txt");
        //Проверяем есть ли файл
        if (!file.exists()) {
            System.out.println("Не удалось найти файл");
            return;
        }
        //Инициализируем необходимых переменные
        String otvet;
        int[] a = new int[4];
        int max1;
        int max2;
        int i=0;
        try { Scanner potok = new Scanner(file);
            //Проходим по файлу
            while (potok.hasNext()) {
                try {
                    //Преобразовываем элемент из строки в число
                    a[i] = Integer.parseInt(potok.next());
                    //Проверяем наше число условию задачи
                    if (a[i] >= 1 && a[i] <= 1000)
                        i++;
                    else {
                        System.out.println("Введенные числа не выполняют условия программы");
                        return;
                    }
                }
                //Обработка исключений на случай неудачного преобразования из строки в число
                catch (NumberFormatException e) {
                    System.out.println("Вы ввели не целые числа, попробуйте снова");
                    return;
                }
            }
            //Найдем большую сторону каждого прямоугольника.
            if (a[0]>=a[1]) max1=a[0];
                    else
                        max1=a[1];
            if (a[2]>=a[3]) max2=a[2];
                    else
                        max2=a[3];
            //Если разрезали квадрат, то большие стороны прямоугольников должны быть равны. Сравниваем большие стороны.
            if (max1==max2) otvet="YES";
                    else
                        otvet="NO";
            try (PrintWriter output = new PrintWriter("D:/JavaSchool/Task001/src/JavaSchoolRND2016/src/ru/sbertech/test/lesson1/homework/Task2012/output_2012.txt")) {
                output.print(otvet);
            }
        }
        //Обработка исключений
        catch (FileNotFoundException exception) {
            exception.printStackTrace();
            System.out.println("Файл не открыт");
        }
    }
}
