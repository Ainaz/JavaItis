import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ReverseDelegateTest {
    ReverseDelegate reverseDelegate;
    @Before
    public void setUp() throws Exception {
        reverseDelegate = new ReverseDelegate();
    }

    @Test
    public void reverse() throws Exception {
        String expected = "qwerty";
        String actual = reverseDelegate.reverse("ytrewq");

        assertEquals(expected, actual);
    }

}