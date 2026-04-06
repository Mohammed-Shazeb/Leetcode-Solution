class Solution {
    class TrieNode {
        TrieNode children[] = new TrieNode[26];
        boolean eow = false;
       
        TrieNode() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode curr = root;

        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    private int helper(int start, String s, Set<String> dict, int dp[]) {
        if (start == s.length()) return 0;

        if (dp[start] != -1) return dp[start];

        int ans = 1 + helper(start + 1, s, dict, dp);

        TrieNode node = root;

        for (int i = start; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (node.children[ch - 'a'] == null) break;

            node = node.children[ch - 'a'];

            if (node.eow) {
                ans = Math.min(ans, helper(i + 1, s, dict, dp));
            }
        }
        dp[start] = ans;
        return ans;
    }

    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);

        for (String word : dictionary) insert(word);
        return helper(0, s, dict, dp);
    }
}
