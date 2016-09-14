package ru.sbertech.test.lesson19.homework.Strategy;


import java.util.Arrays;

public class BubleSort implements Sorting {
    @Override
    public void sort(int[] Array)  {
        System.out.println("Сортировка пузырьком");
        System.out.println("До сортировки: " + Arrays.toString(Array));
        for (int i = Array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Array[j] > Array[j + 1]) {
                    int tmp = Array[j];
                    Array[j] = Array[j + 1];
                    Array[j + 1] = tmp;
                }
            }
        }
        System.out.println("После сортировки: " + Arrays.toString(Array));
    }
}
