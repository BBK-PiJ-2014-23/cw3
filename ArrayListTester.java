import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class ArrayListTester.
 *
 * @author  Stefan E. Mayer
 * @version 1.0
 */
public class ArrayListTester {
    @Test
    public void test() {
        List arrayList = new ArrayList();
        assertTrue(arrayList.isEmpty());
        assertEquals(arrayList.size(), 0);
    }
}
