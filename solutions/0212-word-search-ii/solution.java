class Solution {
    class TrieNode {
        TrieNode children[] = new TrieNode[26];
        boolean eow = false;

        TrieNode() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }
    public TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode curr = root;

        for(int level=0; level<word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    int rows, cols;
    int[][] dirs = {
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public void dfs(char[][] board, TrieNode node, int r, int c, List<String> result, String path) {
        

        // Out of bounds check
        if (r < 0 || c < 0 || r >= rows || c >= cols) {
            return;
        }
        char ch = board[r][c];

        if(ch == '#' || node.children[ch-'a'] == null) return;

        node = node.children[ch - 'a']; // move down the Trie
        path += ch;
        
        if (node.eow) {
            result.add(path);
            node.eow = false; // avoid duplicates
        }

        board[r][c] = '#';           

        // Explore all 4 directions
        for (int[] d : dirs) {
            dfs(board, node, r + d[0], c + d[1], result, path);
        }

        board[r][c] = ch;
    }
    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        cols = board[0].length;

        // Build Trie
        for(String word : words) insert(word);

        List<String> result = new ArrayList<>();
        // Start DFS from every cell
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                dfs(board, root, i, j, result, "");
            }
        }
        return result;
    }
}
