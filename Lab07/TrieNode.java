package Lab07;

public class TrieNode {

    final int ALPHABET_SIZE = 26;

    TrieNode[] children;
    boolean isEndOfWord;
    
    public TrieNode() {
        this.children = new TrieNode[ALPHABET_SIZE];
    }

}
