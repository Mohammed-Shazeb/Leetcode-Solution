class Solution {

    int rows, cols;
    int[][] dirs = {
            { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
    };

    public boolean dfs(char[][] board, String word, int r, int c, int index) {
        if (index == word.length())
            return true;

        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != word.charAt(index)) {
            return false;
        }
        char temp = board[r][c];
        board[r][c] = '#';

        for(int d[]:dirs) {
            if (dfs(board, word, r + d[0], c + d[1], index + 1)) {
                return true;
            }
        }
        board[r][c] = temp;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;

        // Try starting from every cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}

