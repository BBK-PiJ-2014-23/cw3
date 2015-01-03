import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class ImprovedStackTester.
 *
 * @author  Stefan E. Mayer
 * @version 1.1
 */
public class ImprovedStackTester {
    @Test
    public void test() {
        List list = new ArrayList();
        Stack improvedStack = new ImprovedStackImpl(list);
        // 
        // size empty
        assertTrue(improvedStack.isEmpty());
        assertEquals(improvedStack.size(), 0);

        //         // top on empty structure
        //         assertEquals(improvedStack.top().getError(), ErrorMessage.EMPTY_STRUCTURE);
        // 
        //         // pop on empty structure
        //         assertEquals(improvedStack.pop().getError(), ErrorMessage.EMPTY_STRUCTURE);
        // 
        //         // push 1 and top
        //         improvedStack.push("0");
        //         assertEquals(improvedStack.top().getReturnValue(), "0");
        // 
        //         // should be one element
        //         assertFalse(improvedStack.isEmpty());
        //         assertEquals(improvedStack.size(), 1);
        // 
        //         // push another element
        //         improvedStack.push("1");
        //         assertEquals(improvedStack.top().getReturnValue(), "1");
        // 
        //         // should be two elements now
        //         assertFalse(improvedStack.isEmpty());
        //         assertEquals(improvedStack.size(), 2);
        // 
        //         // removing one
        //         assertEquals(improvedStack.pop().getReturnValue(), "1");
        // 
        //         // should be one element now
        //         assertFalse(improvedStack.isEmpty());
        //         assertEquals(improvedStack.size(), 1);
        //         assertEquals(improvedStack.top().getReturnValue(), "0");
        // 
        //         // pop another element
        //         assertEquals(improvedStack.pop().getReturnValue(), "0");
        // 
        //         //improvedStack is empty now
        //         assertTrue(improvedStack.isEmpty());
        //         assertEquals(improvedStack.size(), 0);
        //         assertEquals(improvedStack.pop().getError(), ErrorMessage.EMPTY_STRUCTURE);
        //         assertEquals(improvedStack.top().getError(), ErrorMessage.EMPTY_STRUCTURE);
    }
}
