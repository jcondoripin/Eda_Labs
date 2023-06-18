package Lab04.ejercicio1;

public class NodeList<T> {
    private Node<T> raiz;
    private int size = 0;
    
    public Node<T> getRaiz() {
        return raiz;
    }
    public void setRaiz(Node<T> raiz) {
        this.raiz = raiz;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
