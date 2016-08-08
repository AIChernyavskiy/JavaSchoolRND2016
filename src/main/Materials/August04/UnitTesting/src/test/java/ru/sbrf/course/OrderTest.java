package ru.sbrf.course;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verifyZeroInteractions;

@RunWith(MockitoJUnitRunner.class)
public class OrderTest {
    @Mock
    List<String> mockList1;

    @Mock
    List<String> mockList2;

    @Test
    public void testList() {
        mockList1.add("First");
        mockList2.add("First");

        InOrder order = inOrder(mockList1,mockList2);

        order.verify(mockList1).add("First");
        order.verify(mockList2).add("First");
    }

    @After
    public void testInteractions() {
        verifyZeroInteractions(mockList1);
    }

}
