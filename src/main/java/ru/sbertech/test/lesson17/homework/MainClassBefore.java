package ru.sbertech.test.lesson17.homework;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainClassBefore {
    public static void main(String[] args) {
        int[] array;
        int min, max,k;
        array = new int[12];
        //Здесь могут быть любые комментарии
        List<Integer> array1 = new ArrayList<>();
        List<Integer> array2 = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            k = ((int) (Math.random() * 30) - 15);
            array[i] = k;
            //System.out.println(array[i]);
        }
        System.out.println(Arrays.toString(array));
        min = array[0];
        max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i]<0) {
                array1.add(array[i]);
            } else {
                array2.add(array[i]) ;
            }
            if (array[i]>max) {
                max = array[i];
            }
            if (array[i]<min) {
                min=array[i];
            }
        }
        System.out.println("Максимальный элемент равен: "+max);
        System.out.println("Минимальный элемент равен: "+min);
        System.out.println("Отрицательный массив");
        Collections.sort(array1);
        array1.forEach(System.out::println);
        Collections.sort(array2);
        System.out.println("Положительный массив");
        array2.forEach(System.out::println);
        int temp = (min+max)/2;
        System.out.println("Среднее значение минимума и максимума равно "+ temp);
        temp = max - min;
        System.out.println("Разность между максимумом и минимумом равна: "+temp);

    }
}
