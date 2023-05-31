public class Node<T> {
    private T data;
    private Node<T> next;
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
    public boolean hasNext() {
        return this.next != null;
    }
    public Node<T> getNext() {
        return this.next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public T getData() {
        return this.data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
