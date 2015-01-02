import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class StackTester.
 *
 * @author  Stefan E. Mayer
 * @version 1.1
 */
public class StackTester {
    @Test
    public void test() {
        List list = new ArrayList();
        Stack stack = new StackImpl(list);

        // size empty
        assertTrue(stack.isEmpty());
        assertEquals(stack.size(), 0);

        //         // get on empty structure
        //         assertEquals(stack.top().getError(), ErrorMessage.EMPTY_STRUCTURE);
        //         assertEquals(stack.top().getError(), ErrorMessage.EMPTY_STRUCTURE);
        //         assertEquals(stack.top().getError(), ErrorMessage.EMPTY_STRUCTURE);
        // 
        //         // remove on empty structure
        //         assertEquals(stack.top().getError(), ErrorMessage.EMPTY_STRUCTURE);
        //         assertEquals(stack.top().getError(), ErrorMessage.EMPTY_STRUCTURE);
        //         assertEquals(stack.top().getError(), ErrorMessage.EMPTY_STRUCTURE);
        // 
        //         // add 2 via plain add
        //         //assertEquals(stack.push(null).getError(), ErrorMessage.INVALID_ARGUMENT);
        //         //assertNull(stack.push("0").getReturnValue());
        //         //assertNull(stack.push("1").getReturnValue());
        // 
        //         // should be two elements
        //         assertFalse(stack.isEmpty());
        //         assertEquals(stack.size(), 2);
        // 
        //         // two can be retrieved
        //         assertEquals(stack.top().getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         assertEquals(stack.top().getReturnValue(), "0");
        //         assertEquals(stack.top().getReturnValue(), "1");
        //         assertEquals(stack.top().getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        // 
        //         // two can be removed
        //         assertEquals(stack.pop().getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         assertEquals(stack.pop().getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         assertEquals(stack.pop().getReturnValue(), "0");
        //         assertEquals(stack.pop().getReturnValue(), "1");
        //         assertEquals(stack.pop().getError(), ErrorMessage.EMPTY_STRUCTURE);
        // 
        //         // should be empty now
        //         assertTrue(stack.isEmpty());
        //         assertEquals(stack.size(), 0);
        // 
        //         // prepare for adding with index tests
        //         //assertNull(stack.push("0").getReturnValue());
        // 
        //         // add three via index
        //         //assertEquals(stack.push(0, null).getError(), ErrorMessage.INVALID_ARGUMENT);
        //         //assertEquals(stack.push(-1, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         //assertEquals(stack.push(66, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         //assertNull(stack.push(0, "1").getReturnValue());
        //         //assertNull(stack.push(0, "2").getReturnValue());
        //         //assertNull(stack.push(2, "3").getReturnValue());
        //         //assertEquals(stack.push(4, "test").getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        // 
        //         // should be 4 elements
        //         assertFalse(stack.isEmpty());
        //         assertEquals(stack.size(), 4);
        // 
        //         // 4 can be retrieved
        //         assertEquals(stack.top().getReturnValue(), "2");
        //         assertEquals(stack.top().getReturnValue(), "1");
        //         assertEquals(stack.top().getReturnValue(), "3");
        //         assertEquals(stack.top().getReturnValue(), "0");
        // 
        //         // 4 can be removed
        //         assertEquals(stack.pop().getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         assertEquals(stack.pop().getError(), ErrorMessage.INDEX_OUT_OF_BOUNDS);
        //         assertEquals(stack.pop().getReturnValue(), "0");
        //         assertEquals(stack.pop().getReturnValue(), "3");
        //         assertEquals(stack.pop().getReturnValue(), "1");
        //         assertEquals(stack.pop().getReturnValue(), "2");
        //         assertEquals(stack.pop().getError(), ErrorMessage.EMPTY_STRUCTURE);
        // 
        //         // should be empty now
        //         assertTrue(stack.isEmpty());
        //         assertEquals(stack.size(), 0);
    }
}
