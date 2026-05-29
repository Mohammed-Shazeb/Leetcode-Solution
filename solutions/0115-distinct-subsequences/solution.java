class Solution {
    // public int lcsTab(String x, String y, int n, int m, int dp[][]) {
    //     for (int i = 0; i < m; i++) {
    //         dp[0][i] = 0;
    //     }
    //     for (int j = 0; j < n; j++) {
    //         dp[j][0] = 0;
    //     }

    //     for (int i = 1; i < n + 1; i++) {
    //         for (int j = 1; j < m + 1; j++) {
    //             if (x.charAt(i - 1) == y.charAt(j - 1)) {
    //                 dp[i][j] = 1 + dp[i - 1][j - 1];
    //             } else {
    //                 dp[i][j] = dp[i - 1][j];
    //             }
    //         }
    //     }

    //     return dp[n][m];
    // }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}
