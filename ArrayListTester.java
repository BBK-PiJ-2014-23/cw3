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
        
        // size
        assertTrue(arrayList.isEmpty());
        assertEquals(arrayList.size(), 0);
        
        // get
        assertEquals(arrayList.get(-1).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(arrayList.get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(arrayList.get(66).getError(), ErrorMessage.EMPTY_STRUCTURE);
        
        // add with index
        assertEquals(arrayList.add(0, null).getError(), ErrorMessage.INVALID_ARGUMENT);
        assertEquals(arrayList.add(-1, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(arrayList.add(66, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        
        assertNull(arrayList.add(0, "test1").getReturnValue());
        assertNull(arrayList.add(0, "test2").getReturnValue());
        assertEquals(arrayList.get(0).getReturnValue(), "test2");
        assertEquals(arrayList.get(1).getReturnValue(), "test1");
        
        // size after
        assertFalse(arrayList.isEmpty());
        assertEquals(arrayList.size(), 2);
        
        // add plain
        assertEquals(arrayList.add(null).getError(), ErrorMessage.INVALID_ARGUMENT);
        assertNull(arrayList.add("test3").getReturnValue());
        assertEquals(arrayList.get(2).getReturnValue(), "test3");
        
        // remove
        assertEquals(arrayList.remove(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(arrayList.remove(1).getReturnValue(), "test1");
        assertEquals(arrayList.get(0).getReturnValue(), "test2");
        assertEquals(arrayList.get(1).getReturnValue(), "test3");
    }
}
