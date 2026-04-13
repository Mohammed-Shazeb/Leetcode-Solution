class Solution {
    boolean[][] visited;
    int rows, cols;
    
        
    public void dfsUtil(char grid[][], int i, int j) {
        // Boundary + visited check
        if (i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j] || grid[i][j] == '0') {
            return;
        }

        visited[i][j] = true;

        // SAME as exploring neighbors in graph
        dfsUtil(grid, i + 1, j); // down
        dfsUtil(grid, i - 1, j); // up
        dfsUtil(grid, i, j + 1); // right
        dfsUtil(grid, i, j - 1); // left
    }

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        int count = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfsUtil(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
