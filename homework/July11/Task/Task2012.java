package JavaSchoolRND2016.homework.July11.Task;

import java.util.Scanner;

public class Task2012 {

    public static void main(String[] args) {
        System.out.println("Введите первую сторону первого прямоугольника");
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);
        Scanner sc4 = new Scanner(System.in);
        int a1,b1,a2,b2,max1,max2=0;
        if (sc1.hasNextInt()) {
            a1 = sc1.nextInt();
        } else {
            System.out.println("Вы ввели не целое число");
            return;
        }
        System.out.println("Введите вторую сторону первого прямоугольника");
        if (sc2.hasNextInt()) {
            b1 = sc2.nextInt();
        } else {
            System.out.println("Вы ввели не целое число");
            return;
        }
        System.out.println("Введите первую сторону второго прямоугольника");
        if (sc3.hasNextInt()) {
            a2 = sc2.nextInt();
        } else {
            System.out.println("Вы ввели не целое число");
            return;
        }
        System.out.println("Введите вторую сторону второго прямоугольника");
        if (sc4.hasNextInt()) {
            b2 = sc2.nextInt();
        } else {
            System.out.println("Вы ввели не целое число");
            return;
        }
        //Найдем длину больших сторон прямоугольников, если они равны, то значит разрезали квадрат.
        if (a1>b1) max1=a1; else max1=b1;
        if (a2>b2) max2=a2; else max2=b2;
        if (max1==max2) System.out.println("YES"); else System.out.println("NO");
    }
}
