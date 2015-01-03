/**
 * An implementation of a stack with additional methods. 
 * 
 * Classes implementing this interface must use a {@see List} as the
 * underlying data structure to store the elements on the stack. 
 * 
 * Not all operations on a stack will always be successful. For
 * example, a programmer may try to pop an element from an empty
 * stack. Since we hace not covered exceptions yet, we need another
 * mechanism to report errors. In order to do that, methods of this
 * list will return a {@see ReturnObject} that will contain either an
 * object or an error value of the right kind (as defined in {@see
 * ErrorMessage}).
 * 
 * @author Stefan E. Mayer
 */
public class ImprovedStackImpl implements ImprovedStack {
    private Stack internalStack;
    
    public ImprovedStackImpl(List list) {
        internalStack = new StackImpl(list);
    }
    
    /**
     * Returns true if the stack is empty, false otherwise. 
     * 
     * @return true if the stack is empty, false otherwise. 
     */
    @Override
    public boolean isEmpty() {
        return internalStack.isEmpty();
    }

    /**
     * Returns the number of items currently in the stack.
     * 
     * @return the number of items currently in the stack
     */
    @Override
    public int size() {
        return internalStack.size();
    } 

    /**
     * Adds an element at the top of the stack. 
     * 
     * @param item the new item to be added
     */
    @Override
    public void push(Object item) {
        internalStack.push(item);
    }

    /**
     * Returns the element at the top of the stack. The stack is
     * left unchanged.
     * 
     * @return If stack is not empty, the item on the top is returned. If the
     *         stack is empty, an appropriate error.
     */
    @Override
    public ReturnObject top() {
        return internalStack.top();
    }

    /**
     * Returns the element at the top of the stack. The element is
     * removed frmo the stack.
     * 
     * @return If stack is not empty, the item on the top is returned. If the
     *         stack is empty, an appropriate error.
     */
    @Override
    public ReturnObject pop() {
        return internalStack.pop();
    }

    /**
     * Returns a copy of this stack with the items reversed, the top
     * elements on the original stack is at the bottom of the new
     * stack and viceversa.
     * 
     * @return a copy of this stack with the items reversed. 
     */
    @Override
    public ImprovedStack reverse() {
        return new ImprovedStackImpl(null);
    }

    /**
     * Removes the given object from the stack if it is
     * there. Multiple instances of the object are all removed.
     *
     * Classes implementing this method must use method .equals() to
     * check whether the item is in the stack or not.
     * 
     * @param object the object to remove
     */
    @Override
    public void remove(Object object) {

    }
}