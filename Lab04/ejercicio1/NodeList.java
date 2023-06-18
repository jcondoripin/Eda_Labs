package Lab04.ejercicio1;

public class NodeList<T> {
    private Node<T> root;
    private int size = 0;
    
    public Node<T> getRoot() {
        return root;
    }

    public void setRaiz(Node<T> raiz) {
        this.root = raiz;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node<T> get(int indice) {
    Node<T> aux=root;
    for(int i=0;i<indice;i++)
        aux=aux.getNext();
    return aux;
} 

}
