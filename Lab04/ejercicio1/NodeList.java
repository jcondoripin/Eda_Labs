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

    public void remove(int indice) {
        if(indice<size) {
        if(indice==0)
            root=root.getNext();
        else {
            Node<T> anterior=this.get(indice-1);
            anterior.setNext(this.get(indice+1));
        }
        size--;
        }
    }
    
    public void put(T valor) {
        if (size == 0) {
            root = new Node(valor);
            size++;
            return;
        }
        get(size - 1).setNext(new Node(valor));
        size++;
    }
    
    public void replace(int indice, T valor) {
        get(indice).setValor(valor);
    }
}
