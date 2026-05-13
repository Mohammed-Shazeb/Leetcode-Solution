class Solution {
    boolean[][] visited;
    int rows, cols;

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || visited[i][j] || grid2[i][j] == 0) {
            return true;
        }

        visited[i][j] = true;

        boolean valid = true;

        if(grid1[i][j] == 0) valid = false;

        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean left = dfs(grid1, grid2, i, j - 1);
        boolean right = dfs(grid1, grid2, i, j + 1);

        return valid & up & down & left & right;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        rows = grid1.length;
        cols = grid1[0].length;
        int count = 0;
        visited = new boolean[rows][cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(!visited[i][j] && grid2[i][j] == 1) {
                    if(dfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
