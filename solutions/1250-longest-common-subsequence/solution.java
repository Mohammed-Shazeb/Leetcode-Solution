class Solution {
    static int dp[][] = new int[1001][1001];
    public int lcs(String x, String y, int n, int m) {
        if (n == 0 || m == 0)
            return 0;
        if (dp[n][m] != -1)
            return dp[n][m];

        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            dp[n][m] = 1 + lcs(x, y, n - 1, m - 1);
            return dp[n][m];
        } else {
            dp[n][m] = Math.max(lcs(x, y, n, m - 1), lcs(x, y, n - 1, m));
            return dp[n][m];
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        // int dp[][] = new int[n + 1][m + 1];

        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }

        return lcs(text1, text2, n, m);
    }
}
