package JavaSchoolRND2016.homework.July11.Task2051;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2051 {

    public static void main(String[] args) {
        File file = new File("src/JavaSchoolRND2016/homework/July11/Task/input_2051.txt");

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
            PrintWriter output = new PrintWriter("src/JavaSchoolRND2016/homework/July11/Task/output_2051.txt");
            slovo = potok.nextLine();
            String []brackets = slovo.split("");
            ArrayList ArrL = new ArrayList(brackets.length);
            for (i=0; i<=brackets.length-1;i++)
               ArrL.add(i,brackets[i]);
            for (i=0; i<=ArrL.size()-2;i++){
               // if (ArrL.get(i)==ArrL.get(i+1)) || (ArrL.get(i)==")") continue;
               // else

               //    output.println(i);
                //output.println(i+1);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}