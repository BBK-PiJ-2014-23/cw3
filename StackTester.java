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

        // top on empty structure
        assertEquals(stack.top().getError(), ErrorMessage.EMPTY_STRUCTURE);

        // pop on empty structure
        assertEquals(stack.pop().getError(), ErrorMessage.EMPTY_STRUCTURE);

        // push 1 and top
        stack.push("0");
        assertEquals(stack.top().getReturnValue(), "0");

        // should be one element
        assertFalse(stack.isEmpty());
        assertEquals(stack.size(), 1);

        // push another element
        stack.push("1");
        assertEquals(stack.top().getReturnValue(), "1");

        // should be two elements now
        assertFalse(stack.isEmpty());
        assertEquals(stack.size(), 2);

        // removing one
        assertEquals(stack.pop().getReturnValue(), "1");

        // should be one element now
        assertFalse(stack.isEmpty());
        assertEquals(stack.size(), 1);
        assertEquals(stack.top().getReturnValue(), "0");

        // pop another element
        assertEquals(stack.pop().getReturnValue(), "0");

        //stack is empty now
        assertTrue(stack.isEmpty());
        assertEquals(stack.size(), 0);
        assertEquals(stack.pop().getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals(stack.top().getError(), ErrorMessage.EMPTY_STRUCTURE);
    }
}
