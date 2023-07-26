package Lab07;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insertText(String text) {
        String[] words = text.split("\\s+"); // Separar el texto en palabras usando espacios como delimitadores

        for (String word : words) {
            insert(word.toLowerCase()); // Insertar cada palabra en minúsculas en el Trie
        }
    }

    // Insertar una palabra en el Trie
    public void insert(String palabra) {
        TrieNode current = root;
        for (char c : palabra.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.setIsEndOfWord(true);
    }

    // Buscar si una palabra existe en el Trie
    public boolean search(String palabra) {
        TrieNode current = root; // Este será nuestro puntero
        for (char c : palabra.toCharArray()) /* Recorre la palabra descompuesta por el CharArray */ {
            int index = c - 'a'; // Calculando indice, restando valores ASCII
            if (current.children[index] == null) {
                return false; // Si hay un nodo que es null osea que no esta presente, la palabra no eiste
            }
            current = current.children[index];// Seguimos recorriendo el trie
        }
        return current.isEndOfWord();/*
                                      * En caso de que la ultima letra/nodo si sea termino de palabra, se encontró la
                                      * palabra ,
                                      * pero si después de recorrer todos los caracteres de la palabra no llegamos a
                                      * un nodo final, no se encontro la palabra
                                      */
    }

    // Reemplazar una palabra vieja por otra nueva
    public void replace(String palabraVieja, String palabraNueva) {
        this.delete(palabraVieja);
        this.insert(palabraNueva);
    }

    // Elimina una palabra
    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode nodo, String palabra, int index) {
        if (index == palabra.length()) { // No hay más caracteres por comparar
            if (!nodo.isEndOfWord()) { // La palabra individual no existe, sino es prefijo de otra
                return false; // No puede eliminar el ultimo caracter, por sus descendientes
            }
            nodo.setIsEndOfWord(false); // Palabra individual existe
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

    @Override
    public String toString() {
        return traverseTrie(root, "");
    }

    private String traverseTrie(TrieNode node, String currentWord) {
        String result = "";

        if (node.isEndOfWord()) {
            result += currentWord + " ";
        }

        for (int i = 0; i < 26; i++) {
            TrieNode child = node.children[i];

            if (child != null) {
                char ch = (char) ('a' + i);
                String newWord = currentWord + ch;

                String wordsFromChild = traverseTrie(child, newWord);

                result += wordsFromChild;
            }
        }

        return result;
    }
}
