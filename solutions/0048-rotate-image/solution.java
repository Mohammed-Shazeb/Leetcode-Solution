class Solution {
    public void rotate(int[][] matrix) {
        // using no space mat => transpose => reverse it voilla !!!
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse the transpose matrix
        for(int i=0; i<n; i++) {
            int left = 0;
            int right = n-1;
            while(left<right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
