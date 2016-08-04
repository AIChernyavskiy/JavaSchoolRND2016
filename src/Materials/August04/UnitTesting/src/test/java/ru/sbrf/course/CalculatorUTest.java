package ru.sbrf.course;


import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorUTest {
    int counter;
   static Calculator calculator;
    @BeforeClass
    public static   void init() {
        calculator = new Calculator();
    }

    @Before
    public void intCounter() {
        counter++;
    }

    @Test
    public void addTest() {
        Assert.assertTrue("Неверное сложени",calculator.add(2,5) == 7);
    }
}
