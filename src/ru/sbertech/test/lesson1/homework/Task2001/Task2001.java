package ru.sbertech.test.lesson1.homework.Task2001;

import java.io.*;
import java.util.Scanner;


/* 2001. Заданы a и b. Выведите a+b.
Входные данные
В единственной строке входных данных заданы целочисленные a и b (1 ≤ a,b ≤ 1000).
*/

public class Task2001 {
    public static void main(String[] args) throws  IOException {

        File file = new File("src/homework/July11/Task2001/input_2001.txt");
        //Проверяем есть ли файл
        if (!file.exists()) {
            System.out.println("Не удалось найти файл");
            return;
        }
        try {Scanner potok = new Scanner(file);
            int summa = 0;
            //Проходим по файлу
            while (potok.hasNext()) {
                //Берем очередной элемент
                String element = potok.next();
                try {
                    //Преобразовываем элемент из строки в число
                    int chislo = Integer.parseInt(element);
                    //Проверяем наше число условию задачи
                    if (chislo>=1 && chislo <=1000)
                        summa += chislo;
                } catch (NumberFormatException e){ //
                    System.out.println("Вы ввели не целые числа, попробуйте снова");
                    return;
                }
            }

            try (PrintWriter output = new PrintWriter("src/homework/July11/Task2001/output_2001.txt")) {
                output.print(summa);
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace(new PrintWriter("src/homework/July11/Task2001/log.txt"));
            System.out.println("Файл не открыт");
        }

    }
}
