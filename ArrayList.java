/**
 * A list is a collection of objects that are sorted and can be
 * accessed by index. The first element in the list is at index 0.
 *
 * A list can store objects of any kind, and they can be of different
 * types: Integers, Doubles, String, or even other lists. However,
 * this list cannot store null objects.
 * 
 * There is no limit to the number of elements in the list (provided
 * that there is free memory in the Java Virtual Machine).
 * 
 * Not all operations on a list will always be successful. For
 * example, a programmer may try to remove an element from an empty
 * list, or from a position where there is nothing. Since we hace not
 * covered exceptions yet, we need another mechanism to report
 * errors. In order to do that, methods of this list will return a
 * {@see ReturnObject} that will contain either an object or an error
 * value of the right kind (as defined in {@see ErrorMessage}). 
 * 
 * @author Stefan E. Mayer
 */
public class ArrayList implements List {
    protected Object[] array;
    protected int size;

    /**
     * Constructor that creates an empy internal array.
     */
    public ArrayList() {
        array = new Object[20];
        size = 0;
    }

    /**
     * {@inheritDoc}
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
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReturnObject get(int index) {
        if (isEmpty()) {
            return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
        } else if (index < 0 || index >= size()) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            return new ReturnObjectImpl(array[index]);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReturnObject remove(int index) {
        // Error handling is included in method get().
        ReturnObject toDelete = get(index);
        if (!toDelete.hasError()) {
            for (int i = index; i < size() - 1; i++) {
                array[i] = array[i + 1];
            }
            // Last value has moved down by one so setting the old last to null.
            array[size() - 1] = null;
            size--;
        }
        return toDelete;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReturnObject add(int index, Object item) {
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else if (index < 0 || index >= size()) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            if (size() == array.length) {
                makeBiggerArray();
            }

            for (int i = size() - 1; i >= index; i--) {
                array[i + 1] = array[i];
            }

            array[index] = item;
            size++;
            return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReturnObject add(Object item) {
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else {
            if (size() == array.length) {
                makeBiggerArray();
            }
            array[size] = item;
            size++;
            return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
        }
    }

    /**
     * Helper method that creates an array twice the size of the internal array,
     * copies in the values of the internal array and replaces the internal
     * array with the newer larger array.
     */
    private void makeBiggerArray() {
        Object[] newArray = new Object[size() * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
