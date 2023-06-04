package ejercicio2;

public class Stack {
    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    // Verificar si la pila esta vacia
    public boolean isEmpty() {
        return size == 0;
    }

    // Tamaño de la pila
    public int size() {
        return size;
    }

    // Insertar un dato en la pila
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    // Imprime el ultimo valor de la pila y lo elimina de la misma
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    // Devuelve el valor superior de la pila (top)
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getData();
    }

    //Metodo para buscar un elemento y devolver su indice empieza en 1 (superior)
    public int search(T element) {
        int index = 1;
        Node<T> auxiliar = top;
        while (auxiliar != null) {
            if (auxiliar.getData().equals(element)) {
                return index;
            }
            auxiliar = auxiliar.getNext();
            index++;
        }
        return -1;
    }
}
