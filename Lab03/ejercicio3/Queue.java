package ejercicio3;
public class Queue<T>{
    private Node<T> first;
    private Node<T> last;
    private int length;
    public Queue() {
        this.first = null;
        this.last = null;
    }
    public boolean empty() {
        return this.length == 0;
    }
    public T getFirst() {
        return this.first.getData();
    }
    public T deQueue() {
        T data = this.first.getData();
        this.first = this.first.getNext();
        return data;
    }
    public void enQueue(T item) {
        Node<T> newNode = new Node<T>(item);
        this.last.setNext(newNode);
        this.last = newNode;
    }
    public int search(Object o) {
        Node<T> aux = this.first;
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