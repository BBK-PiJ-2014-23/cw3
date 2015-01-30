/**
 * This node is a container that stores an object of any kind and points to another node.
 * It can be used in Linked Lists.
 */
public class Node implements NodeInterface {
    private Object object;
    private Node next;
    
    /**
     * Constructor creating a new node object.
     * 
     * @param object the object to be included in the node
     */
    public Node(Object object) {
        this.object = object;
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