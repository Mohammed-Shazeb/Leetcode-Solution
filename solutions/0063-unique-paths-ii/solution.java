class Solution {
    public int solve(int grid[][], int i, int j, int m, int n, Integer dp[][]) {

        if(i<0 || i>=m || j<0 || j>=n) return 0;

        if (grid[i][j] == 1 || grid[m-1][n-1] == 1 )return 0;

        if(dp[i][j] != null) return dp[i][j];

        if(i == m-1 && j == n-1) return 1;
        
        int down = solve(grid,i+1, j, m, n, dp);
        int right = solve(grid,i, j+1, m, n, dp);

        return dp[i][j] = down + right;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Integer dp[][] = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return solve(obstacleGrid, 0, 0, obstacleGrid.length, obstacleGrid[0].length, dp);
    }
}
