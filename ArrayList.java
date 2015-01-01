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
    private Object[] array;
    private int size;

    public ArrayList() {
        array = new Object[100];
        size = 0;
    }

    /**
     * Returns true if the list is empty, false otherwise. 
     * 
     * @return true if the list is empty, false otherwise. 
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
     * Returns the number of items currently in the list.
     * 
     * @return the number of items currently in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the elements at the given position. 
     * 
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     * 
     * @param index the position in the list of the item to be retrieved
     * @return the element or an appropriate error message, 
     *         encapsulated in a ReturnObject
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
     * Returns the elements at the given position and removes it
     * from the list. The indeces of elements after the removed
     * element must be updated accordignly.
     * 
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     * 
     * @param index the position in the list of the item to be retrieved
     * @return the element or an appropriate error message, 
     *         encapsulated in a ReturnObject
     */
    @Override
    public ReturnObject remove(int index) {
        ReturnObject toDelete = get(index);
        if (!toDelete.hasError()) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = null;
            size--;
        }
        return toDelete;
    }

    /**
     * Adds an element to the list, inserting it at the given
     * position. The indeces of elements at and after that position
     * must be updated accordignly.
     * 
     * If the index is negative or greater or equal than the size of
     * the list, then an appropriate error must be returned.
     * 
     * If a null object is provided to insert in the list, the
     * request must be ignored and an appropriate error must be
     * returned.
     * 
     * @param index the position at which the item should be inserted in
     *              the list
     * @param item the value to insert into the list
     * @return an ReturnObject, either empty if the operation is successful and
     *         the item added or containing an appropriate error message
     */
    @Override
    public ReturnObject add(int index, Object item) {
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else if (size == 0 && index == 0) {
            array[0] = item;
            size++;
            return new ReturnObjectImpl(null);
        } else if (index < 0 || index >= size) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else {
            if (size == array.length) {
                makeBiggerArray();
            }

            for (int i = size - 1; i >= index; i--) {
                array[i + 1] = array[i];
            }
            array[index] = item;
            size++;
            return new ReturnObjectImpl(null);
        }
    }

    /**
     * Adds an element at the end of the list.
     * 
     * If a null object is provided to insert in the list, the
     * request must be ignored and an appropriate error must be
     * returned.
     * 
     * @param item the value to insert into the list
     * @return an ReturnObject, empty if the operation is successful
     *         the item added or containing an appropriate error message
     */
    @Override
    public ReturnObject add(Object item) {
        if (item == null) {
            return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
        } else {
            if (size == array.length) {
                makeBiggerArray();
            }
            array[size] = item;
            size++;
            return new ReturnObjectImpl(null);
        }
    }

    private void makeBiggerArray() {
        Object[] newArray = new Object[size * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
