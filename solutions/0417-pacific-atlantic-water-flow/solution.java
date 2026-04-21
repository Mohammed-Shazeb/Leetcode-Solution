class Solution {
    private int m, n;
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // r = 0 => all col
        for(int i=0; i<n; i++) dfs(0, i, heights, pacific);
        // c = 0 
        for(int i=0; i<m; i++) dfs(i, 0, heights, pacific);
        // r = m-1
        for(int i=0; i<n; i++) dfs(m-1, i, heights, atlantic);
        // c = n-1
        for(int i=0; i<m; i++) dfs(i, n-1, heights, atlantic);

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
        
    }
    private void dfs(int r, int c, int[][] heights, boolean[][] visited) {
        if(visited[r][c]) return;
        visited[r][c] = true;

        for(int dir[] : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
            if(heights[nr][nc] < heights[r][c]) continue;
            dfs(nr, nc, heights, visited);
        }
    }
}
