class Solution {
    static int dp[][] = new int[1001][1001];
    public static int lcsTab(String x, String y, int n, int m, int dp[][]) {
        for(int i=0; i<m; i++) {
            dp[0][i] = 0;
        }
        for(int j=0; j<n; j++) {
            dp[j][0] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m]; 
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n + 1][m + 1];

        return lcsTab(text1, text2, n, m, dp);
    }
}
