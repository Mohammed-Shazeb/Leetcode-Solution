class Solution {
    

    public static Boolean isSafe(char board[][],int row,int col){
        for(int i= row-1;i>=0;i--){
            if(board[i][col] == 'Q') return false;
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j-- ){
            if(board[i][j] == 'Q') return false;
        }
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++ ){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
    public static void nQueen(char board[][],int row){
        if(row == board.length){
            // printMatrix(board);
            count++;
            return ;
        }
        for(int j=0;j<board.length;j++){
           if(isSafe(board,row,j)){
            board[row][j] = 'Q';
                nQueen(board, row+1);
                board[row][j] = 'x';
           }
        }

    }
    static int count = 0;
    
    public static int totalNQueens(int n) {
        count = 0;
        char board[][] = new char[n][n];
        nQueen(board, 0);
        return count;
    }

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'x';
            }
        }
        // nQueen(board, 0);
        totalNQueens(n);
        System.out.println("The solution is " + count);
    }


}
