public class ListNode<T>{
    private Node<T> root;
    public ListNode(Node<T> root) {
        this.root = root;
    }
    public ListNode() {
        this.root = null;
    }
    public Node<T> getRoot() {
        return this.root;
    }
    @Override
    public String toString() {
        Node<T> aux = this.root;
        String string = "";
        while(aux != null) {

            string = string + "[" + aux.getData() + "] => ";

            aux = aux.getNext();
        }
        string = string + "NULL";
        return string;
    }
    // Métodos de lista
    public void add(T elem) { // Añade al final
        Node<T> e = new Node<T>(elem);
        if(root == null) {
            this.root = e;
        }else {
            Node<T> aux = root;
            while(aux.hasNext()) {
                aux = aux.getNext();
            }
            aux.setNext(e);
        }
    } 
    public void add(int index, T elem) { // Añade en una posición
        Node<T> e = new Node<T>(elem);
        if( index == 0 ) { // Inserción al inicio
            e.setNext(this.root);
            this.root = e;
        }else { // Interno de la lista
            Node<T> aux = this.root;
            int pos = 1;
            while(aux.hasNext() && pos < index) {
                aux = aux.getNext();
                pos++;
            }
            if(pos != index) {
                System.out.println("Index not found");
            } else {
                e.setNext(aux.getNext());
                aux.setNext(e);
            }
        }
    }
    public void clear() {
        this.root = null;
    }
    public boolean contains(Object o) {
        Node<T> aux = this.root;
        while(aux.hasNext()) {
            aux = aux.getNext();
            if(o.equals(aux.getData())) {
                return true;
            }
        }
        return false;
    }
    public T get(int index) {
        Node<T> aux = this.root;
        int pos = 0;
        while(aux.hasNext() && pos < index) {
            aux = aux.getNext();
            pos++;
        }
        if(pos == index) {
            return aux.getData();
        }else {
            System.out.println("Index not found");
            return null;
        }
    }
    public int size() {
        Node<T> aux = root;
        int siz = 0;
        while(aux.hasNext()) {
            aux = aux.getNext();
            siz++;
        }
        return siz;
    }
    public boolean isEmpty() {
        return this.root == null;
    }
    public T remove(int index) {
        if(this.isEmpty()) {
            return null; 
            // Arrojar excepcion
        }else {
            Node<T> aux = this.root;
            if(index == 0) {
                this.root = aux.getNext();
                return aux.getData();
            }else {
                int pos = 1;
                while(aux.hasNext() && pos < index) {
                    aux = aux.getNext();
                    pos++;
                }
                Node<T> aux1 = aux.getNext();
                aux.setNext(aux1.getNext());
                return aux1.getData();
            }
        }
    }

    public boolean remove(Object o) {
        if(this.isEmpty()) {
            // Underflow error
            return false;
        }else {
            Node<T> aux = this.root;
            if(aux.equals(o)) {
                this.root = aux.getNext();
                return true;
            }else {
                while(aux.hasNext()) {
                    if(aux.getNext().equals(o)) {
                        aux.setNext(aux.getNext().getNext());
                        return true;
                    }
                    aux = aux.getNext();
                }
                return false;
            }
        }
    }
    public static void main(String[] args) {
        ListNode<Integer> a = new ListNode<>();
        a.add(1);
        a.add(2);
        a.add(3);

        // [1] => [2] => [3] => NULL
        System.out.println(a);
    }
 }
 