class Solution {
    public int maxConsistentColumns(int[][] grid, int limit) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        int ans = 1;

        for (int j = 0; j < n; j++) {
            dp[j] = 1;

            for (int i = 0; i < j; i++) {

                boolean ok = true;

                for (int r = 0; r < m; r++) {
                    if (Math.abs(grid[r][j] - grid[r][i]) > limit) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }

            ans = Math.max(ans, dp[j]);
        }

        return ans;
    }
}
