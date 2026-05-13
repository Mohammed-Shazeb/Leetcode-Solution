class Solution {
    boolean visited[][];
    int rows, cols;

    public void dfs(char board[][], int i, int j) {
        if(i<0 || i>=rows || j<0 || j>= cols || visited[i][j] || board[i][j] == '.') return;

        visited[i][j] = true;

        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }
    public int countBattleships(char[][] board) {
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];        
        int count = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(!visited[i][j] && board[i][j] == 'X') {
                    count++;
                    dfs(board, i, j);
                }
            }
        }
        return count;
    }
}
