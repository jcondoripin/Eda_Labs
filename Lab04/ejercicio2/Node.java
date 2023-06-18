public class Node<E> {

    private E data;
    private Node<E> nextNode;
    private Node<E> previousNode;

    Node() {
        this.data = null;
        this.nextNode = null;
        this.previousNode = null;
    }

    Node(E data) {
        this.data = data;
        this.nextNode = null;
        this.previousNode = null;
    }

    Node(E data, Node<E> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
        this.previousNode = null;
    }

    Node(E data, Node<E> nextNode, Node<E> previousNode) {
        this.data = data;
        this.nextNode = nextNode;
        this.previousNode = previousNode;
    }

    /* Getters y Setter ... */
}
