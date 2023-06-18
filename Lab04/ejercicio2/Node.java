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

    public E getData() {
        return this.data;
    }

    public Node<E> getPreviuosNode() {
        return this.previousNode;
    }

    public void setPreviousNode(Node<E> previous) {
        this.previousNode = previous;
    }

    public Node<E> getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node<E> next) {
        this.nextNode = next;
    }

}
