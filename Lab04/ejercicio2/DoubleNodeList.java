import java.util.NoSuchElementException;

public class DoubleNodeList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoubleNodeList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void remove(E data) {
        Node<E> puntero = head;
        while (puntero != null) {
            if (puntero.getData().equals(data)) {
                if (puntero == head) {
                    head = puntero.getNextNode();
                    if (head != null) {
                        head.setPreviousNode(null);
                    } else {
                        tail = null;
                    }
                } else if (puntero == tail) {
                    tail = puntero.getPreviuosNode();
                    tail.setNextNode(null);
                } else {
                    Node<E> previousNode = puntero.getPreviuosNode();
                    Node<E> nextNode = puntero.getNextNode();
                    previousNode.setNextNode(nextNode);
                    nextNode.setPreviousNode(previousNode);
                }
                break;
            }
            puntero = puntero.getNextNode();
        }
    }

    public boolean contains(E data) {
        Node<E> puntero = head;

        while (puntero != null) {
            if (puntero.getData().equals(data)) {
                return true;
            }
            puntero = puntero.getNextNode();
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void removeFirst() throws Exception {
        if (head == null) {
            throw new Exception("Esta lista está vacía");
        }

        Node<E> removedNode = head;
        head = head.getNextNode();

        if (head != null) {
            head.setPreviousNode(null);
        } else {
            tail = null; // Si la lista quedó vacía
        }

        removedNode.setNextNode(null);

        size--;
    }
}
