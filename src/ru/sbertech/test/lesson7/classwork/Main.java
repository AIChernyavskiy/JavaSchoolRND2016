package ru.sbertech.test.lesson7.classwork;


import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    public static void main(String[] args) throws Exception {

        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new URL("file:/J:/lecture7.Person.jar")},null);


           /* Class<?> persClazz = urlClassLoader.loadClass("ru.sbertech.test.lesson7.classwork.Person");
            ((Person)(persClazz.newInstance())).info();

            */
        Class<?> calcClazz = urlClassLoader.loadClass("ru.sbertech.test.lesson7.classwork.CalculatorImpl");
        Calculator calculator = new CalculatorImpl();
        calculator.calc();

        calculator = (Calculator) calcClazz.newInstance();

        calculator.calc();
    }
    }


