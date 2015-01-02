/**
 * An implementation of a stack that uses a {@List} as the underlying
 * data structure.
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
public class StackImpl extends AbstractStack {
    public StackImpl(List list) {
        super(list);
    }

    /**
     * Returns true if the stack is empty, false otherwise. 
     * 
     * @return true if the stack is empty, false otherwise. 
     */
    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of items currently in the stack.
     * 
     * @return the number of items currently in the stack
     */
    @Override
    public int size() {
        return internalList.size();
    }

    /**
     * Adds an element at the top of the stack. 
     * 
     * @param item the new item to be added
     */
    @Override
    public void push(Object item) {
        
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
        if (isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            return new ReturnObjectImpl(internalList.get(internalList.size() - 1));
        }
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
        ReturnObject pop = top();
        if (!pop.hasError()) {
            internalList.remove(internalList.size() - 1);
        }
        return pop;
    }
}

