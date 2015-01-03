public class Node {
    private Object object;
    private int index;
    private Node next;
    
    /**
     * Constructor creating a new node object.
     * 
     * @param object the object to be included in the node
     * @param index the postition of the node within a list
     */
    public Node(Object object, int index) {
        this.object = object;
        this.index = index;
        this.next = null;
    }
    
    /**
     * Getter for the object included in the node.
     * 
     * @return the object within the node
     */
    public Object getObject() {
        return object;
    }
    
    /**
     * Setter for the position of the node within a list.
     * 
     * @param index the position of the node within a list
     */
    public void setIndex(int index) {
        this.index = index;
    }
    
    /**
     * Getter for the position of the node within a list.
     * 
     * @return the position of the node within a list
     */
    public int getIndex() {
        return index;
    }
    
    /**
     * Setter for the next node in a list.
     * 
     * @param next the next node in a list
     */
    public void setNext(Node next) {
        this.next = next;
    }
    
    /**
     * Getter for the next node in in a list.
     * 
     * @return the next node in a list
     */
    public Node getNext() {
        return next;
    }
}