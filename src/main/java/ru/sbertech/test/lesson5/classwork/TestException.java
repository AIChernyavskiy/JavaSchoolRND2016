package ru.sbertech.test.lesson5.classwork;


public class TestException {
    public static void main(String[] args) {
        a();
    }
        private static void a(){
            b();
    }
    private static void b(){
        c();

    }
    private static void c(){
        int x=1;
        int y=1;
        System.out.println(x/y);

    }
    }
