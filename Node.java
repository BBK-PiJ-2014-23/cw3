/**
 * This node is a container that stores an object of any kind and points to another node.
 * It can be used in Linked Lists.
 * 
 * @author Stefan E. Mayer
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
     * {@inheritDoc}
     */
    @Override
    public Object getObject() {
        return object;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getNext() {
        return next;
    }
}