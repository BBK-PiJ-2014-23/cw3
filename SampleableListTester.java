import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class SampleableListTester.
 *
 * @author  Stefan E. Mayer
 * @version 1.1
 */
public class SampleableListTester {
    @Test
    public void test() {
        SampleableList sampleableList = new SampleableListImpl();

        // size empty
        assertTrue(sampleableList.isEmpty());
        assertEquals(sampleableList.size(), 0);

        // get on empty structure
        assertEquals(sampleableList.get(-1).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(sampleableList.get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(sampleableList.get(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // remove on empty structure
        assertEquals(sampleableList.get(-1).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(sampleableList.get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(sampleableList.get(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // add 2 via plain add
        assertEquals(sampleableList.add(null).getError(), ErrorMessage.INVALID_ARGUMENT);
        assertNull(sampleableList.add("0").getReturnValue());
        assertNull(sampleableList.add("1").getReturnValue());

        // should be two elements
        assertFalse(sampleableList.isEmpty());
        assertEquals(sampleableList.size(), 2);

        // two can be retrieved
        assertEquals(sampleableList.get(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(sampleableList.get(0).getReturnValue(), "0");
        assertEquals(sampleableList.get(1).getReturnValue(), "1");
        assertEquals(sampleableList.get(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);

        // two can be removed
        assertEquals(sampleableList.remove(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(sampleableList.remove(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(sampleableList.remove(0).getReturnValue(), "0");
        assertEquals(sampleableList.remove(0).getReturnValue(), "1");
        assertEquals(sampleableList.remove(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // should be empty now
        assertTrue(sampleableList.isEmpty());
        assertEquals(sampleableList.size(), 0);

        // prepare for adding with index tests
        assertNull(sampleableList.add("0").getReturnValue());

        // add three via index
        assertEquals(sampleableList.add(0, null).getError(), ErrorMessage.INVALID_ARGUMENT);
        assertEquals(sampleableList.add(-1, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(sampleableList.add(66, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertNull(sampleableList.add(0, "1").getReturnValue());
        assertNull(sampleableList.add(0, "2").getReturnValue());
        assertNull(sampleableList.add(2, "3").getReturnValue());
        assertEquals(sampleableList.add(4, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);

        // should be 4 elements
        assertFalse(sampleableList.isEmpty());
        assertEquals(sampleableList.size(), 4);

        // 4 can be retrieved
        assertEquals(sampleableList.get(0).getReturnValue(), "2");
        assertEquals(sampleableList.get(1).getReturnValue(), "1");
        assertEquals(sampleableList.get(2).getReturnValue(), "3");
        assertEquals(sampleableList.get(3).getReturnValue(), "0");

        // 4 can be remove
        assertEquals(sampleableList.remove(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(sampleableList.remove(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(sampleableList.remove(3).getReturnValue(), "0");
        assertEquals(sampleableList.remove(2).getReturnValue(), "3");
        assertEquals(sampleableList.remove(1).getReturnValue(), "1");
        assertEquals(sampleableList.remove(0).getReturnValue(), "2");
        assertEquals(sampleableList.remove(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // should be empty now
        assertTrue(sampleableList.isEmpty());
        assertEquals(sampleableList.size(), 0);
    }
}