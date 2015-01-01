import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class LinkedListTester.
 *
 * @author  Stefan E. Mayer
 * @version 1.1
 */
public class LinkedListTester {
    @Test
    public void test() {
        List LinkedList = new LinkedList();

        // size empty
        assertTrue(LinkedList.isEmpty());
        assertEquals(LinkedList.size(), 0);

        // get on empty structure
        assertEquals(LinkedList.get(-1).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(LinkedList.get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(LinkedList.get(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // remove on empty structure
        assertEquals(LinkedList.get(-1).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(LinkedList.get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(LinkedList.get(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        //         // add 2 via plain add
        //         assertEquals(LinkedList.add(null).getError(), ErrorMessage.INVALID_ARGUMENT);
        //         assertNull(LinkedList.add("0").getReturnValue());
        //         assertNull(LinkedList.add("1").getReturnValue());
        // 
        //         // should be two elements
        //         assertFalse(LinkedList.isEmpty());
        //         assertEquals(LinkedList.size(), 2);
        // 
        //         // two can be retrieved
        //         assertEquals(LinkedList.get(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         assertEquals(LinkedList.get(0).getReturnValue(), "0");
        //         assertEquals(LinkedList.get(1).getReturnValue(), "1");
        //         assertEquals(LinkedList.get(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        // 
        //         // two can be removed
        //         assertEquals(LinkedList.remove(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         assertEquals(LinkedList.remove(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         assertEquals(LinkedList.remove(0).getReturnValue(), "0");
        //         assertEquals(LinkedList.remove(0).getReturnValue(), "1");
        //         assertEquals(LinkedList.remove(66).getError(), ErrorMessage.EMPTY_STRUCTURE);
        // 
        //         // should be empty now
        //         assertTrue(LinkedList.isEmpty());
        //         assertEquals(LinkedList.size(), 0);
        // 
        //         // prepare for adding with index tests
        //         assertNull(LinkedList.add("0").getReturnValue());
        // 
        //         // add three via index
        //         assertEquals(LinkedList.add(0, null).getError(), ErrorMessage.INVALID_ARGUMENT);
        //         assertEquals(LinkedList.add(-1, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         assertEquals(LinkedList.add(66, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         assertNull(LinkedList.add(0, "1").getReturnValue());
        //         assertNull(LinkedList.add(0, "2").getReturnValue());
        //         assertNull(LinkedList.add(2, "3").getReturnValue());
        //         assertEquals(LinkedList.add(4, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        // 
        //         // should be 4 elements
        //         assertFalse(LinkedList.isEmpty());
        //         assertEquals(LinkedList.size(), 4);
        // 
        //         // 4 can be retrieved
        // 
        //         assertEquals(LinkedList.get(0).getReturnValue(), "2");
        //         assertEquals(LinkedList.get(1).getReturnValue(), "1");
        //         assertEquals(LinkedList.get(2).getReturnValue(), "3");
        //         assertEquals(LinkedList.get(3).getReturnValue(), "0");
        // 
        //         // 4 can be removed
        // 
        //         assertEquals(LinkedList.remove(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         assertEquals(LinkedList.remove(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         assertEquals(LinkedList.remove(3).getReturnValue(), "0");
        //         assertEquals(LinkedList.remove(2).getReturnValue(), "3");
        //         assertEquals(LinkedList.remove(1).getReturnValue(), "1");
        //         assertEquals(LinkedList.remove(0).getReturnValue(), "2");
        //         assertEquals(LinkedList.remove(66).getError(), ErrorMessage.EMPTY_STRUCTURE);
        // 
        //         // should be empty now
        // 
        //         assertTrue(LinkedList.isEmpty());
        //         assertEquals(LinkedList.size(), 0);
    }
}
