/**
 * This node is a container that stores an object of any kind and points to another node.
 * It can be used in Linked Lists.
 * 
 * @author Stefan E. Mayer
 */
public interface NodeInterface {
    /**
     * Getter for the object included in the node.
     * 
     * @return the object within the node
     */
    public Object getObject();

    /**
     * Setter for the next node in a list.
     * 
     * @param next the next node in a list
     */
    public void setNext(Node next);

    /**
     * Getter for the next node in in a list.
     * 
     * @return the next node in a list
     */
    public Node getNext();
}