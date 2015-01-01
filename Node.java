public class Node {
    private Object object;
    private int index;
    private Node next;
    
    public Node(Object object, int index) {
        this.object = object;
        this.index = index;
        this.next = null;
    }
    
    public Object getObject() {
        return object;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public int getIndex() {
        return index;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    
    public Node getNext() {
        return next;
    }
}