class Solution {
    // int dp[][];
    public int solve(int i, int j, int m, int n, Integer dp[][]) {
        if(i == m-1 && j == n-1) return 1;

        if(i<0 || i>=m || j<0 || j>=n) return 0;

        if(dp[i][j] != null) return dp[i][j];

        int down = solve(i+1, j, m, n, dp);
        int right = solve(i, j+1, m, n, dp);

        dp[i][j] = down + right;
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        Integer dp[][] = new Integer[m][n];
        return solve(0, 0, m, n, dp);
    }
}
