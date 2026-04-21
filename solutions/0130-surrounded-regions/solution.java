class Solution {
    private int m, n;
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        // r = 0 => all col
        for(int i=0; i<n; i++) dfs(0, i, board);
        // c = 0 
        for(int i=0; i<m; i++) dfs(i, 0, board);
        // r = m-1
        for(int i=0; i<n; i++) dfs(m-1, i, board);
        // c = n-1
        for(int i=0; i<m; i++) dfs(i, n-1, board);


        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'S') board[i][j] = 'O';
            }
        }
    }
    private void dfs(int r, int c, char[][] board) {
        if(r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') return;

        board[r][c] = 'S'; // safe

        for(int[] dirs : directions) {
            dfs(r + dirs[0], c + dirs[1], board);
        }
    }
}
