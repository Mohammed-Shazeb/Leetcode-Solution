class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean eow = false;
}

class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(TrieNode node, String word, int index) {
        if (node == null)
            return false;
        if (index == word.length())
            return node.eow;

        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode child : node.children) {
                if (searchHelper(child, word, index + 1)) return true;
            }
            return false;
        } else {
            int idx = c - 'a';
            return searchHelper(node.children[idx], word, index + 1);
        }
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
