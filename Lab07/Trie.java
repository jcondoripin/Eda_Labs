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
        TrieNode current = root; //Este será nuestro puntero
        for (char c : palabra.toCharArray()) /*Recorre la palabra descompuesta por el CharArray*/{
            int index = c - 'a'; //Calculando indice, restando valores ASCII 
            if (current.children[index] == null) {
                return false; //Si hay un nodo que es null osea que no esta presente, la palabra no eiste
            }
            current = current.children[index];//Seguimos recorriendo el trie
        }
        return current.isEndOfWord;/*En caso de que la ultima letra/nodo si sea termino de palabra, se encontró la palabra ,
        pero si después de recorrer todos los caracteres de la palabra no llegamos a un nodo final, no se encontro la palabra*/
    }

    // Reemplazar una palabra vieja por otra nueva
    public void replace(String palabraVieja, String palabraNueva) {

    }

}

