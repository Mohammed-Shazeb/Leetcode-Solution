class Solution {
    int[][] direction = {
            { 1, 0 }, // down
            { -1, 0 }, // up
            { 0, 1 }, // right
            { 0, -1 } // left
    };
    
    public int dfs(int[][] matrix, int i, int j, int r, int c, Integer dp[][]) {
        int length = 1;

        if(dp[i][j] != null) return dp[i][j];

        for (int dir[] : direction) {
            int nr = i + dir[0];
            int nc = j + dir[1];

            if (nr < 0 || nr >= r || nc < 0 || nc >= c)
                continue;

            if (matrix[nr][nc] > matrix[i][j]) {
                length = Math.max(length, 1 + dfs(matrix, nr, nc, r, c, dp));
            }
        }
        return dp[i][j] = length;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Integer dp[][] = new Integer[m+1][n+1];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max( ans,dfs(matrix, i, j, m, n, dp));
            }
        }

        return ans;
    }
}
