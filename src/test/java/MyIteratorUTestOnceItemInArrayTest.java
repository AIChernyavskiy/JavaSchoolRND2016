import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static ru.sbertech.test.lesson8.MyIterator.getIterator;


public class MyIteratorUTestOnceItemInArrayTest {
        public Integer[] integers;
        public Iterator iterator;
        @Before
        public void setup() {
            Integer[] integers = new Integer[]{0};
            iterator = getIterator(integers);
        }

        @Test
        public  void  hasNextTest() {
            Assert.assertTrue("В массиве есть элемент",iterator.hasNext());
            Assert.assertTrue("В массиве есть элемент",iterator.hasNext());
        }

        @Test(expected = UnsupportedOperationException.class)
        public void removeTest() {
            iterator.remove();
        }

        @Test
        public void nextTest() {
            iterator.next();
        }
    @Test
    public  void  hasNextTestNext() {
        Assert.assertTrue("В массиве есть элемент",iterator.hasNext());
        iterator.next();
        Assert.assertFalse("В массиве не один элемент",iterator.hasNext());
    }
}
