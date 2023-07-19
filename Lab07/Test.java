package Lab07;

public class Test {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("orange");

        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("orange"));  // true
        System.out.println(trie.search("pear"));    // false

        trie.replace("apple", "grape");
        System.out.println(trie.search("apple"));   // false
        System.out.println(trie.search("grape"));   // true

        trie.delete("banana");
        System.out.println(trie.search("banana"));  // false
    }
}