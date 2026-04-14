class Solution {
    boolean[][] visited;
    int rows, cols;
    int countOne;
    int maxCount = 0;
    
        
    public void dfsUtil(int grid[][], int i, int j) {
        // Boundary + visited check
        if (i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j] || grid[i][j] == 0) {
            return;
        }

        visited[i][j] = true;
        countOne++;

        // SAME as exploring neighbors in graph
        dfsUtil(grid, i + 1, j); // down
        dfsUtil(grid, i - 1, j); // up
        dfsUtil(grid, i, j + 1); // right
        dfsUtil(grid, i, j - 1); // left
    }


    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        int res = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    countOne = 0;
                    dfsUtil(grid, i, j);
                    res = Math.max(res, countOne);
                    
                }
            }
        }
        return res;
        
    }
}
