class Solution {
    public int lcs(int[] nums1, int[] nums2, int n, int m, int dp[][]) {
        for (int i = 0; i < m; i++) {
            dp[0][i] = 0;
        }
        for (int j = 0; j < n; j++) {
            dp[j][0] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];

    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int dp[][] = new int[n+1][m+1];

        return lcs(nums1, nums2, n, m, dp);
    }
}
