import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class ArrayListTester.
 *
 * @author  Stefan E. Mayer
 * @version 1.1
 */
public class ArrayListTester {
    @Test
    public void test() {
        List arrayList = new ArrayList();

        // size empty
        assertTrue(arrayList.isEmpty());
        assertEquals(arrayList.size(), 0);

        // get on empty structure
        assertEquals(arrayList.get(-1).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(arrayList.get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(arrayList.get(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // remove on empty structure
        assertEquals(arrayList.get(-1).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(arrayList.get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(arrayList.get(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // add 2 via plain add
        assertEquals(arrayList.add(null).getError(), ErrorMessage.INVALID_ARGUMENT);
        assertNull(arrayList.add("0").getReturnValue());
        assertNull(arrayList.add("1").getReturnValue());

        // should be two elements
        assertFalse(arrayList.isEmpty());
        assertEquals(arrayList.size(), 2);

        // two can be retrieved
        assertEquals(arrayList.get(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(arrayList.get(0).getReturnValue(), "0");
        assertEquals(arrayList.get(1).getReturnValue(), "1");
        assertEquals(arrayList.get(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);

        // two can be removed
        assertEquals(arrayList.remove(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(arrayList.remove(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(arrayList.remove(0).getReturnValue(), "0");
        assertEquals(arrayList.remove(0).getReturnValue(), "1");
        assertEquals(arrayList.remove(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // should be empty now
        assertTrue(arrayList.isEmpty());
        assertEquals(arrayList.size(), 0);

        // prepare for adding with index tests
        assertNull(arrayList.add("0").getReturnValue());

        // add three via index
        assertEquals(arrayList.add(0, null).getError(), ErrorMessage.INVALID_ARGUMENT);
        assertEquals(arrayList.add(-1, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(arrayList.add(66, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertNull(arrayList.add(0, "1").getReturnValue());
        assertNull(arrayList.add(0, "2").getReturnValue());
        assertNull(arrayList.add(2, "3").getReturnValue());
        assertEquals(arrayList.add(4, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);

        // should be 4 elements
        assertFalse(arrayList.isEmpty());
        assertEquals(arrayList.size(), 4);

        // 4 can be retrieved
        assertEquals(arrayList.get(0).getReturnValue(), "2");
        assertEquals(arrayList.get(1).getReturnValue(), "1");
        assertEquals(arrayList.get(2).getReturnValue(), "3");
        assertEquals(arrayList.get(3).getReturnValue(), "0");

        // 4 can be removed
        assertEquals(arrayList.remove(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(arrayList.remove(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(arrayList.remove(3).getReturnValue(), "0");
        assertEquals(arrayList.remove(2).getReturnValue(), "3");
        assertEquals(arrayList.remove(1).getReturnValue(), "1");
        assertEquals(arrayList.remove(0).getReturnValue(), "2");
        assertEquals(arrayList.remove(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // should be empty now
        assertTrue(arrayList.isEmpty());
        assertEquals(arrayList.size(), 0);
    }
}
