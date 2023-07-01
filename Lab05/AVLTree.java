package Lab05;

import Lab05.Exceptions.NotFoundException;

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

    public void remove(T x) throws NotFoundException {
        this.root = remove(x, this.root);
    }

    private NodoAVL<T> remove(T x, NodoAVL<T> current) throws NotFoundException {
        if (current == null) {
            throw new NotFoundException("Elemento no se encuentra en el arbol");
        }
        int resC = current.getValue().compareTo(x);
        if (resC < 0) {
            current.setRight(remove(x, current.getRight()));
            current = balanceToRight(current);
        } else if (resC > 0) {
            current.setLeft(remove(x, current.getLeft()));
            current = balanceToLeft(current);
        } else {
            if (current.getLeft() != null && current.getRight() != null) {
                NodoAVL<T> successor = findMin(current.getRight());
                current.setValue(successor.getValue());
                current.setRight(remove(successor.getValue(), current.getRight()));
                current = balanceToRight(current);
            } else if (isLeaf(current)) {
                current = null;
            } else {
                current = current.getLeft() != null ? current.getLeft() : current.getRight();
            }
        }

        return current;
    }

	private NodoAVL<T> balanceToRight(NodoAVL<T> node){
		NodoAVL<T> son = node.getLeft();
		if (son.getBf() == -1){
			node.setBf(0);
			son.setBf(0);
			node = rotateSR(node);
		}
		else if (son.getBf() == 1) {
			NodoAVL<T> gSon = son.getRight();
			switch(gSon.getBf()) {
			case 1: node.setBf(0); son.setBf(1); break;
			case 0: node.setBf(0); son.setBf(0); break;
			case -1: node.setBf(-1); son.setBf(0); break;
			}
			gSon.setBf(0);
			
			node.setLeft(rotateSL(son));
			node = rotateSR(node);
		}
		return node;
	}

	private NodoAVL<T> balanceToLeft(NodoAVL<T> node){
		NodoAVL<T> son = node.getRight();
		if (son.getBf() == 1){
			node.setBf(0);
			son.setBf(0);
			node = rotateSL(node);
		}
		else if (son.getBf() == -1) {
			NodoAVL<T> gSon = son.getLeft();
			switch(gSon.getBf()) {
			case -1: node.setBf(0); son.setBf(-1); break;
			case 0: node.setBf(0); son.setBf(0); break;
			case 1: node.setBf(1); son.setBf(0); break;
			}
			gSon.setBf(0);
			
			node.setRight(rotateSR(son));
			node = rotateSL(node);
		}
		return node;
	}
	
	private NodoAVL<T> rotateSL(NodoAVL<T> node){
		NodoAVL<T> son = node.getRight();
		node.setRight(son.getLeft());
		son.setLeft(node);
		node = son;
		return node;
	}
	
	private NodoAVL<T> rotateSR(NodoAVL<T> node){
		NodoAVL<T> son = node.getLeft();
		node.setLeft(son.getRight());
		son.setRight(node);
		node = son;
		return node;
	}

	private boolean isLeaf(NodoAVL<T> current) {
		return current.getLeft() == null && current.getRight() == null;
	}

}