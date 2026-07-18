class Solution {
    int[][] direction = {
            { 1, 0 }, // down
            { -1, 0 }, // up
            { 0, 1 }, // right
            { 0, -1 } // left
    };
    static final int MOD = 1_000_000_007;

    public int dfs(int[][] matrix, int i, int j, int r, int c, Integer dp[][]) {
        long length = 1;

        if (dp[i][j] != null)
            return dp[i][j];

        for (int dir[] : direction) {
            int nr = i + dir[0];
            int nc = j + dir[1];

            if (nr < 0 || nr >= r || nc < 0 || nc >= c)
                continue;

            if (matrix[nr][nc] < matrix[i][j]) {
                length = (length + dfs(matrix, nr, nc, r, c, dp))%MOD;
            }
        }
        dp[i][j] = (int) length;
        return dp[i][j];
    }

    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer dp[][] = new Integer[m ][n];

        long ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = (ans + dfs(grid, i, j, m, n, dp)) % MOD;
            }
        }

        return (int) ans;

    }
}
