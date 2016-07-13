package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите первое число");
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        int a=0;
        int b=0;
        if (sc1.hasNextInt()) {
            a = sc1.nextInt();
        } else {
            System.out.println("Вы ввели не целое число");
        }
        System.out.println("Введите второе число");
        if (sc2.hasNextInt()) {
            b = sc2.nextInt();
        } else {
            System.out.println("Вы ввели не целое число");
        }
        System.out.println("Сумма чисел равна " + (a+b));// write your code here
    }
}
