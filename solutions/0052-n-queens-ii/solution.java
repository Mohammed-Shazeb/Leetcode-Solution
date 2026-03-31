class Solution {
    int count = 0;
    public boolean isSafe(boolean board[][],int row,int col) {
        for(int i=row-1;i>=0;i--){
            if(board[i][col] == true) return false;
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j-- ) {
            if(board[i][j] == true) return false;
        }
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++ ) {
            if(board[i][j] == true) return false;
        }
        return true;
    }
    
    public int nQueen(boolean board[][],int row){
        if(row == board.length){
            count++;
            return 1;
        }
        // int ans = 0;
        for(int j=0;j<board.length;j++){
           if(isSafe(board,row,j)){
                board[row][j] = true;
                nQueen(board, row+1);
                board[row][j] = false;
           }
        }
        // return ans;
        return count;
    }
    
    public int totalNQueens(int n) {
        boolean board[][] = new boolean[n][n];
        return nQueen(board, 0); 
    }
}
