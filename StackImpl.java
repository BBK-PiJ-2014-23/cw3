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
    /**
     * Constructor that calls the constructor of super class AbstractStack.
     * 
     * @param list the list that this stack uses as an internal data structure
     */
    public StackImpl(List list) {
        super(list);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return internalList.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return internalList.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void push(Object item) {
        internalList.add(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReturnObject top() {
        if (isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else {
            return internalList.get(internalList.size() - 1);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReturnObject pop() {
        // Error handling is included in method top().
        ReturnObject pop = top();
        if (!pop.hasError()) {
            internalList.remove(internalList.size() - 1);
        }
        return pop;
    }
}