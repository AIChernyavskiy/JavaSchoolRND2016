package ru.sbertech.test.lesson19.homework.Strategy;


import java.util.Arrays;

public class selectionSort implements Sorting {
    @Override
    public void sort(int[] Array)  {
        System.out.println("Сортировка выбором");
        System.out.println("До сортировки: " + Arrays.toString(Array));
        /*По очереди будем просматривать все подмножества
      элементов массива (0 - последний, 1-последний,
      2-последний,...)*/
        for (int i = 0; i < Array.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
            int min = Array[i];
            int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
            for (int j = i + 1; j < Array.length; j++) {
                //Если находим, запоминаем его индекс
                if (Array[j] < min) {
                    min = Array[j];
                    min_i = j;
                }
            }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
            if (i != min_i) {
                int tmp = Array[i];
                Array[i] = Array[min_i];
                Array[min_i] = tmp;
            }
        }
        System.out.println("После сортировки: " + Arrays.toString(Array));
    }
}
