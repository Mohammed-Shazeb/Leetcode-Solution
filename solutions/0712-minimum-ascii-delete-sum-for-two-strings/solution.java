class Solution {
    public static int lcs(String x, String y, int n, int m, int dp[][]) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = x.charAt(i - 1) + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];

        int totalSumX = 0;
        for (char ch : s1.toCharArray()) {
            totalSumX += ch;
        }
        int totalSumY = 0;
        for (char ch : s2.toCharArray()) {
            totalSumY += ch;
        }

        int commonAsciiSum = lcs(s1, s2, n, m, dp);
        return totalSumX + totalSumY - 2 * commonAsciiSum;
    }
}
