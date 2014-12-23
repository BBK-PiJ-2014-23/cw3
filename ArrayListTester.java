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
        ReturnObject index3 = arrayList.get(66);
        assertEquals(index3.getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);

        ReturnObject nullAdd = arrayList.add(0, null);
        assertEquals(nullAdd.getError(), ErrorMessage.INVALID_ARGUMENT);
        ReturnObject addOutOfBounds1 = arrayList.add(-1, "test");
        assertEquals(addOutOfBounds1.getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        ReturnObject addOutOfBounds2 = arrayList.add(66, "test");
        assertEquals(addOutOfBounds2.getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        ReturnObject add1 = arrayList.add(0, "test1");
        assertNull(add1.getReturnValue());
        ReturnObject add2 = arrayList.add(0, "test2");
        assertNull(add2.getReturnValue());
        assertEquals(arrayList.get(0).getReturnValue(), "test2");
        assertEquals(arrayList.get(1).getReturnValue(), "test1");
        assertFalse(arrayList.isEmpty());
        assertEquals(arrayList.size(), 2);
        
        assertEquals(nullAdd.getError(), ErrorMessage.INVALID_ARGUMENT);
        ReturnObject add3 = arrayList.add("test3");
        assertNull(add3.getReturnValue());
        assertEquals(arrayList.get(2).getReturnValue(), "test3");
    }
}
