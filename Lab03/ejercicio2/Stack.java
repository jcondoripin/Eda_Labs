package ejercicio2;

public class Stack {
    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }
    //Verificar si la pila esta vacia
    public boolean isEmpty() {
        return size == 0;
    }
    //Tamaño de la pila
    public int size() {
        return size;
    }
    //Insertar un dato en la pila
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

}
