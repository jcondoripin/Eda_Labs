public class Node<T> {
    private T data;
    private Node<T> nextNode;
    public Node(T data, Node<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }
    public Node(T data) {
        this.data = data;
        this.nextNode = null;
    }
    public T getData() {
        return this.data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public boolean hasNext() {
        if(this.nextNode != null)
            return true;
        return false;
    }
    public Node<T> getNext() {
        return this.nextNode;
    }
    public void setNext(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
 }
 