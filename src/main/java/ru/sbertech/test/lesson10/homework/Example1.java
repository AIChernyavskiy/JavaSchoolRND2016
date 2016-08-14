package ru.sbertech.test.lesson10.homework;


public class Example1 {
    public static void main(String[] args) {
        engine((a,b)-> a + b);
        engine((x,y)-> x * y);
        engine((x,y)-> x / y);
        engine((x,y)-> x % y);
    }
    private static void engine(Calculator calculator){
        int x = 2, y = 4;
        int result = calculator.calculate(x,y);
        System.out.println(result);
    }
}

@FunctionalInterface
interface Calculator{
    int calculate(int x, int y);
}
