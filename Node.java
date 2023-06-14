package question1;

public class Node <T>{
    private T data;
    private Node next;

    public T getValor() {
        return data;
    }

    public void setValor(T valor) {
        this.data = valor;
    }

    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }

    public Node(T valor) {
        this.data = valor;
    }

    public Node(T valor, Node next) {
        this.data = valor;
        this.next = next;
    }
}
