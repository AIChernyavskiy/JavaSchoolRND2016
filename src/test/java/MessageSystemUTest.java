import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.Future;



import static ru.sbertech.test.lesson11_2.homework.MessageSystem.addFuture;

public class MessageSystemUTest {
    public ArrayList<Future<String>> arrayList;

    @Before
    public void setup() {
        arrayList = addFuture();
    }

    @Test
    public  void  addFutureTest() {
        Assert.assertFalse(arrayList.isEmpty());
    }
    @Test
    public void addTest() {
        for (Future ft:arrayList) {
            Assert.assertTrue(ft.isDone());
        }
    }
}
