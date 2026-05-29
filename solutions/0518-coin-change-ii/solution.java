class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n + 1][amount + 1];
        
        for (int i = 0; i < dp[0].length; i++) { // 0th row
            dp[0][i] = 0;
        }
        for (int i = 0; i < dp.length; i++) { // 0th col
            dp[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                int v = coins[i - 1];
                if (v <= j) {
                    dp[i][j] = dp[i][j - v] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
