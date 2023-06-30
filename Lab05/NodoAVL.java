package Lab05;
class NodoAVL<T extends Comparable<T>> {
    private T valor;
    private NodoAVL<T> left;
    private NodoAVL<T> right;
    private int altura;

    public NodoAVL(T value, NodoAVL<T> left, NodoAVL<T> right) {
        this.left = left;
        this.right = right;
        this.valor = value;
        this.altura = 0;
    }

    public NodoAVL(T value) {
        this(value, null, null);
    }

    public void setRight(NodoAVL<T> right) {
        this.right = right;
    }

    public void setLeft(NodoAVL<T> left) {
        this.left = left;
    }

    public NodoAVL<T> getRight() {
        return this.right;
    }

    public NodoAVL<T> getLeft() {
        return this.left;
    }

    public void setValue(T value) {
        this.valor = value;
    }

    public T getValue() {
        return this.valor;
    }

    public void setAlt(int alt) {
        this.altura = alt;
    }

    public int getAlt() {
        return this.altura;
    }

}
