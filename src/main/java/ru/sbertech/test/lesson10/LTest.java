package ru.sbertech.test.lesson10;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class LTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        int sum = numbers.stream().reduce(1, (a, b) -> a + b);
        System.out.println(sum);

    }
}
