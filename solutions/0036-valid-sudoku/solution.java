class Solution {

    public static boolean isSafe(char[][] board, int row, int col, char digits) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digits && i!=row) return false;
            if (board[row][i] == digits && i!=col) return false;
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for(int i=startRow; i<=startRow + 2;i++){
            for(int j=startCol; j<=startCol + 2;j++){
                if (board[i][j] == digits && !(i == row && j == col)) return false;                
            }
        }
        return true;
    }

    public static boolean sudoku(char board[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                else{
                    if(!isSafe(board,i,j,board[i][j])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        return sudoku(board);
    }
}
