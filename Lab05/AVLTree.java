package Lab05;

public class AVLTree<T extends Comparable<T>> {
    private NodoAVL<T> root;

    public AVLTree(NodoAVL<T> root) {
        this.root = root;
    }

    public AVLTree() {
        this(null);
    }

    public boolean isEmpty() {
        return this.root == null;
    }
    
    //El metodo son() se dividira en dos, debido a que hay dos posibles hijos

    //Uno izquierdo y uno derecho
    public NodoAVL<T> leftSon(NodoAVL<T> nodo){
        return nodo.getLeft();
    }

    public NodoAVL<T> rightSon(NodoAVL<T> nodo){
        return nodo.getRight();
    }

    

}