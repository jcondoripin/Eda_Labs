package ejercicio2;

public class Node<T> {
    private T data;
    private Node<T> next;

    // Constructor
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    // Obtener atributo data
    public T getData() {
        return data;
    }

    // Establecer atributo data
    public void setData(T data) {
        this.data = data;
    }

    // Obtener nodo siguiente
    public Node<T> getNext() {
        return next;
    }

    // Establecer nodo siguiente
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
