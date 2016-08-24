package ru.sbertech.test.lesson11_3.homework;


import java.util.concurrent.Callable;

public class Factorial implements Callable<Long> {

     int k;
    static long[] table = new long[21];
    static {table[0]=1;}
    static  int last = 0;

    public Factorial(int k) {
        this.k = k;
    }

    @Override
    public Long call() throws Exception {
        if (k>=table.length)
            throw new IllegalArgumentException("Значения переполнены");
        if (k<0)
            throw new IllegalArgumentException("вычисляемое значение не может быть отрицательным");
        while(last < k) {
            table[last + 1] = table[last] * (last + 1);
            last++;
        }
        return table[k];
    }
}
