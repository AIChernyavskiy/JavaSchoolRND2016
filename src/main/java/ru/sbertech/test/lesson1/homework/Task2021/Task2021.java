package ru.sbertech.test.lesson1.homework.Task2021;

import java.io.*;
import java.util.Scanner;

/*
Задан массив из n чисел (a1, a2,..., an).
С ним два раза повторяют следующую процедуру: одновременно все максимумы в массиве делят на два.
Нечетные числа при делении на два следует округлять вниз. Ваша задача — вывести массив после этих действий.

Входные данные
В первой строке входного файла дано число n (1 ≤ n ≤ 100) — количество чисел в массиве.
Во второй строке через пробел записаны числа a1, a2,..., an (1 ≤ ai ≤ 100).

Выходные данные
Выведите массив после всех действий. Числа разделяйте пробелами.
 */

public class Task2021 {

    public static void main(String[] args) {
        File file = new File("D:/JavaSchool/Task001/src/JavaSchoolRND2016/src/ru/sbertech/test/lesson1/homework/Task2021/input_2021.txt");
        //Проверяем есть ли файл
        if (!file.exists()) {
            System.out.println("Не удалось найти файл");
            return;
        }
        //Инициализируем необходимых переменные
        int line=0;
        int i=0;
        int n;
        int max;
        try { Scanner potok = new Scanner(file);
            try {
                //Преобразовываем элемент из строки в число
                n = Integer.parseInt(potok.nextLine());
                //Проверяем наше число условию задачи
                if (n < 1 || n > 100){
                    System.out.println("Введенные числа не выполняют условия программы");
                    return;
                }
            }
            //Обработка исключений на случай неудачного преобразования из строки в число
            catch (NumberFormatException e) {
                System.out.println("Вы ввели не целые числа, попробуйте снова");
                return;
            }
            int[] a = new int[n];
            //Проходим по файлу
            while (potok.hasNext()) {
                //Первую строку с количеством элементов в массиве пропускаем
                if (line==0) {
                    line++;
                    continue;
                }
                try {
                    //Преобразовываем элемент из строки в число
                    a[i] = Integer.parseInt(potok.next());
                    //Проверяем элемент массива условию задачи
                    if (a[i] >= 1 && a[i] <= 100)
                        i++;
                    else {
                        System.out.println("Введенные числа не выполняют условия программы");
                        return;
                    }
                    //Обработка исключений на случай неудачного преобразования из строки в число
                } catch (NumberFormatException e) {
                    System.out.println("Вы ввели не целые числа, попробуйте снова");
                    return;
                }
            }
            //Выполним два раза поиск максимальных элементов в массиве и их деление на 2.
            for (int j=0; j<2; j++){
                max=0;
                //Поиск максимума
                for (i=0; i<=n-1; i++)
                    if (a[i]>max) max=a[i];
                //Деление максимального элемента попалам
                for (i=0; i<=n-1; i++)
                    if (a[i]==max) a[i] /=2;
            }
            try (PrintWriter output = new PrintWriter("D:/JavaSchool/Task001/src/JavaSchoolRND2016/src/ru/sbertech/test/lesson1/homework/Task2021/output_2021.txt")) {
                //Выводим массив в файл.
                for (i=0; i<=n-1; i++)
                output.print(a[i]+" ");
            }
        }
        //Обработка исключений
        catch (FileNotFoundException exception) {
            exception.printStackTrace();
            System.out.println("Файл не открыт");
        }
    }
}