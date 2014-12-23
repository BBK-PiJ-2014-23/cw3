import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class ReturnObjectImplTester.
 *
 * @author  Stefan Mayer
 * @version 1.0
 */
public class ReturnObjectImplTester {
    @Test
    public void test() {
        ReturnObject test1 = new ReturnObjectImpl("text");
        ReturnObject test2 = new ReturnObjectImpl(3);
        ReturnObject test3 = new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        ReturnObject test4 = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        ReturnObject test5 = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        assertFalse(test1.hasError());
        assertFalse(test2.hasError());
        assertTrue(test3.hasError());
        assertTrue(test4.hasError());
        assertTrue(test5.hasError());
        assertEquals(test1.getError(), ErrorMessage.NO_ERROR);
        assertEquals(test2.getError(), ErrorMessage.NO_ERROR);
        assertEquals(test3.getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(test4.getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        assertEquals(test5.getError(), ErrorMessage.INVALID_ARGUMENT);
        assertEquals(test1.getReturnValue(), "text");
        assertEquals(test2.getReturnValue(), 3);
        assertNull(test3.getReturnValue());
        assertNull(test4.getReturnValue());
        assertNull(test5.getReturnValue());
    }
}

