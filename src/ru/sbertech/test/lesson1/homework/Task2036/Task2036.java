package ru.sbertech.test.lesson1.homework.Task2036;

import java.io.*;
import java.util.Scanner;

/*
Дан набор из n слов, состоящих из маленьких латинских букв.
Будем называть слово странным, если в нем встречаются 3 или более гласные буквы подряд.
Ваша задача — удалить из данного набора все странные слова.
Гласными буквами в латинском алфавите считаются e,y,u,i,o,a.

Входные данные
В первой строке содержится число n — количество слов в наборе, n не превосходит 100.
Далее в n строках по одному на строке содержатся слова из набора.
Слова состоят только из маленьких латинских букв.
Длина каждого слова не менее 1 и не более 20 символов.

Выходные данные
Выведите все слова из набора, не являющиеся странными.
Каждое слово выводите на отдельной строке в том порядке, в котором они заданы во входных данных.
 */

public class Task2036 {
    public static void main(String[] args) {
        File file = new File("D:/JavaSchool/Task001/src/JavaSchoolRND2016/src/ru/sbertech/test/lesson1/homework/Task2036/input_2036.txt");
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
            PrintWriter output = new PrintWriter("D:/JavaSchool/Task001/src/JavaSchoolRND2016/src/ru/sbertech/test/lesson1/homework/Task2036/output_2036.txt");
            try {
                //Преобразовываем элемент из строки в число
                n = Integer.parseInt(potok.nextLine());
                //Проверяем наше число условию задачи
                if (n < 1 || n > 100) {
                    System.out.println("Введенное число не выполняет условие программы");
                    return;
                }
            }
            //Обработка исключений на случай неудачного преобразования из строки в число
            catch (NumberFormatException e) {
                System.out.println("Вы ввели не целое число, попробуйте снова");
                return;
            }
            //Идем по файлу
            while (potok.hasNext()) {
                count=0;
                //Первую строку с количеством элементов в массиве пропускаем
                if (line == 0) {
                    line++;
                    continue;
                }
                //Проверяем длину текущего слова с условием задачи
                slovo = potok.next();
                j = slovo.length();
                if (j < 1 || j > 20) {
                    System.out.println("Количество символов в " + slovo + " должно быть от 1 до 20. Пожалуйста, измените слово.");
                    return;
                }
                //Посимвольно проходим текущее слово
                for (i=0; i<=j-1; i++){
                    //Проверяем символы на нижний регистр
                    symbol = slovo.charAt(i);
                    if (!Character.isLowerCase(symbol))  {
                        System.out.println("Введите слова в нижнем регистре");
                        return;
                        //Подсчитываем количество гласных подряд в слове
                    }
                    if (symbol=='e' || symbol=='y' || symbol=='u' || symbol=='i' || symbol=='o' || symbol=='a' )
                        count++;
                    else
                        count=0;
                    if (count==3) break;
                }
                //Печатаем только правильные слова
                if (count<3) output.println(slovo);
            }
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
