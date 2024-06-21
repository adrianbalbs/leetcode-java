package implementtrie;

class Node {
    char c;
    Node[] children = new Node[26];
    boolean isTerminal = false;
    public Node(char c) {
        this.c = c;
    }
}
public class Trie {
    Node root;

    public Trie() {
        this.root = new Node('\0');
    }

    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Node(c);
            }
            curr = curr.children[c - 'a'];
        }
        curr.isTerminal = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isTerminal;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }
}

