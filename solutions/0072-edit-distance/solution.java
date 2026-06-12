class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n + 1][m + 1];
    
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // in diff case add, del, replace
                    int add = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;
                    int rep = dp[i - 1][j - 1] + 1;
                    dp[i][j] =  Math.min(Math.min(add, del), rep);
                }
            }
        }
        return dp[n][m];
    }
}
