class Solution {
    boolean[][] visited;
    int rows, cols;

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;
        visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
}
