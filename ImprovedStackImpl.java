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
    private List internalList;

    public ImprovedStackImpl(List list) {
        internalList = list;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public ImprovedStack reverse() {
        ImprovedStack reverse = new ImprovedStackImpl(new ArrayList());
        for (int i = size() - 1; i >= 0; i--) {
            reverse.push(internalList.get(i).getReturnValue());
        }
        return reverse;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(Object object) {
        for (int i = 0; i < size(); i++) {
            if (internalList.get(i).getReturnValue().equals(object)) {
                internalList.remove(i);
            }
        }
    }
}