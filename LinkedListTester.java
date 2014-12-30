import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class ArrayListTester.
 *
 * @author  Stefan E. Mayer
 * @version 1.0
 */
public class LinkedListTester {
    @Test
    public void test() {
        List linkedList = new LinkedList();

        // size
        assertTrue(linkedList.isEmpty());
        assertEquals(linkedList.size(), 0);

        // get
        assertEquals(linkedList.get(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(linkedList.get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(linkedList.get(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         
        //         // add with index
        //         assertEquals(linkedList.add(0, null).getError(), ErrorMessage.INVALID_ARGUMENT);
        //         assertEquals(linkedList.add(-1, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         assertEquals(linkedList.add(66, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         
        //         assertNull(linkedList.add(0, "test1").getReturnValue());
        //         assertNull(linkedList.add(0, "test2").getReturnValue());
        //         assertEquals(linkedList.get(0).getReturnValue(), "test2");
        //         assertEquals(linkedList.get(1).getReturnValue(), "test1");
        //         
        //         // size after
        //         assertFalse(linkedList.isEmpty());
        //         assertEquals(linkedList.size(), 2);
        //         
        //         // add plain
        //         assertEquals(linkedList.add(null).getError(), ErrorMessage.INVALID_ARGUMENT);
        //         assertNull(linkedList.add("test3").getReturnValue());
        //         assertEquals(linkedList.get(2).getReturnValue(), "test3");
        //         
        //         // remove
        //         assertEquals(linkedList.remove(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         assertEquals(linkedList.remove(1).getReturnValue(), "test1");
        //         assertEquals(linkedList.get(0).getReturnValue(), "test2");
        //         assertEquals(linkedList.get(1).getReturnValue(), "test3");
    }
}
