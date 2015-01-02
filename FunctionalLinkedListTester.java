import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class FunctionalLinkedListTester.
 *
 * @author  Stefan E. Mayer
 * @version 1.1
 */
public class FunctionalLinkedListTester {
    @Test
    public void test() {
        FunctionalList functionalLinkedList = new FunctionalLinkedList();

        // size empty
        assertTrue(functionalLinkedList.isEmpty());
        assertEquals(functionalLinkedList.size(), 0);

        //         // empty rest list
        //         assertTrue(functionalLinkedList.rest().isEmpty());

        // get on empty structure
        assertEquals(functionalLinkedList.get(-1).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(functionalLinkedList.get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(functionalLinkedList.get(66).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(functionalLinkedList.head().getError(), ErrorMessage.EMPTY_STRUCTURE);

        //         // get on empty rest list.
        //         assertEquals(functionalLinkedList.rest().get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // remove on empty structure
        assertEquals(functionalLinkedList.get(-1).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(functionalLinkedList.get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(functionalLinkedList.get(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // add 2 via plain add
        assertEquals(functionalLinkedList.add(null).getError(), ErrorMessage.INVALID_ARGUMENT);
        assertNull(functionalLinkedList.add("0").getReturnValue());
        //         assertTrue(functionalLinkedList.rest().isEmpty()); // rest list should still be empty
        assertNull(functionalLinkedList.add("1").getReturnValue());

        // should be two elements
        assertFalse(functionalLinkedList.isEmpty());
        assertEquals(functionalLinkedList.size(), 2);

        //         // should be one element in the rest list
        //         assertEquals(functionalLinkedList.rest().size(), 1);

        // two can be retrieved
        assertEquals(functionalLinkedList.get(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(functionalLinkedList.get(0).getReturnValue(), "0");
        assertEquals(functionalLinkedList.get(1).getReturnValue(), "1");
        assertEquals(functionalLinkedList.get(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(functionalLinkedList.head().getReturnValue(), "0");

        //         // one element in the rest list can be retrieved
        //         assertEquals(functionalLinkedList.rest().get(0).getReturnValue(), "1");
        //         assertEquals(functionalLinkedList.rest().get(1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);

        // two can be removed
        assertEquals(functionalLinkedList.remove(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(functionalLinkedList.remove(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(functionalLinkedList.remove(0).getReturnValue(), "0");
        assertEquals(functionalLinkedList.head().getReturnValue(), "1");
        assertEquals(functionalLinkedList.remove(0).getReturnValue(), "1");
        assertEquals(functionalLinkedList.remove(66).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(functionalLinkedList.head().getError(), ErrorMessage.EMPTY_STRUCTURE);

        // should be empty now
        assertTrue(functionalLinkedList.isEmpty());
        assertEquals(functionalLinkedList.size(), 0);

        // prepare for adding with index tests
        assertNull(functionalLinkedList.add("0").getReturnValue());

        // add three via index
        assertEquals(functionalLinkedList.add(0, null).getError(), ErrorMessage.INVALID_ARGUMENT);
        assertEquals(functionalLinkedList.add(-1, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(functionalLinkedList.add(66, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertNull(functionalLinkedList.add(0, "1").getReturnValue());
        assertNull(functionalLinkedList.add(0, "2").getReturnValue());
        assertNull(functionalLinkedList.add(2, "3").getReturnValue());
        assertEquals(functionalLinkedList.add(4, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);

        // should be 4 elements
        assertFalse(functionalLinkedList.isEmpty());
        assertEquals(functionalLinkedList.size(), 4);

        // 4 can be retrieved
        assertEquals(functionalLinkedList.get(0).getReturnValue(), "2");
        assertEquals(functionalLinkedList.get(1).getReturnValue(), "1");
        assertEquals(functionalLinkedList.get(2).getReturnValue(), "3");
        assertEquals(functionalLinkedList.get(3).getReturnValue(), "0");
        assertEquals(functionalLinkedList.head().getReturnValue(), "2");

        //         // three elements in the rest list can be retrieved
        //         assertEquals(functionalLinkedList.rest().get(0).getReturnValue(), "1");
        //         assertEquals(functionalLinkedList.rest().get(1).getReturnValue(), "3");
        //         assertEquals(functionalLinkedList.rest().get(2).getReturnValue(), "0");
        //         assertEquals(functionalLinkedList.rest().get(3).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);

        // 4 can be removed
        assertEquals(functionalLinkedList.remove(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(functionalLinkedList.remove(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(functionalLinkedList.remove(3).getReturnValue(), "0");
        assertEquals(functionalLinkedList.remove(2).getReturnValue(), "3");
        assertEquals(functionalLinkedList.remove(1).getReturnValue(), "1");
        assertEquals(functionalLinkedList.remove(0).getReturnValue(), "2");
        assertEquals(functionalLinkedList.remove(66).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(functionalLinkedList.head().getError(), ErrorMessage.EMPTY_STRUCTURE);

        // should be empty now
        assertTrue(functionalLinkedList.isEmpty());
        assertEquals(functionalLinkedList.size(), 0);
    }
}