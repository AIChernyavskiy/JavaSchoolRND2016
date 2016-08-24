package ru.sbertech.test.lesson11_3.homework;




public class Main {
    public static void main(String[] args) {
        Task task = new Task(new Factorial(10));
        Task task1 = new Task(new Factorial(4));
        System.out.println(task.get());
        System.out.println(task1.get());
        Task task2 = new Task(new Factorial(-1));
        System.out.println(task2.get());

    }
}
