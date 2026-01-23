class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solution = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        } 

        backtrack(board, 0, solution);
        return solution;
    }


    public void backtrack(char[][] board, int row, List<List<String>> solutions) {
        if(row == board.length) {
            solutions.add(convertReturnFormat(board));
        }else {
            for(int i = 0; i < board.length; i++){
                if(isSafe(board, row, i)){
                    board[row][i] = 'Q';
                    backtrack(board, row+1, solutions);
                    board[row][i] = '.';
                }
            }
        }
    }

    public boolean isSafe(char board[][], int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


    public List<String> convertReturnFormat(char[][] board){
        List<String> solution = new ArrayList<>();

        for(char[] row : board){
            solution.add(new String(row));
        }

        return solution;
    }


}
