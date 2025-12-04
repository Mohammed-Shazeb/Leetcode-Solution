class NumMatrix {

    private int[][] pre; // prefix sum grid (rows+1 x cols+1)

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            pre = new int[1][1];
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        pre = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                pre[i][j] = matrix[i - 1][j - 1] + pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return pre[row2 + 1][col2 + 1] - pre[row1][col2 + 1] - pre[row2 + 1][col1] + pre[row1][col1];

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
