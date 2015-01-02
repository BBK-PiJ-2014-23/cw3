import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class FunctionalArrayListTester.
 *
 * @author  Stefan E. Mayer
 * @version 1.1
 */
public class FunctionalArrayListTester {
    @Test
    public void test() {
        List functionalArrayList = new FunctionalArrayList();
        
        // size empty
        assertTrue(functionalArrayList.isEmpty());
        assertEquals(functionalArrayList.size(), 0);

        // get on empty structure
        assertEquals(functionalArrayList.get(-1).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(functionalArrayList.get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(functionalArrayList.get(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // remove on empty structure
        assertEquals(functionalArrayList.get(-1).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(functionalArrayList.get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(functionalArrayList.get(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // add 2 via plain add
        assertEquals(functionalArrayList.add(null).getError(), ErrorMessage.INVALID_ARGUMENT);
        assertNull(functionalArrayList.add("0").getReturnValue());
        assertNull(functionalArrayList.add("1").getReturnValue());

        // should be two elements
        assertFalse(functionalArrayList.isEmpty());
        assertEquals(functionalArrayList.size(), 2);

        // two can be retrieved
        assertEquals(functionalArrayList.get(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(functionalArrayList.get(0).getReturnValue(), "0");
        assertEquals(functionalArrayList.get(1).getReturnValue(), "1");
        assertEquals(functionalArrayList.get(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);

        // two can be removed
        assertEquals(functionalArrayList.remove(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(functionalArrayList.remove(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(functionalArrayList.remove(0).getReturnValue(), "0");
        assertEquals(functionalArrayList.remove(0).getReturnValue(), "1");
        assertEquals(functionalArrayList.remove(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // should be empty now
        assertTrue(functionalArrayList.isEmpty());
        assertEquals(functionalArrayList.size(), 0);

        // prepare for adding with index tests
        assertNull(functionalArrayList.add("0").getReturnValue());

        // add three via index
        assertEquals(functionalArrayList.add(0, null).getError(), ErrorMessage.INVALID_ARGUMENT);
        assertEquals(functionalArrayList.add(-1, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(functionalArrayList.add(66, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertNull(functionalArrayList.add(0, "1").getReturnValue());
        assertNull(functionalArrayList.add(0, "2").getReturnValue());
        assertNull(functionalArrayList.add(2, "3").getReturnValue());
        assertEquals(functionalArrayList.add(4, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);

        // should be 4 elements
        assertFalse(functionalArrayList.isEmpty());
        assertEquals(functionalArrayList.size(), 4);

        // 4 can be retrieved
        assertEquals(functionalArrayList.get(0).getReturnValue(), "2");
        assertEquals(functionalArrayList.get(1).getReturnValue(), "1");
        assertEquals(functionalArrayList.get(2).getReturnValue(), "3");
        assertEquals(functionalArrayList.get(3).getReturnValue(), "0");

        // 4 can be removed
        assertEquals(functionalArrayList.remove(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(functionalArrayList.remove(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(functionalArrayList.remove(3).getReturnValue(), "0");
        assertEquals(functionalArrayList.remove(2).getReturnValue(), "3");
        assertEquals(functionalArrayList.remove(1).getReturnValue(), "1");
        assertEquals(functionalArrayList.remove(0).getReturnValue(), "2");
        assertEquals(functionalArrayList.remove(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // should be empty now
        assertTrue(functionalArrayList.isEmpty());
        assertEquals(functionalArrayList.size(), 0);
    }
}