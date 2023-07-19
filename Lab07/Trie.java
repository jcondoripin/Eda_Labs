package Lab07;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insertar una palabra en el Trie
    public void insert(String palabra) {

    }

    // Buscar si una palabra existe en el Trie
    public boolean search(String palabra) {
        return false;
    }

    // Reemplazar una palabra vieja por otra nueva
    public void replace(String palabraVieja, String palabraNueva) {

    }

    // Elimina una palabra 
    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode nodo, String palabra, int index) {
        if (index == palabra.length()) { // No hay más caracteres por comparar
            if (!nodo.isEndOfWord) { // La palabra individual no existe, sino es prefijo de otra
                return false; // No puede eliminar el ultimo caracter, por sus descendientes
            }
            nodo.isEndOfWord = false; // Palabra individual existe 
            return isNodeEmpty(nodo); // Si se eliminó el nodo, entonces la palabra también
        }

        char c = palabra.charAt(index);
        int posAscii = c - 'a'; // Cambio a posición ascii
        TrieNode child = nodo.children[posAscii];
        if (child == null) { // El nodo no posee el caracter siguiente
            return false; // No encontro la palabra
        }

        // El hijo posee la letra siguiente
        boolean childDelete = delete(child, palabra, index + 1);

        if (childDelete) {
            nodo.children[posAscii] = null; // Elimina su ultimo caracter
            return isNodeEmpty(nodo);
        }

        return false;
    }

    private boolean isNodeEmpty(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

}

