import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static ru.sbertech.test.lesson8.MyIterator.getIterator;

public class MyIteratorUTestEmptyArrayTest {
    public Integer[] integers;
    public Iterator iterator;
    @Before
    public void setup() {
        Integer[] integers = new Integer[]{};
        iterator = getIterator(integers);
    }

    @Test
    public  void  hasNextTest() {
        Assert.assertFalse("В массиве есть элементы",iterator.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeTest() {
        iterator.remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void nextTest() {
        iterator.next();
    }
}
