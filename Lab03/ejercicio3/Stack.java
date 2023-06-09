package ejercicio3;
public class Stack<T>{
    private Node<T> top;
    private int length;
    public Stack() {
        this.top = null;
    }
    public boolean empty() {
        return this.length == 0;
    }
    public T peek() {
        return this.top.getData();
    }
    public T pop() {
        T data = this.top.getData();
        this.top = this.top.getNext();
        return data;
    }
    public T push(T item) {
        Node<T> newNode = new Node<T>(item, top);
        this.top = newNode;
        return item;
    }
    public int search(Object o) {
        Node<T> aux = this.top;
        int pos = 0;
        while(aux != null && !aux.getData().equals(o)) {
            aux = aux.getNext();
            pos++;
        }
        if(aux != null) {
            return pos;
        }else {
            return -1;
        }
    }
}