package Lab04.ejercicio1;

public class Node <T> {
    private T valor;
    private Node<T> next;
    
    public T getValor() {
    return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public Node(T valor) {
        this.valor = valor;
    }
    
    public Node(T valor, Node<T> next) {
        this.valor = valor;
        this.next = next;
    }
}
