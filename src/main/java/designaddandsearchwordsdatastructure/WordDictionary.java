package designaddandsearchwordsdatastructure;

class Node {
    char c;
    Node[] children = new Node[26];
    boolean isTerminal = false;

    public Node(char c) {
        this.c = c;
    }
}
public class WordDictionary {
    Node root;
    public WordDictionary() {
       this.root = new Node('\0');
    }

    public void addWord(String word) {
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
        return dfs(this.root, 0, word);
    }

    private boolean dfs(Node curr, int i, String word) {
        for (int j = i; j < word.length(); j++) {
            char c = word.charAt(j);
            if (c == '.') {
                for (Node child : curr.children) {
                    if (child != null && dfs(child, j + 1, word)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (curr.children[c - 'a'] == null) {
                    return false;
                }
                curr = curr.children[c - 'a'];
            }
        }
        return curr.isTerminal;
    }
}
