package ru.sbertech.test.lesson19.homework.Strategy;


import java.util.Arrays;

public class quickSort implements Sorting {
    @Override
    public void sort(int[] Array)  {
        System.out.println("Быстрая сортировка");
        System.out.println("До сортировки: " + Arrays.toString(Array));
        Arrays.sort(Array);
        System.out.println("После сортировки: " + Arrays.toString(Array));
    }
}
