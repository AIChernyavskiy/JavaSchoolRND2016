package ru.sbertech.test.lesson17.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainClassAfter {

    public static void main(String[] args) {
        int[] array;
        int min, max;
        array = new int[12];
        List<Integer> negativeArray;
        List<Integer> positiveArray;


        toCompleteArray(array);
        System.out.println(Arrays.toString(array));
        min = getMin(array);
        max = getMax(array);
        negativeArray = getNegativeArray(array);
        positiveArray = getPositiveArray(array);


        printMinAndMax(min, max);
        sortCollection(negativeArray, positiveArray);

        printArray(negativeArray, "Отрицательный массив");

        printArray(positiveArray, "Положительный массив");

        printAverageAndDifference(min, max);

    }

    private static void printAverageAndDifference(int min, int max) {
        int average = (min+max)/2;
        System.out.println("Среднее значение минимума и максимума равно "+ average);
        int difference = max - min;
        System.out.println("Разность между максимумом и минимумом равна: "+difference);
    }

    private static void printArray(List<Integer> negativeArray, String x) {
        System.out.println(x);
        negativeArray.forEach(System.out::println);
    }

    private static void sortCollection(List<Integer> negativeArray, List<Integer> positiveArray) {
        Collections.sort(negativeArray);
        Collections.sort(positiveArray);
    }

    private static void printMinAndMax(int min, int max) {
        System.out.println("Максимальный элемент равен: " + max);
        System.out.println("Минимальный элемент равен: " + min);
    }


    private static List<Integer> getNegativeArray(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                list.add(array[i]);
            }
        }
        return list;
    }


    private static List<Integer> getPositiveArray(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                list.add(array[i]);
            }
        }
        return list;
    }



    private static int getMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }



    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }



    private static void toCompleteArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = getRandomInteger();
        }
    }


    private static int getRandomInteger() {
        return (int) (Math.random() * 30) - 15;
    }
}