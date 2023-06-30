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

}