package ru.sbrf.course;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderControllerUTest {
    private OrderController controller;

    @Before
    public void init() {
        controller = new OrderController(new DiscountRegistryImpl());
    }

    @Test(expected = NullPointerException.class)
    public void npeItems() {
        controller.getItemDiscountForClient(new Client(), null);
    }

}


