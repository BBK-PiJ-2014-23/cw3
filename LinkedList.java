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
public class LinkedList implements List{
    protected Node first;
    protected int size;
    
    /**
     * Constructor that creates a linked list containing an empty node.
     */
    public LinkedList() {
        first = null;
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
            Node iterator = first;
            while (iterator.getIndex() < index) {
                iterator = iterator.getNext();
            }
            return new ReturnObjectImpl(iterator.getObject());
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
        // Error handling is included in method get().
        ReturnObject toDelete = get(index);
        if (!toDelete.hasError()) {
            if (index == 0) {
                first = first.getNext();
            } else {
                Node iterator = first;
                while (iterator.getNext().getIndex() < index) {
                    iterator = iterator.getNext();
                }
                // The next node is the one to remove.
                iterator.setNext(iterator.getNext().getNext());
            }
            fixIndices();
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
        } else if (index < 0 || index >= size()) {
            return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
        } else { 
            if (index == 0) {
                Node temp = first;
                first = new Node(item, 0);
                first.setNext(temp);
            } else {
                Node iterator = first;
                while (iterator.getNext().getIndex() < index) {
                    iterator = iterator.getNext();
                }
                Node temp = iterator.getNext();
                iterator.setNext(new Node(item, index));
                // Linking back the remainder of the list to the new node.
                iterator.getNext().setNext(temp);
            }
            fixIndices();
            size++;
            return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
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
            if (isEmpty()) {
                first = new Node(item, 0);
            } else {
                Node iterator = first;
                while (iterator.getNext() != null) {
                    iterator = iterator.getNext();
                }
                // Adding new node as the next node of the last node.
                iterator.setNext(new Node(item, size()));
            }
            size++;
            return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
        }
    }
    
    /**
     * Helper method that reassigns index numbers to all nodes in the list.
     */
    private void fixIndices() {
        Node iterator = first;
        int index = 0;
        while (iterator != null) {
            iterator.setIndex(index);
            index++;
            iterator = iterator.getNext();
        }
    }
}
