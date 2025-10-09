class Solution {
    public static void printMatrix(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char[][] board, int row, int col, char digits) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == digits) return false;
            if (board[row][i] == digits) return false;
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for(int i=startRow; i<=startRow + 2;i++){
            for(int j=startCol; j<=startCol + 2;j++){
                if (board[i][j] == digits) return false;                
            }
        }
        return true;
    }

    public static boolean sudokuSolver(char board[][], int row, int col){
        if (row == 9) {
            return true;
        }
        int newRow = row, newCol = col + 1;
        if (newCol == 9) {
            newRow = row + 1;
            newCol = 0;
        }
        if (board[row][col] == '.') {
            for (char digits = '1'; digits <= '9'; digits++) {
                if (isSafe(board, row, col, digits)) {
                    board[row][col] = digits;
                    if(sudokuSolver(board, newRow, newCol)) return true;
                    board[row][col] = '.';
                }
            }
        } else {
            return sudokuSolver(board, newRow, newCol);
        }
        return false;
    }

    public void solveSudoku(char[][] board){
        sudokuSolver(board, 0, 0);
    }
}
