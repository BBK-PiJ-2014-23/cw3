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
        
        ReturnObject index1 = arrayList.get(-1);
        assertEquals(index1.getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        ReturnObject index2 = arrayList.get(0);
        assertEquals(index2.getError(), ErrorMessage.EMPTY_STRUCTURE);
        ReturnObject index3 = arrayList.get(1);
        assertEquals(index3.getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
    }
}
