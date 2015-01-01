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

        // get on empty structure
        assertEquals(arrayList.get(-1).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(arrayList.get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(arrayList.get(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // remove on empty structure
        assertEquals(arrayList.get(-1).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(arrayList.get(0).getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(arrayList.get(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

        // add plain
        assertEquals(arrayList.add(null).getError(), ErrorMessage.INVALID_ARGUMENT);
        assertNull(arrayList.add("1").getReturnValue());

        // tests on structure with one element

        assertFalse(arrayList.isEmpty());
        assertEquals(arrayList.size(), 1);

        assertEquals(arrayList.get(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(arrayList.get(0).getReturnValue(), "1");
        assertEquals(arrayList.get(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);

        assertEquals(arrayList.remove(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(arrayList.remove(66).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(arrayList.remove(0).getReturnValue(), "1");
        assertEquals(arrayList.remove(66).getError(), ErrorMessage.EMPTY_STRUCTURE);

    
        //     // add with index
        //     assertEquals(arrayList.add(0, null).getError(), ErrorMessage.INVALID_ARGUMENT);
        //     assertEquals(arrayList.add(-1, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //     assertEquals(arrayList.add(66, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //     
        //     assertNull(arrayList.add(0, "test1").getReturnValue());
        //     assertNull(arrayList.add(0, "test2").getReturnValue());
        //     assertEquals(arrayList.get(0).getReturnValue(), "test2");
        //     assertEquals(arrayList.get(1).getReturnValue(), "test1");
        //     
        //     // size after
        //     assertFalse(arrayList.isEmpty());
        //     assertEquals(arrayList.size(), 2);
        //     
        //     // remove
        //     assertEquals(arrayList.remove(-1).getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //     assertEquals(arrayList.remove(1).getReturnValue(), "test1");
        //     assertEquals(arrayList.get(0).getReturnValue(), "test2");
        //     assertEquals(arrayList.get(1).getReturnValue(), "test3");
    }
}
