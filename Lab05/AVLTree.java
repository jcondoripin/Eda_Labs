package Lab05;

import org.w3c.dom.Node;

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
     // Insertaremos de manera recursiva
    public void insert(E x) throws ItemDuplicated {
		this.height = false;
		this.root = insertRecursive(x, this.root);
	}

	private Node insertRecursive(E x, Node current) throws ExceptionNoFound {
		Node res = current;
		if (current == null) {
			res = new Node(x);	
			this.height = true;
		}
		else {
			int resC = current.data.compareTo(x);
			if (resC == 0) throw new ExceptionNoFound("El dato ya fue insertado antes");
			if (resC < 0) {
				res.right = insertRecursive(x, current.right);
				if (this.height) {
					switch (res.fb) {
						case -1: res.fb = 0; this.height = false; break;
						case 0: res.fb = 1; this.height = true; break;
						case 1:
							res = balanceToLeft(res);
							this.height = false;
							break;
					}
				}	
			}
			else {
				res.left = insertRecursive(x, current.left);
				if (this.height) {
					switch (res.fb) {
						case 1: res.fb = 0; this.height = false; break;
						case 0: res.fb = -1; this.height = true; break;
						case -1:
							res = balanceToRight(res);
							this.height = false;
							break;
					}
				}	
			}
		}
		return res;
	}

}