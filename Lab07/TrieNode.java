package Lab07;

public class TrieNode {

    final int ALPHABET_SIZE = 26;

    TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[ALPHABET_SIZE];
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setIsEndOfWord(boolean a) {
        this.isEndOfWord = a;
    }

}
